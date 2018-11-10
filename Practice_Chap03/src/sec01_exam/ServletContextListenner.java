package sec01_exam;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

//������ Ŭ������ �ϳ� ���� ��������� �Ѵ�. ����, ServletContextListener�������̽��� �����ؾ� �ȴ�.
//�Ʒ��� ���� ������̼��� �����Ϸ��� ���� web.xml���Ͽ� listener�±׸� �ּ�ó���� �ؾߵȴ�.
//�Ʒ� 2���� �ݹ�޼���� �����ø����̼� ���۽�, ����� �ڵ�ȣ��ȴ�.

@WebListener
public class ServletContextListenner implements javax.servlet.ServletContextListener {
	// �Ʒ� 2���� �ݹ�޼���� �ٸ� �����ø����̼��� ����� ���� ���� ����ǹǷ�
	// �� ������Ʈ������ Ȯ���ϰ� �ּ�ó�����ִ� ���� ���� ���̴�.

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("contextDestroyed ȣ��");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("contextDestroyed ȣ��");
	}

}
