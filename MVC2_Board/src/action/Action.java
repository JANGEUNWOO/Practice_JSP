package action;

import javax.servlet.http.*;
import vo.ActionForward;

//���� ��û�� �����ϴ� ǥ���� �Ǵ� Action�������̽��� ����
public interface Action {
	//�߻�޼���
	public ActionForward execute(HttpServletRequest request,
					HttpServletResponse response) throws Exception;
}
