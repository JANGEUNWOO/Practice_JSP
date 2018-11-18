package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.BoardDAO;

public class BoardDeleteProService {
	//글쓴이가 맞는지 확인하는 부분
	public boolean isArticleWriter(int board_num, String pass) throws Exception {
		
		boolean isArticleWriter = false;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		//글쓴이가 맞는지를 확인하기 위해 isArticleBoardWriter()호출
		isArticleWriter = boardDAO.isArticleBoardWriter(board_num, pass);
		close(con);
		
		return isArticleWriter;		
	}
	//게시글을 삭제하는 부분
	public boolean removeArticle(int board_num) throws Exception{
		boolean isRemoveSuccess = false;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		//게시글을 실제 삭제하는 부분인 boardDAO.deleteArticle(board_num)호출
		int deleteCount = boardDAO.deleteArticle(board_num);		
		if(deleteCount > 0){
			commit(con);
			isRemoveSuccess=true;
		}
		else{
			rollback(con);
		}		
		close(con);
		return isRemoveSuccess;
	}
}
