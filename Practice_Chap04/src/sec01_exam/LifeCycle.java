package sec01_exam;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LifeCycle")
public class LifeCycle extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public LifeCycle() {
		super();
		System.out.println("생성자호출");
	}
	// init()을 ctrl+스페이스바를 눌러 직접 입력하여 코딩하자.
	// 최초한번 실행된다.

	@Override
	public void init() throws ServletException {
		System.out.println("init()호출");

	}

	//destroy()를 ctrl+스페이스바를 눌러 직접 입력하여 코딩하자.
	// 서버를 중지시켜 보면 destroy()가 호출되는 것을 볼 수 있다.
	@Override
	public void destroy() {
		System.out.println("destory()호출");
	}

	// 새로고침을 계속하면 URL로 직접 접속했기 때문에 doGet()이 계속 호출됨을 볼 수 있다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet()호출");
	}

	// 오버라이딩의 개념이 아니다. 직접 매서드를 만들어주는 것이다.(중요)
	// 선처리 부분이다. 직접 코딩해주는데, 이부분은 장표에서도 설명했듯이
	// init()매서드가 호출되어지기 전에 먼저 실행됨을 알도록 하자.
	// 그 역할은 아래에 있는 @PostConstruct어노테이션이 컴파일러한테 따로 지시를 하는 것

	@PostConstruct
	private void initPostConstructor() {
		System.out.println("initPostConstructor()호출");
	}

	// 오버라이딩의 개념이 아니다. 직접 매서드를 만들어주는 것이다.(중요)
	// 선처리 부분이다. 직접 코딩해주는데, 이부분은 장표에서도 설명했듯이
	// destory()매서드가 호출되어지기 전에 먼저 실행됨을 알도록 하자.
	// 그 역할은 아래에 있는 @PreDestroy어노테이션이 컴파일러한테 따로 지시를 하는 것

	@PreDestroy
	private void destroyPredestroy() {
		System.out.println("destroyPredestroy()호출");
	}

	// 아래는 service()를 재정의 한 부분인데, doGet doPost가 없다면 service를 실행하고 아울러 셋다 존재해도
	// service()가 호출된다. 직접 한번 실행해보자.
	// 하지만 통상 doGet()과 doPost()를 사용하여 코딩을 한다.

	/*
	 * @Override public void service(ServletRequest req, ServletResponse res) throws
	 * ServletException, IOException { System.out.println("service()호출"); }
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("doPost()호출");

	}

}
