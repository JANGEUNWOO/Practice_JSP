package com.javalec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hw") //맵핑처리가 가능하다. web.xml에서하는 방법도 존재함.
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HelloWorld() {
        super();
        
    }
    
    @Override
    public void init() throws ServletException {
    	// Servlet 객체가 형성되면 최초로 한번만 작동
    	super.init();
    }
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpServletRequest 요청처리객체 ,     HttpServletResponse 응답처리객체
		
		System.out.println("doGet");
		
		response.setContentType("text/html; Charset=euc-kr");
		PrintWriter writer=response.getWriter();
		
		writer.println("<html>");
		writer.println("<head>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>Get방식입니다. 따라서 doGet 메소드가 호출 되었습니다.</h1>");
		writer.println("</body>");
		writer.println("</html>");
		
		writer.close();
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doPost");
		
		response.setContentType("text/html; Charset=euc-kr");
		PrintWriter writer=response.getWriter();
		
		writer.println("<html>");
		writer.println("<head>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>Post방식입니다. 따라서 doPost 메소드가 호출 되었습니다.</h1>");
		writer.println("</body>");
		writer.println("</html>");
		
		writer.close();
	}
	
	@Override
	public void destroy() {
		// Servlet이 수정되었거나 재가동되거나 하는 이유로 자원이 해제될때 한번 시행된다.
		super.destroy();
	}

}
