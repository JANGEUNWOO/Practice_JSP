package sec01_exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetOrPostMethodCall
 */
@WebServlet("/GetOrPostMethodCall")
public class GetOrPostMethodCall extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOrPostMethodCall() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("GetOrPostMethodCall.java�� �ִ� doGet() ȣ��");
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter writer = response.getWriter();
      writer.print("�ȳ��ϼ���");
      writer.print("<html>");
      writer.print("<head>");
      writer.print("</head>");
      writer.print("<body>");
      writer.print("<h1>doGet����Դϴ�.");
      writer.print("</body>");
      writer.print("</html>");
      writer.close();
      
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("GetOrPostMethodCall.java�� �ִ� doPost() ȣ��");
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter writer = response.getWriter();
      writer.print("�ȳ��ϼ���");
      writer.print("<html>");
      writer.print("<head>");
      writer.print("</head>");
      writer.print("<body>");
      writer.print("<h1>doPost����Դϴ�.");
      writer.print("</body>");
      writer.print("</html>");
      writer.close();
      //Server������Ʈ ���� ContextPath�� ���ؼ� Ȯ������. sever.xml������ XSLEditor�� ����.
   }

}
