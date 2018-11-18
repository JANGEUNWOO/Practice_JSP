package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.BoardDetailService;
import vo.ActionForward;
import vo.BoardBean;

 public class BoardDetailAction implements Action {
	 
	 public ActionForward execute(HttpServletRequest request,
			 	HttpServletResponse response) throws Exception{
		//board_num�̶�� �Խñ� ��ȣ�� page��ȣ�� request�κ��� �޴´�. 
	   	int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		//BoardDetailServiceŬ������ ����� ������ �ϴ� �Խñ��� ������ ���� 
		//board_num�� ���ڰ��� �־� getArticle()ȣ���ϰ� �׿� ���õ� �Խñ�
		//�� ���� ������ ������ �ް� �ִ�.
		BoardDetailService boardDetailService = new BoardDetailService();
		BoardBean article = boardDetailService.getArticle(board_num);
		ActionForward forward = new ActionForward();
		//request��ü���ٰ� page��ȣ�� �Խñ��� setter�� ȣ���Ͽ� �����ϰ� �ִ�.
		request.setAttribute("page", page);
	   	request.setAttribute("article", article);
	   	//������ ���������� ��θ� �����ϰ� �����ϰ� �ִ�.
   		forward.setPath("/board/qna_board_view.jsp");
   		return forward;
	 }	 
}