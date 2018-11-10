package sec01_exam;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

//리스너 클래스를 하나 따로 새서해줘야 한다. 물론, ServletContextListener인터페이스를 구현해야 된다.
//아래와 같이 어노테이션을 적용하려면 역시 web.xml파일에 listener태그를 주석처리를 해야된다.
//아래 2개의 콜백메서드는 웹어플리케이션 시작시, 종료시 자동호출된다.

@WebListener
public class ServletContextListenner implements javax.servlet.ServletContextListener {
	// 아래 2개의 콜백메서드는 다른 웹어플리케이션이 실행될 때도 같이 실행되므로
	// 이 프로젝트에서만 확인하고 주석처리해주는 것이 좋을 것이다.

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("contextDestroyed 호출");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("contextDestroyed 호출");
	}

}
