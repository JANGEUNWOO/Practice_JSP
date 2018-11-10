package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.Action;
import action.BoardListAction;
import action.BoardWriteProAction;
import vo.ActionForward;


@SuppressWarnings("serial")
@WebServlet("*.bo")
public class BoardFrontController extends HttpServlet {
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String RequestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		ActionForward forward=null; //������ ���������� �����ϴ� ��ü
		Action action =null; //Ŀ�ǵ������� �������̽�
		
		
		//��û�� ���� �б⸦ �ϰ� �ִ�.
		if(command.equals("/boardWriteForm.bo")) {
			forward=new ActionForward(); //��û �������� �̵��ϴ� ��ü ����
			forward.setPath("/board/qna_board_write.jsp");// �̵���� ����
		}
		//�Խ��� �۾��� ����� ������ ��, �����Ѵ�.
		else if(command.equals("/boardWritePro.bo")) {
			action=new BoardWriteProAction();
			try {
				//Action�������̽��� ������ BoardWriteProAction Ŭ������ �������̵� �� execute()�� ȣ���Ѵ�.
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		//DB�� �ִ� �Խñ� ����Ʈ�� �����ͼ� ����ϴ� �κ�
		else if(command.equals("/boardList.bo")) {
			action=new BoardListAction();
			try {
				//Action�������̽��� ������ BoardListActionŬ������ ��������� �� execute()�� ȣ���Ѵ�.
				forward=action.execute(request,response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		//�̵���η� �̵�
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher=
						request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
	

	
	
	
	
	private static final long serialVersionUID = 1L;
       
 
    public BoardFrontController() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		
	}

}
