package action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.BoardDeleteProService;
import vo.ActionForward;
//글 삭제하는 Action클래스
public class BoardDeleteProAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			throws Exception{	 

		ActionForward forward = null;
		int board_num = Integer.parseInt
						(request.getParameter("board_num"));
		String nowPage = request.getParameter("page");
		BoardDeleteProService boardDeleteProService = 
									new BoardDeleteProService();
		//글쓴이가 맞는지 확인하는 부분
		boolean isArticleWriter =
				boardDeleteProService.isArticleWriter
					(board_num, request.getParameter("BOARD_PASS"));
		//글쓴이가 아니라면..즉 비밀번호가 일치하는 않는다면...	
		//과제 1.
		//boolean isArticleWriter
		//	(board_num, request.getParameter("BOARD_PASS")) 메서드 구현
		//boardDAO.isArticleBoardWriter(board_num, pass) 호출
		//과제 2.
		//boolean boardDeleteProService.removeArticle(board_num);
		//메서드 구현
		//int boardDAO.deleteArticle(board_num); 구현후 호출함.
		if(!isArticleWriter){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제할 권한이 없습니다');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		//글쓴이가 맞다면...
		else{		
			//삭제하는 부분
			boolean isDeleteSuccess = 
					boardDeleteProService.removeArticle(board_num);
			//삭제에 성공을 하지 않았다면...
			if(!isDeleteSuccess){
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('삭제실패');");
				out.println("history.back();");
				out.println("</script>");
				out.close();
			}
			//삭제 성공했다면...경로지정후 경로를 리턴하고 있다. 
			else{
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("boardList.bo?page=" + nowPage);
			}			
		}
		return forward;
	}
}