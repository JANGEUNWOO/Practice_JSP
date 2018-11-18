package controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import action.Action;
import action.BoardDeleteProAction;
import action.BoardDetailAction;
import action.BoardListAction;
import action.BoardModifyFormAction;
import action.BoardModifyProAction;
import action.BoardReplyFormAction;
import action.BoardReplyProAction;
import action.BoardWriteProAction;
import vo.ActionForward;

@SuppressWarnings("serial")
@WebServlet("*.bo")
public class BoardFrontController extends javax.servlet.http.HttpServlet {	
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;   //보여줄 뷰페이지를 설정하는 객체
		Action action = null;    //커맨드패턴의 인터페이스
		
		//요청에 따른 분기를 하고 있다.
		if(command.equals("/boardWriteForm.bo")){
			forward = new ActionForward(); //요청 페이지로 이동하는 객체 생성
			forward.setPath("/board/qna_board_write.jsp");//이동경로 지정
		}
		//게시판 글쓰기 등록을 눌렀을때, 실행한다.
		else if(command.equals("/boardWritePro.bo")){
			action  = new BoardWriteProAction();
			try {
				//Action인터페이스를 구현한 BoardWriteProAction클래스의
				//오버라이딩 된 execute()를 호출한다.
				forward = action.execute(request, response);
			} catch (Exception e) { e.printStackTrace(); }
		}
		//DB에 있는 게시글 리스트를 가져와서 출력하는 부분 
		else if(command.equals("/boardList.bo")){
			action = new BoardListAction();
			try{
				//Action인터페이스를 구현한 BoardListAction클래스의
				//오버라이딩 된 execute()를 호출한다.
				forward = action.execute(request, response);
			}catch(Exception e){ e.printStackTrace(); }
		}
		//게시글 하나에 대한 상세 보기 명령을 수행하는 부분
		//BoardDetailAction클래스의 오버라이딩 된 execute()
		//호출한다.
		else if(command.equals("/boardDetail.bo")){
			action = new BoardDetailAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){ e.printStackTrace(); }
		}
		//해당 글 상세보기를 누른후, 답변버튼을 눌렀을때 명령을 수행하는 부분
		//BoardReplyFormAction클래스의 오버라이딩 된 execute()를 호출함.
		else if(command.equals("/boardReplyForm.bo")){
			action = new BoardReplyFormAction();
			try{
				forward = action.execute(request, response);
			}catch(Exception e){ e.printStackTrace(); }
		}
		//답변 글쓰기 등록을 눌렀을 때, 명령을 수행하는 부분 
		//BoardReplyProAction클래스의 오버라이딩 된 execute()를 호출함.
		else if(command.equals("/boardReplyPro.bo")){
			action = new BoardReplyProAction();
			try{
				forward = action.execute(request, response);
			}catch(Exception e){ e.printStackTrace(); }
		}
		//글상세보기를 한후, 수정부분을 눌렀을 때, 명령을 수행하는 부분
		else if(command.equals("/boardModifyForm.bo")){
			action = new BoardModifyFormAction();
			try{
				forward = action.execute(request, response);
			}catch(Exception e){ e.printStackTrace(); }
		}
		//수정하기 폼에서 수정을 완료후 수정 버튼을 눌렀을때 명령을 수행하는 부분
		else if(command.equals("/boardModifyPro.bo")){
			action = new BoardModifyProAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//글 상세 보기 후, 삭제부분을 눌렀을 때, 명령을 수행하는 부분
		//여기서는 명령을 실행하는 부분 즉 command부분은 존재하지 않고
		//바로 경로를 지정해서 이동 시키고 있다.
		else if(command.equals("/boardDeleteForm.bo")){
			String nowPage = request.getParameter("page");
			request.setAttribute("page", nowPage);
			int board_num = Integer.parseInt
							(request.getParameter("board_num"));
			request.setAttribute("board_num",board_num);
			forward = new ActionForward();
			forward.setPath("/board/qna_board_delete.jsp");
		}
		//board/qna_board_delete.jsp파일에서 입력한 비밀번호를 가지고
		//실제로 게시글을 삭제하는 부분이다. 
		else if(command.equals("/boardDeletePro.bo")){
			action = new BoardDeleteProAction();
			try{
				forward = action.execute(request, response);
			}catch(Exception e){ e.printStackTrace(); }
		}		
		//이동경로로 이동
		if(forward != null){			
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			}
			else{
				//"/board/qna_board_write.jsp" setPath()로지정한 경로명
				RequestDispatcher dispatcher =
					request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}			
		}		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request,response);
	}  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request,response);
	}   

	
	/* 과제 
	BoardFrontController클래스
	else if(command.equals("/boardDetail.bo")){
		action = new BoardDetailAction();
		try{
			forward=action.execute(request, response);
		}catch(Exception e){ e.printStackTrace(); }
		}
	추가후

	BoardDetailAction클래스 구현
	- BoardDetailService의 public BoardBean getArticle(int board_num) throws Exception메서드 호출
	- forward.setPath("/board/qna_board_view.jsp")로 경로 지정후 리턴


	BoardDetailService클래스 구현
	public BoardBean getArticle(int board_num) throws Exception 하나만 존재함.
	위 함수내에서 
	- DAO에 
	public int updateReadCount(int board_num) 메서드 호출
	//글 내용 보기.
	public BoardBean selectArticle(int board_num) 메서드 호출

	DAO에
	//조회수 업데이트 기능 아래 메서드 추가
	public int updateReadCount(int board_num) 메서드 추가
*/	
	
}