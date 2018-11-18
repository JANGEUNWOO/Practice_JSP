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
		//updateReadCount()인자값으로 넘어가는 해당 게시번호의 글의 
		//조회수를 증가시킨다.
		int updateCount = boardDAO.updateReadCount(board_num);
		//증가가 됐다면, 물리적DB에 commit하고 있다.
		if(updateCount > 0){
			commit(con);
		}
		//그렇치 않다면 롤백해라.
		else{
			rollback(con);
		}		
		//인자값으로 넘긴 board_num에 해당하는 게시글을 가져오고
		//리턴값으로 넘기고 있다.
		article = boardDAO.selectArticle(board_num);
		close(con);
		return article;		
	}
}
