package sec01_exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FormEx")
public class FormEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FormEx() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doPost()호출");
		
		//한글깨짐을 방지하기 위해 설정함. 주석처리를 하고 실행도 해보자.
		//그럼 한글이 꺠져 나올것이다.
		request.setCharacterEncoding("UTF-8");
		//html의 form태그에서 입력하고 전송한 값을 직접 request객체의 메서드로 얻어서 출력해본다.
		// 여기서 기억해야 할 것은 request와 response객체는 토캣서버가 자동생성시켜주며
		//아울러 요청시에는 request객체로부터 값을 얻고 응답할 시에는
		//response객체를 이용한다는 것이다. 명심하도록 하자.!
		String name=request.getParameter("name");
		String id=request.getParameter("id");
		String pw=request.getParameter("password");
		
		//체크박스의 경우 다중값이므로 String[]타입으로 리턴한다.
		String[] hobby =request.getParameterValues("hobby");
		String major=request.getParameter("major");
		String protocol=request.getParameter("protocol");
		
		//취의 값들을 받아서 클라이언트에게 뿌려준다.
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer=response.getWriter(); //출력스트림을 얻는다.
		writer.println("<html><head></head><body>");
		writer.println("이름 : "+name+"<br/>");
		writer.println("아이디 : "+id+"<br/>");
		writer.println("비밀번호 : "+pw+"<br/>");
		writer.println("전공 : "+major+"<br/>");
		writer.println("취미 : "+Arrays.toString(hobby)+"<br/>");
		writer.println("프로토콜 : "+protocol+"<br/>");
		writer.println("</body></html>");
		writer.close(); //스트림 닫기
	}

}
