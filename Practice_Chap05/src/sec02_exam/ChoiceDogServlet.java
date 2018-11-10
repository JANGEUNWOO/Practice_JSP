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
				
				
				//체크박스의 경우 다중값이므로 String[]타입으로 리턴한다.
				String[] dog =request.getParameterValues("dog");
				
				
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter writer=response.getWriter(); //출력스트림을 얻는다.
				
				writer.println("<html><head></head><body>");
				writer.println("<body bgcolor='black'>"); //body부분 백그라운드 색깔 검정
				//테이블 정렬: 중앙, 색상: 노랑
				writer.println("<table align='center' bgcolor='yellow'>");
				writer.println("<tr>"); //한행 만들기
				for(int i=0;i<dog.length;i++) {
					//한 칸 만들기
					writer.println("<td>");
					//이미지 가져오기
					writer.println("<img src='"+dog[i]+"'/>");
					writer.println("</td>");
				}
				writer.println("</tr>");
				writer.println("</table>");
				writer.println("</body>");
				writer.println("</html>");
				writer.println("Dog : "+Arrays.toString(dog)+"<br/>");
				
				writer.close(); //스트림 닫기
		
		doGet(request, response);
	}

}
