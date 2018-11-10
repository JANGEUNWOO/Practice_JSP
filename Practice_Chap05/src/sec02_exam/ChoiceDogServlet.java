package sec02_exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/choiceDog")
public class ChoiceDogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ChoiceDogServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
				request.setCharacterEncoding("UTF-8");
				
				
				//üũ�ڽ��� ��� ���߰��̹Ƿ� String[]Ÿ������ �����Ѵ�.
				String[] dog =request.getParameterValues("dog");
				
				
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter writer=response.getWriter(); //��½�Ʈ���� ��´�.
				
				writer.println("<html><head></head><body>");
				writer.println("<body bgcolor='black'>"); //body�κ� ��׶��� ���� ����
				//���̺� ����: �߾�, ����: ���
				writer.println("<table align='center' bgcolor='yellow'>");
				writer.println("<tr>"); //���� �����
				for(int i=0;i<dog.length;i++) {
					//�� ĭ �����
					writer.println("<td>");
					//�̹��� ��������
					writer.println("<img src='"+dog[i]+"'/>");
					writer.println("</td>");
				}
				writer.println("</tr>");
				writer.println("</table>");
				writer.println("</body>");
				writer.println("</html>");
				writer.println("Dog : "+Arrays.toString(dog)+"<br/>");
				
				writer.close(); //��Ʈ�� �ݱ�
		
		doGet(request, response);
	}

}
