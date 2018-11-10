package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;

//실제 요청을 수행하는 표준이 되는 Action인터페이스를 선언
public interface Action {

	//추상메서드
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
}
