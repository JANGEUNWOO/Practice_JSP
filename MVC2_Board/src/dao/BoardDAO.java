package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import static db.JdbcUtil.*;

import javax.sql.DataSource;

import vo.BoardBean;

//DB�� �����Ͽ� ����� �����ϴ� Ŭ����
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

	// ���� ���� ���ϱ�
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
			System.out.println("getListCount ����:" + e.toString());
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}

	// �� ���
	public int insertArticle(BoardBean article) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num = 0;
		String sql = "";
		int insertCount = 0;

		try {
			// �Խ��� �Խñ��� �ֻ��� ��ȣ�� �������� ����
			pstmt = con.prepareStatement("select max(board_num) from board");
			rs = pstmt.executeQuery();
			// ���� �ϳ��� �����Ѵٸ� .. �� ������ �ֻ��� ��ȣ���� +1�� �ؼ� nu, ����
			if (rs.next()) {
				num = rs.getInt(1) + 1;
				// ���� �Ѱ��� ���ٸ�... ���� ���� ���� �ݵ�� 1���� �Խñ��� �ǹǷ�
				// num�� 1�� �����ϴ� �κ�.
			} else {
				num = 1;
			}
			sql = "insert into board(BOARD_NUM, BOARD_NAME, BOARD_PASS,";
			sql += "BOARD_SUBJECT,BOARD_CONTENT, BOARD_FILE,"
					+ "BOARD_RE_REF,BOARD_RE_LEV,BOARD_RE_SEQ,BOARD_READCOUNT,"
					+ "BOARD_DATE) values(?,?,?,?,?,?,?,?,?,?,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num); // �Խñ۹�ȣ
			pstmt.setString(2, article.getBOARD_NAME()); // �ۼ���
			pstmt.setString(3, article.getBOARD_PASS()); // ��ȣ
			pstmt.setString(4, article.getBOARD_SUBJECT()); // ����
			pstmt.setString(5, article.getBOARD_CONTENT()); // ����
			pstmt.setString(6, article.getBOARD_FILE()); // ÷������
			pstmt.setInt(7, num); // ���� �۹�ȣ
			pstmt.setInt(8, 0); // �亯�� ����
			pstmt.setInt(9, 0); // �亯���� ��¼��� �����ϴ� �÷�
			pstmt.setInt(10, 0); // �Խñ� ��ȸ��

			insertCount = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("boardInsert ����: " + e.toString());
		} finally {
			close(rs);
			close(pstmt);
		}
		return insertCount;
	}

	// �� ��� ����
	public ArrayList<BoardBean> selectArticleList(int page, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String board_list_sql = "select * from board order by" + " BOARD_RE_REF desc, BOARD_RE_SEQ asc limit ? ,10";
		ArrayList<BoardBean> articleList = new ArrayList<BoardBean>();
		BoardBean board = null;
		int startrow = (page - 1) * 10; // �б� ������ row��ȣ..

		try {
			pstmt = con.prepareStatement(board_list_sql);
			// startrow �Խñ� ��ȣ�� �Ҵ��ϴ� ��
			pstmt.setInt(1, startrow);
			rs = pstmt.executeQuery();
			// �����ð� �ִ���
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

				// BoardBean�ϳ��� ��ü�� ArrayList�� �߰��ϰ� �ִ�.
				articleList.add(board);
			}
		} catch (Exception e) {
			System.out.println("getBoardList ����:" + e.toString());

		} finally {
			close(rs);
			close(pstmt);
		}
		return articleList;

	}

	// �� �亯

}
