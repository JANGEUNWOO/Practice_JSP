package sec01_exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ContextinitParam")
public class ContextinitParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

    public ContextinitParam() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doGet()호출");
		//getServletContext()를 이용해서 web.xml의 context-param값들을 가져다 쓸 수 있다.
		String id=this.getServletContext().getInitParameter("id");
		String pw=this.getServletContext().getInitParameter("pw");
		String path=this.getServletContext().getInitParameter("path");
		//클라이언트에게 보여줄 방식 설정
		response.setContentType("text/html; charset=UTF-8"); //클라이언트에게 보여줄 방식
		PrintWriter writer=response.getWriter();
		writer.println("<html><head></head><body>");
		writer.println("아이디: "+id+"<br/>");
		writer.println("비밀번호: "+pw+"<br/>");
		writer.println("경로 : "+path+"<br/>");
		writer.println("</body></html>");
		writer.close();
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
