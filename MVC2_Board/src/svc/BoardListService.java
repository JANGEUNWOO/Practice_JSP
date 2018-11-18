package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;
import dao.BoardDAO;
import vo.BoardBean;

public class BoardListService {
	//총 게시글의 갯수를 가져옴
	public int getListCount() throws Exception{		
		int listCount = 0;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		listCount = boardDAO.selectListCount();
		close(con);
		
		return listCount;		
	}
	//한 페이지에 나타낼 리스트 목록을 가져오는 메서드
	public ArrayList<BoardBean> getArticleList(int page, int limit) 
								throws Exception{		
		ArrayList<BoardBean> articleList = null;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		articleList = boardDAO.selectArticleList(page, limit);
		close(con);
		return articleList;		
	}
}