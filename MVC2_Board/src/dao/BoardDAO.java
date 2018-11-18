package dao;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import vo.BoardBean;
//DB에 접속하여 명령을 수행하는 클래스
public class BoardDAO {
	DataSource ds;
	Connection con;
	private static BoardDAO boardDAO;

	private BoardDAO() {
	}
	
	public static BoardDAO getInstance(){
		if(boardDAO == null){
			boardDAO = new BoardDAO();
		}
		return boardDAO;
	}

	public void setConnection(Connection con){
		this.con = con;
	}
	//글의 개수 구하기.
	public int selectListCount() {
		int listCount= 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			System.out.println("getConnection");
			pstmt=con.prepareStatement("select count(*) from board");
			rs = pstmt.executeQuery();
			if(rs.next()){
				listCount = rs.getInt(1);
			}
		}
		catch(Exception e){
			System.out.println("getListCount 에러: " + e.toString());			
		}
		finally{
			close(rs);
			close(pstmt);
		}
		return listCount;
	}
	//글 목록 보기.	
	public ArrayList<BoardBean> selectArticleList(int page,int limit){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//이 쿼리에 목적은 한 페이지 나타내는 게시글을 ?(출발 게시글), 10개까지 나타낼수 있도록
		String board_list_sql = "select * from board order by BOARD_RE_REF desc,BOARD_RE_SEQ asc limit ? , 10";
		ArrayList<BoardBean> articleList = new ArrayList<>();
		BoardBean board = null;
		int startrow = (page - 1) * 10; //읽기 시작할 row 번호..

		try{
			pstmt = con.prepareStatement(board_list_sql);
			//startrow 읽기 시작할 게시글 번호를 할당하는 것
			pstmt.setInt(1, startrow);
			rs = pstmt.executeQuery();
			//가져올게 있느냐
			while(rs.next()){
				//하나의 게시글을 담을 DTO객체인 BoardBean인스턴스를 생성하고 있다.
				board = new BoardBean();
				board.setBOARD_NUM(rs.getInt("BOARD_NUM"));
				board.setBOARD_NAME(rs.getString("BOARD_NAME"));
				board.setBOARD_SUBJECT(rs.getString("BOARD_SUBJECT"));
				board.setBOARD_CONTENT(rs.getString("BOARD_CONTENT"));
				board.setBOARD_FILE(rs.getString("BOARD_FILE"));
				board.setBOARD_RE_REF(rs.getInt("BOARD_RE_REF"));
				board.setBOARD_RE_LEV(rs.getInt("BOARD_RE_LEV"));
				board.setBOARD_RE_SEQ(rs.getInt("BOARD_RE_SEQ"));
				board.setBOARD_READCOUNT(rs.getInt("BOARD_READCOUNT"));
				board.setBOARD_DATE(rs.getDate("BOARD_DATE"));
				//BoardBean하나의 객체를 ArrayList에 추가하고 있다.
				articleList.add(board);
			}
		}catch(Exception e){
			System.out.println("getBoardList 에러 : " + e.toString());
		}finally{
			close(rs);
			close(pstmt);
		}
		return articleList;
	}
	//글 내용 보기.
	public BoardBean selectArticle(int board_num){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardBean boardBean = null;
		try{
			pstmt = con.prepareStatement(
					"select * from board where BOARD_NUM = ?");
			pstmt.setInt(1, board_num);
			rs= pstmt.executeQuery();

			if(rs.next()){
				boardBean = new BoardBean();
				boardBean.setBOARD_NUM(rs.getInt("BOARD_NUM"));
				boardBean.setBOARD_NAME(rs.getString("BOARD_NAME"));
				boardBean.setBOARD_SUBJECT(rs.getString("BOARD_SUBJECT"));
				boardBean.setBOARD_CONTENT(rs.getString("BOARD_CONTENT"));
				boardBean.setBOARD_FILE(rs.getString("BOARD_FILE"));
				boardBean.setBOARD_RE_REF(rs.getInt("BOARD_RE_REF"));
				boardBean.setBOARD_RE_LEV(rs.getInt("BOARD_RE_LEV"));
				boardBean.setBOARD_RE_SEQ(rs.getInt("BOARD_RE_SEQ"));
				boardBean.setBOARD_READCOUNT(rs.getInt("BOARD_READCOUNT"));
				boardBean.setBOARD_DATE(rs.getDate("BOARD_DATE"));
			}
		}catch(Exception e){
			System.out.println("getDetail 에러 : " + e.toString());
		}finally{
			close(rs);
			close(pstmt);
		}
		return boardBean;
	}
	//글 등록.
	public int insertArticle(BoardBean article){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num = 0;
		String sql = "";
		int insertCount = 0;
		try{
			//게시판 게시글의 최상위 번호를 가져오는 쿼리
			pstmt = con.prepareStatement
					("select max(board_num) from board");
			rs = pstmt.executeQuery();
			//글이 하나라도 존재한다면...그 가져온 최상위 번호에서 +1를 해서 num저장
			if(rs.next())
				num =rs.getInt(1)+1;
			//글이 한개도 없다면...지금 쓰는 글은 반드시 1번째 게시글이 되므로
			//num을 1로 설정하는 부분.
			else
				num=1;
			//게시판에 글을 등록하는 쿼리문을 작성하고 있다.
			sql="insert into board (BOARD_NUM,BOARD_NAME,BOARD_PASS,";
			sql+="BOARD_SUBJECT,BOARD_CONTENT,BOARD_FILE,"+
				 "BOARD_RE_REF,BOARD_RE_LEV,BOARD_RE_SEQ,BOARD_READCOUNT,"+
				 "BOARD_DATE) values(?,?,?,?,?,?,?,?,?,?,now())";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);  //게시글 번호
			pstmt.setString(2, article.getBOARD_NAME()); //작성자
			pstmt.setString(3, article.getBOARD_PASS()); //암호
			pstmt.setString(4, article.getBOARD_SUBJECT()); //제목
			pstmt.setString(5, article.getBOARD_CONTENT()); //내용
			pstmt.setString(6, article.getBOARD_FILE());  //첨부파일
			pstmt.setInt(7, num); //관련 글번호
			pstmt.setInt(8, 0);	  //답변글 레벨
			pstmt.setInt(9, 0);   //답변글의 출력순서 결정하는 컬럼 
			pstmt.setInt(10, 0);  //게시글 조회수

			insertCount = pstmt.executeUpdate();

		}catch(Exception e){
			System.out.println("boardInsert 에러 : "+e.toString());
		}
		finally{
			close(rs);
			close(pstmt);
		}
		return insertCount;
	}
	//글 답변.
	public int insertReplyArticle(BoardBean article){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String board_max_sql = "select max(board_num) from board";
		String sql = "";
		int num = 0;
		int insertCount = 0;
		int re_ref = article.getBOARD_RE_REF();  //관련글
		int re_lev = article.getBOARD_RE_LEV();  //답변글 레벨
		int re_seq = article.getBOARD_RE_SEQ();  //답변글 단계
		try{
			pstmt = con.prepareStatement(board_max_sql);
			rs = pstmt.executeQuery();
			if(rs.next())
				num = rs.getInt(1)+1;
			else 
				num = 1;
			sql="update board set BOARD_RE_SEQ=BOARD_RE_SEQ+1 where BOARD_RE_REF=? ";
			sql+="and BOARD_RE_SEQ = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,re_ref);
			pstmt.setInt(2,re_seq);
			int updateCount=pstmt.executeUpdate();

			if(updateCount > 0){
				commit(con);
			}
			re_seq = re_seq + 1;
			re_lev = re_lev + 1;
			sql="insert into board (BOARD_NUM,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,";
			sql+="BOARD_CONTENT, BOARD_FILE,BOARD_RE_REF,BOARD_RE_LEV,BOARD_RE_SEQ,";
			sql+="BOARD_READCOUNT,BOARD_DATE) values(?,?,?,?,?,?,?,?,?,?,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, article.getBOARD_NAME());
			pstmt.setString(3, article.getBOARD_PASS());
			pstmt.setString(4, article.getBOARD_SUBJECT());
			pstmt.setString(5, article.getBOARD_CONTENT());
			pstmt.setString(6, ""); //답장에는 파일을 업로드하지 않음.
			pstmt.setInt(7, re_ref);
			pstmt.setInt(8, re_lev);
			pstmt.setInt(9, re_seq);
			pstmt.setInt(10, 0);
			insertCount = pstmt.executeUpdate();
		}catch(SQLException e){
			System.out.println("boardReply 에러 : "+e.toString());
		}finally{
			close(rs);
			close(pstmt);
		}
		return insertCount;
	}
	//글 수정하는 메서드.
	public int updateArticle(BoardBean article){
		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql="update board set BOARD_SUBJECT=?,BOARD_CONTENT=? where BOARD_NUM=?";

		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getBOARD_SUBJECT());
			pstmt.setString(2, article.getBOARD_CONTENT());
			pstmt.setInt(3, article.getBOARD_NUM());
			updateCount = pstmt.executeUpdate();
		}catch(Exception e){
			System.out.println("boardModify 에러 : " + e.toString());
		}
		finally{
			close(pstmt);
		}
		return updateCount;
	}
	//글 삭제.
	public int deleteArticle(int board_num){
		PreparedStatement pstmt = null;
		String board_delete_sql = 
						"delete from board where BOARD_num=?";
		int deleteCount = 0;
		try{
			pstmt = con.prepareStatement(board_delete_sql);
			pstmt.setInt(1, board_num);
			deleteCount = pstmt.executeUpdate();
		}catch(Exception e){
			System.out.println("boardDelete 에러 : "+e.toString());
		}
		finally{
			close(pstmt);
		}
		return deleteCount;
	}
	//조회수 업데이트.
	public int updateReadCount(int board_num){

		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql="update board set BOARD_READCOUNT = "+
				"BOARD_READCOUNT+1 where BOARD_NUM = "+board_num;

		try{
			pstmt=con.prepareStatement(sql);
			updateCount = pstmt.executeUpdate();
		}catch(SQLException ex){
			System.out.println("setReadCountUpdate 에러 : "+ex);
		}
		finally{
			close(pstmt);

		}
		return updateCount;
	}

	//글쓴이인지 확인.
	public boolean isArticleBoardWriter(int board_num,String pass){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String board_sql="select * from board where BOARD_NUM=?";
		boolean isWriter = false;
		try{
			pstmt = con.prepareStatement(board_sql);
			pstmt.setInt(1, board_num);
			rs=pstmt.executeQuery();
			//true를 리턴할수 없는 구조이다.
			rs.next();
			if(pass.equals(rs.getString("BOARD_PASS"))){
				isWriter = true;
			}
		}catch(SQLException e){
			System.out.println("isBoardWriter 에러 : "+e.toString());
		}
		finally{
			close(pstmt);
		}
		return isWriter;
	}
}