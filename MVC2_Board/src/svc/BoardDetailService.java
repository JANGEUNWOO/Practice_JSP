package svc;
import java.sql.Connection;
import dao.BoardDAO;
import vo.BoardBean;
import static db.JdbcUtil.*;

public class BoardDetailService {

	public BoardBean getArticle(int board_num) throws Exception{		
		BoardBean article = null;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		//updateReadCount()���ڰ����� �Ѿ�� �ش� �Խù�ȣ�� ���� 
		//��ȸ���� ������Ų��.
		int updateCount = boardDAO.updateReadCount(board_num);
		//������ �ƴٸ�, ������DB�� commit�ϰ� �ִ�.
		if(updateCount > 0){
			commit(con);
		}
		//�׷�ġ �ʴٸ� �ѹ��ض�.
		else{
			rollback(con);
		}		
		//���ڰ����� �ѱ� board_num�� �ش��ϴ� �Խñ��� ��������
		//���ϰ����� �ѱ�� �ִ�.
		article = boardDAO.selectArticle(board_num);
		close(con);
		return article;		
	}
}
