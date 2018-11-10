package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.BoardDAO;
import vo.BoardBean;

public class BoardWriteProService {

	public boolean registArticle(BoardBean boardBean) throws Exception{
		
		boolean isWriteSuccess=false;
		Connection con=getConnection(); //DB접속
		//DAO인스턴스를 가져오고 있다(싱글톤)
		BoardDAO boardDAO=BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int insertCount=boardDAO.insertArticle(boardBean);
		//게시글이 등록이 되었다면..
		if(insertCount>0) {
			commit(con); //DB 즉 물리적인 공간에 저장하라.
			isWriteSuccess=true;
		}
		//게시글이 등록되지 않았다면...
		else {
			rollback(con); //다시 롤백해라
			
		}
		
		close(con);
		return isWriteSuccess;
		
	}
	
}
