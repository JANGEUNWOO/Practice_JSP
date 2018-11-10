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
		System.out.println("������ȣ��");
	}
	// init()�� ctrl+�����̽��ٸ� ���� ���� �Է��Ͽ� �ڵ�����.
	// �����ѹ� ����ȴ�.

	@Override
	public void init() throws ServletException {
		System.out.println("init()ȣ��");

	}

	//destroy()�� ctrl+�����̽��ٸ� ���� ���� �Է��Ͽ� �ڵ�����.
	// ������ �������� ���� destroy()�� ȣ��Ǵ� ���� �� �� �ִ�.
	@Override
	public void destroy() {
		System.out.println("destory()ȣ��");
	}

	// ���ΰ�ħ�� ����ϸ� URL�� ���� �����߱� ������ doGet()�� ��� ȣ����� �� �� �ִ�.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet()ȣ��");
	}

	// �������̵��� ������ �ƴϴ�. ���� �ż��带 ������ִ� ���̴�.(�߿�)
	// ��ó�� �κ��̴�. ���� �ڵ����ִµ�, �̺κ��� ��ǥ������ �����ߵ���
	// init()�ż��尡 ȣ��Ǿ����� ���� ���� ������� �˵��� ����.
	// �� ������ �Ʒ��� �ִ� @PostConstruct������̼��� �����Ϸ����� ���� ���ø� �ϴ� ��

	@PostConstruct
	private void initPostConstructor() {
		System.out.println("initPostConstructor()ȣ��");
	}

	// �������̵��� ������ �ƴϴ�. ���� �ż��带 ������ִ� ���̴�.(�߿�)
	// ��ó�� �κ��̴�. ���� �ڵ����ִµ�, �̺κ��� ��ǥ������ �����ߵ���
	// destory()�ż��尡 ȣ��Ǿ����� ���� ���� ������� �˵��� ����.
	// �� ������ �Ʒ��� �ִ� @PreDestroy������̼��� �����Ϸ����� ���� ���ø� �ϴ� ��

	@PreDestroy
	private void destroyPredestroy() {
		System.out.println("destroyPredestroy()ȣ��");
	}

	// �Ʒ��� service()�� ������ �� �κ��ε�, doGet doPost�� ���ٸ� service�� �����ϰ� �ƿ﷯ �´� �����ص�
	// service()�� ȣ��ȴ�. ���� �ѹ� �����غ���.
	// ������ ��� doGet()�� doPost()�� ����Ͽ� �ڵ��� �Ѵ�.

	/*
	 * @Override public void service(ServletRequest req, ServletResponse res) throws
	 * ServletException, IOException { System.out.println("service()ȣ��"); }
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("doPost()ȣ��");

	}

}
