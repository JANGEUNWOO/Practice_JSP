package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.BoardDetailService;
import vo.ActionForward;
import vo.BoardBean;

 public class BoardDetailAction implements Action {
	 
	 public ActionForward execute(HttpServletRequest request,
			 	HttpServletResponse response) throws Exception{
		//board_num이라는 게시글 번호와 page번호를 request로부터 받는다. 
	   	int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		//BoardDetailService클래스를 만들고 보고자 하는 게시글을 위에서 받은 
		//board_num을 인자값을 주어 getArticle()호출하고 그에 관련된 게시글
		//에 대한 내용을 리턴을 받고 있다.
		BoardDetailService boardDetailService = new BoardDetailService();
		BoardBean article = boardDetailService.getArticle(board_num);
		ActionForward forward = new ActionForward();
		//request객체에다가 page번호와 게시글을 setter를 호출하여 지정하고 있다.
		request.setAttribute("page", page);
	   	request.setAttribute("article", article);
	   	//보여줄 뷰페이지의 경로를 지정하고 리턴하고 있다.
   		forward.setPath("/board/qna_board_view.jsp");
   		return forward;
	 }	 
}