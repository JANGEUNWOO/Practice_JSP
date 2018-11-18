package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.BoardDAO;
import vo.BoardBean;

public class BoardReplyProService {

	public boolean replyArticle(BoardBean article) throws Exception{
		boolean isReplySuccess = false;
		int insertCount = 0;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		//답변글을 DAO객체를 이용해서 DB에 등록을 하기 위해 insertReplyArticle()
		//를 호출하고 있다.
		insertCount = boardDAO.insertReplyArticle(article);
		
		if(insertCount > 0){
			commit(con);
			isReplySuccess = true;
		}
		else{
			rollback(con);
		}		
		close(con);
		return isReplySuccess;		
	}
}