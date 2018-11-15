package com.javalec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hw") //����ó���� �����ϴ�. web.xml�����ϴ� ����� ������.
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HelloWorld() {
        super();
        
    }
    
    @Override
    public void init() throws ServletException {
    	// Servlet ��ü�� �����Ǹ� ���ʷ� �ѹ��� �۵�
    	super.init();
    }
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpServletRequest ��ûó����ü ,     HttpServletResponse ����ó����ü
		
		System.out.println("doGet");
		
		response.setContentType("text/html; Charset=euc-kr");
		PrintWriter writer=response.getWriter();
		
		writer.println("<html>");
		writer.println("<head>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>Get����Դϴ�. ���� doGet �޼ҵ尡 ȣ�� �Ǿ����ϴ�.</h1>");
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
		writer.println("<h1>Post����Դϴ�. ���� doPost �޼ҵ尡 ȣ�� �Ǿ����ϴ�.</h1>");
		writer.println("</body>");
		writer.println("</html>");
		
		writer.close();
	}
	
	@Override
	public void destroy() {
		// Servlet�� �����Ǿ��ų� �簡���ǰų� �ϴ� ������ �ڿ��� �����ɶ� �ѹ� ����ȴ�.
		super.destroy();
	}

}
