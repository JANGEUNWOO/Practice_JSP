package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import vo.BoardBean;
import dao.BoardDAO;

public class BoardModifyProService {
	//�Խù�ȣ�� �´� �۰� ����� �Է��� �н����带 ������ �Խñ��� �ۼ��� ������� Ȯ���ϴ� �� 
	public boolean isArticleWriter(int board_num, String pass) 
			throws Exception {	
		boolean isArticleWriter = false;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		//DAO��ü isArticleBoardWriter()ȣ���ؼ� Ȯ���Ѵ�.
		isArticleWriter = boardDAO.isArticleBoardWriter
										(board_num, pass);
		close(con);
		return isArticleWriter;		
	}
	//�Ѿ�� �Խñ��� �����ϴ� �κ�
	public boolean modifyArticle(BoardBean article)
			throws Exception {		
		boolean isModifySuccess = false;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		//DAO��ü�� updateArticle()ȣ���ؼ� �۾� ����
		int updateCount = boardDAO.updateArticle(article);		
		if(updateCount > 0){
			commit(con);
			isModifySuccess = true;
		} 
		else{
			rollback(con);
		}		
		close(con);
		return isModifySuccess;		
	}
}