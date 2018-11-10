package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.BoardDAO;
import vo.BoardBean;

public class BoardWriteProService {

	public boolean registArticle(BoardBean boardBean) throws Exception{
		
		boolean isWriteSuccess=false;
		Connection con=getConnection(); //DB����
		//DAO�ν��Ͻ��� �������� �ִ�(�̱���)
		BoardDAO boardDAO=BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int insertCount=boardDAO.insertArticle(boardBean);
		//�Խñ��� ����� �Ǿ��ٸ�..
		if(insertCount>0) {
			commit(con); //DB �� �������� ������ �����϶�.
			isWriteSuccess=true;
		}
		//�Խñ��� ��ϵ��� �ʾҴٸ�...
		else {
			rollback(con); //�ٽ� �ѹ��ض�
			
		}
		
		close(con);
		return isWriteSuccess;
		
	}
	
}
