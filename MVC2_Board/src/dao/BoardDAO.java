package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import static db.JdbcUtil.*;

import javax.sql.DataSource;

import vo.BoardBean;

//DB에 접속하여 명령을 수행하는 클래스
public class BoardDAO {

	DataSource ds;
	Connection con;
	private static BoardDAO boardDAO;

	private BoardDAO() {

	}

	public static BoardDAO getInstance() {
		if (boardDAO == null) {
			boardDAO = new BoardDAO();
		}
		return boardDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	// 글의 개수 구하기
	public int selectListCount() {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			System.out.println("getConnection");
			pstmt = con.prepareStatement("select count(*) from board");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("getListCount 에러:" + e.toString());
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}

	// 글 등록
	public int insertArticle(BoardBean article) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num = 0;
		String sql = "";
		int insertCount = 0;

		try {
			// 게시판 게시글의 최상위 번호를 가져오는 쿼리
			pstmt = con.prepareStatement("select max(board_num) from board");
			rs = pstmt.executeQuery();
			// 글이 하나라도 존재한다면 .. 그 가격은 최상위 번호에서 +1를 해서 nu, 저장
			if (rs.next()) {
				num = rs.getInt(1) + 1;
				// 글이 한개도 없다면... 지금 쓰는 글은 반드시 1번쨰 게시글이 되므로
				// num을 1로 설정하는 부분.
			} else {
				num = 1;
			}
			sql = "insert into board(BOARD_NUM, BOARD_NAME, BOARD_PASS,";
			sql += "BOARD_SUBJECT,BOARD_CONTENT, BOARD_FILE,"
					+ "BOARD_RE_REF,BOARD_RE_LEV,BOARD_RE_SEQ,BOARD_READCOUNT,"
					+ "BOARD_DATE) values(?,?,?,?,?,?,?,?,?,?,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num); // 게시글번호
			pstmt.setString(2, article.getBOARD_NAME()); // 작성자
			pstmt.setString(3, article.getBOARD_PASS()); // 암호
			pstmt.setString(4, article.getBOARD_SUBJECT()); // 제목
			pstmt.setString(5, article.getBOARD_CONTENT()); // 내용
			pstmt.setString(6, article.getBOARD_FILE()); // 첨부파일
			pstmt.setInt(7, num); // 관련 글번호
			pstmt.setInt(8, 0); // 답변글 레벨
			pstmt.setInt(9, 0); // 답변글의 출력순서 결정하는 컬럼
			pstmt.setInt(10, 0); // 게시글 조회수

			insertCount = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("boardInsert 에러: " + e.toString());
		} finally {
			close(rs);
			close(pstmt);
		}
		return insertCount;
	}

	// 글 목록 보기
	public ArrayList<BoardBean> selectArticleList(int page, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String board_list_sql = "select * from board order by" + " BOARD_RE_REF desc, BOARD_RE_SEQ asc limit ? ,10";
		ArrayList<BoardBean> articleList = new ArrayList<BoardBean>();
		BoardBean board = null;
		int startrow = (page - 1) * 10; // 읽기 시작할 row번호..

		try {
			pstmt = con.prepareStatement(board_list_sql);
			// startrow 게시글 번호를 할당하는 것
			pstmt.setInt(1, startrow);
			rs = pstmt.executeQuery();
			// 가져올게 있느냐
			while (rs.next()) {
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

				// BoardBean하나의 객체를 ArrayList에 추가하고 있다.
				articleList.add(board);
			}
		} catch (Exception e) {
			System.out.println("getBoardList 에러:" + e.toString());

		} finally {
			close(rs);
			close(pstmt);
		}
		return articleList;

	}

	// 글 답변

}
