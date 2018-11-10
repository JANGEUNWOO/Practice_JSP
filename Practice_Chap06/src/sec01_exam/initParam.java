package sec01_exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//1��° ���
//web.xml�� ���� ���������� �����߱� ������ ������̼��� �ּ�ó���Ѵ�.
//@WebServlet("/initParam")

//2��° ���
//�Ʒ��� ���� ������̼��� �����ϱ� ���ؼ��� web.xml�� ����Ǿ� �ִ� �κ��� �ϴ�
//�ּ�ó���ؾ� �Ʒ��κ��� �ڵ忡 ������ �Ǵ� ���� �ʹ��� �� �ȴ�.
//������ ������̼ǿ� ���� �ʱ�ȭ �Ķ���͸� �������ְ� �ִ�.
/*
 @WebServlet(urlPatterns={"/initP"},
 			initParams={@webInitParam(name='id',value="jew8960"),
 						@webInitParam(name='pw',value="1234"),
 						@webInitParam(name='path',value="D:\\jsp�۾�")
 					   }
 			)
 */
//����� �ʱ�ȭ �Ķ���͸� ����ϴ� ����, ���� �����ڰ����� ���� ����� �ϰ�,
//web.xml���Ͽ� ����� �ϰ� �Ѵ�.

@WebServlet("/initParam")
public class initParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public initParam() {
		super();
		
	}
	//�ƿ﷯ ���� ������ ���� �����ؼ� �������� ����ǹǷ� doGet()�� ȣ���Ѵٴ� ���� �̹� �� �˰� �ִ�.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet()ȣ��");
		//��� �������� ���� ������ ctrl+T�� �̿��ϸ� �ȴ�.
		//ServletConfig(�������̽�)�� �߻�޼��带 httpServlet���� �����Ͽ���.
		//���� this�ڱ� �ڽ��� �ּҸ� ������ �ִ� ���� �̹� �ڹٿ��� �����.
		//getInitParameter()�� HttpServlet ����Ŭ������ ���� �Ǿ� �ִ� �ż����̴�.
		//PPT������ ����������..
		String id=this.getInitParameter("id");
		String pw=this.getInitParameter("pw");
		String path=this.getInitParameter("path");
		response.setContentType("text/html; charset=UTF-8"); //Ŭ���̾�Ʈ���� ������ ���
		PrintWriter writer=response.getWriter();
		writer.println("<html><head></head><body>");
		writer.println("���̵�: "+id+"<br/>");
		writer.println("��й�ȣ: "+pw+"<br/>");
		writer.println("��� : "+path+"<br/>");
		writer.println("</body></html>");
		writer.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
