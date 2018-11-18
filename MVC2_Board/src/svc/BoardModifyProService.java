package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import vo.BoardBean;
import dao.BoardDAO;

public class BoardModifyProService {
	//게시번호에 맞는 글과 사용자 입력한 패스워드를 가지고 게시글을 작성한 사람인지 확인하는 것 
	public boolean isArticleWriter(int board_num, String pass) 
			throws Exception {	
		boolean isArticleWriter = false;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		//DAO객체 isArticleBoardWriter()호출해서 확인한다.
		isArticleWriter = boardDAO.isArticleBoardWriter
										(board_num, pass);
		close(con);
		return isArticleWriter;		
	}
	//넘어온 게시글을 수정하는 부분
	public boolean modifyArticle(BoardBean article)
			throws Exception {		
		boolean isModifySuccess = false;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		//DAO객체의 updateArticle()호출해서 작업 수행
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