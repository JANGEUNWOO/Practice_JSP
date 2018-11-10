package action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import svc.BoardWriteProService;
import vo.ActionForward;
import vo.BoardBean;

//게시글 등록을 수행하는 Command클래스
public class BoardWriteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward=null;
		BoardBean boardBean=null;
		String realFolder ="";
		String saveFolder ="/boardUpload"; //파일 저장폴더
		int fileSize=10*1024*1024; //10메가
		ServletContext context=request.getServletContext();
		realFolder=context.getRealPath(saveFolder);
		//파일 업로드 기능 구현
		MultipartRequest multi=new MultipartRequest(request, realFolder, fileSize,"UTF-8",new DefaultFileRenamePolicy());
		boardBean=new BoardBean(); //DTO역할을 하는 BoardBean클래스 생성
		boardBean.setBOARD_NAME(multi.getParameter("BOARD_NAME"));
		boardBean.setBOARD_PASS(multi.getParameter("BOARD_PASS"));
		boardBean.setBOARD_SUBJECT(multi.getParameter("BOARD_SUBJECT"));
		boardBean.setBOARD_CONTENT(multi.getParameter("BOARD_CONTENT"));
		boardBean.setBOARD_FILE(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
		BoardWriteProService boardWriteProService=new BoardWriteProService();
		boolean isWriteSuccess=boardWriteProService.registArticle(boardBean);
		
		//DB저장에 실패했다면...
		if(!isWriteSuccess) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패')");
			out.println("history.back();");
			out.println("<script>");
		}else {
			forward=new ActionForward();
			forward.setRedirect(true);
			forward.setPath("boardList.bo");
		}
		
		return forward;
	}
	
}
