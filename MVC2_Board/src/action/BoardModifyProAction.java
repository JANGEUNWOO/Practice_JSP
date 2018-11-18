package action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.BoardModifyProService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardModifyProAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			throws Exception{

		ActionForward forward = null;
		boolean isModifySuccess = false;
		int board_num=Integer.parseInt(
					request.getParameter("BOARD_NUM"));
		BoardBean article = new BoardBean();
		BoardModifyProService boardModifyProService = 
				new BoardModifyProService();
		//글 작성자가 맞는지 확인하는 부분
		boolean isRightUser = 
				boardModifyProService.isArticleWriter
					(board_num, request.getParameter("BOARD_PASS"));

		//글작성자가 아니라면...
		if(!isRightUser){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정할 권한이 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
		else{
			article.setBOARD_NUM(board_num);
			article.setBOARD_SUBJECT
				(request.getParameter("BOARD_SUBJECT"));
			article.setBOARD_CONTENT
				(request.getParameter("BOARD_CONTENT")); 
			isModifySuccess = 
					boardModifyProService.modifyArticle(article);

			if(!isModifySuccess){
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('수정실패');");
				out.println("history.back()");
				out.println("</script>");
			}
			//수정 성공했다면 경로지정한 곳으로 이동한다.
			else{
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("boardDetail.bo?board_num=" + 
						article.getBOARD_NUM()); 
			}
		}
		return forward;
	}
}