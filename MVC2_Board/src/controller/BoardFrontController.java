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
		ActionForward forward=null; //보여줄 뷰페이지를 설정하는 객체
		Action action =null; //커맨드패턴의 인터페이스
		
		
		//요청에 따른 분기를 하고 있다.
		if(command.equals("/boardWriteForm.bo")) {
			forward=new ActionForward(); //요청 페이지로 이동하는 객체 생성
			forward.setPath("/board/qna_board_write.jsp");// 이동경로 지정
		}
		//게시판 글쓰기 등록을 눌렀을 떄, 실행한다.
		else if(command.equals("/boardWritePro.bo")) {
			action=new BoardWriteProAction();
			try {
				//Action인터페이스를 구현한 BoardWriteProAction 클래스의 오버라이딩 된 execute()를 호출한다.
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		//DB에 있는 게시글 리스트를 가져와서 출력하는 부분
		else if(command.equals("/boardList.bo")) {
			action=new BoardListAction();
			try {
				//Action인터페이스를 구현한 BoardListAction클래스의 오버라디이 된 execute()를 호출한다.
				forward=action.execute(request,response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		//이동경로로 이동
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
