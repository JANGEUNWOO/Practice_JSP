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
      System.out.println("GetOrPostMethodCall.java에 있는 doGet() 호출");
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter writer = response.getWriter();
      writer.print("안녕하세요");
      writer.print("<html>");
      writer.print("<head>");
      writer.print("</head>");
      writer.print("<body>");
      writer.print("<h1>doGet방식입니다.");
      writer.print("</body>");
      writer.print("</html>");
      writer.close();
      
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("GetOrPostMethodCall.java에 있는 doPost() 호출");
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter writer = response.getWriter();
      writer.print("안녕하세요");
      writer.print("<html>");
      writer.print("<head>");
      writer.print("</head>");
      writer.print("<body>");
      writer.print("<h1>doPost방식입니다.");
      writer.print("</body>");
      writer.print("</html>");
      writer.close();
      //Server프로젝트 가서 ContextPath에 대해서 확인하자. sever.xml파일을 XSLEditor로 열자.
   }

}
