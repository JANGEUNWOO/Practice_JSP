package sec01_exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//1번째 방법
//web.xml에 현재 서블릿매핑을 진행했기 때문에 어노테이션은 주석처리한다.
//@WebServlet("/initParam")

//2번째 방법
//아래와 같이 어노테이션을 적용하기 위해서는 web.xml에 기술되어 있는 부분을 일단
//주석처리해야 아래부분이 코드에 적용이 되는 것은 너무도 잘 안다.
//지금은 어노테이션에 직접 초기화 파라미터를 지정해주고 있다.
/*
 @WebServlet(urlPatterns={"/initP"},
 			initParams={@webInitParam(name='id',value="jew8960"),
 						@webInitParam(name='pw',value="1234"),
 						@webInitParam(name='path',value="D:\\jsp작업")
 					   }
 			)
 */
//결론은 초기화 파라미터를 사용하는 곳은, 보통 관리자계정을 많이 사용을 하고,
//web.xml파일에 기술을 하곤 한다.

@WebServlet("/initParam")
public class initParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public initParam() {
		super();
		
	}
	//아울러 서블릿 파일을 직접 실행해서 브라우저에 실행되므로 doGet()을 호출한다는 것은 이미 잘 알고 있다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet()호출");
		//상속 계층도를 쉽게 볼려면 ctrl+T를 이용하면 된다.
		//ServletConfig(인터페이스)의 추상메서드를 httpServlet에서 구현하였다.
		//현재 this자기 자신의 주소를 가지고 있는 것을 이미 자바에서 배웠다.
		//getInitParameter()는 HttpServlet 조상클래스에 선언 되어 있는 매서드이다.
		//PPT에서도 설명했지만..
		String id=this.getInitParameter("id");
		String pw=this.getInitParameter("pw");
		String path=this.getInitParameter("path");
		response.setContentType("text/html; charset=UTF-8"); //클라이언트에게 보여줄 방식
		PrintWriter writer=response.getWriter();
		writer.println("<html><head></head><body>");
		writer.println("아이디: "+id+"<br/>");
		writer.println("비밀번호: "+pw+"<br/>");
		writer.println("경로 : "+path+"<br/>");
		writer.println("</body></html>");
		writer.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
