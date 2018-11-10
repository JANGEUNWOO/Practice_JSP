<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
//지금은 하나하나 Name을 주고 Value를 얻어서 출력하는 경우이다.
//session의 getAttribute()는 반환타입이 Object타입이다.
Object obj1=session.getAttribute("mySessionName");

//강제 타입 변환(다운캐스팅)
String mySessionName=(String)obj1;
out.println("mySessionName : "+mySessionName+"<br/>"); 
Object obj2=session.getAttribute("jew");

//Integer타입으로 강제 타입 변환
Integer jew=(Integer)obj2;
out.println("jew:"+jew+"<br/>");

out.println("=======================================<br/><br/>");

String sName;
String sValue;


//getAttributeNames()의 반환값은 열거<E> 제네릭타입이다.
//여기서는 String 만 받도록 제네릭타입을 설정하였다.
//getAttributeNames()은 세션의 모든 Name을 다 얻어오는 것이다.
Enumeration<String> e=session.getAttributeNames();
while(e.hasMoreElements()){
sName=e.nextElement(); //있으면 가져와라.
sValue=session.getAttribute(sName).toString();
out.println("sName:"+sName+"<br/>");
out.println("sValue:"+sValue+"<br/>");

}
out.println("=======================================<br/><br/>");
//sessionId는 웹브라우져 하나당 생기는 유니크한 값이다.
//물론 서버에서 생성해준다. 유니크한 sessionInit의 sessionID를 얻는다.
String sessionID=session.getId();
out.println("sessionID : "+sessionID+"<br/>");
//session의 유효시간을 얻어 출력한다
//기본값으로 30분이 설정되어 있고 출력해보면 1800초가 찍힐 것이다.
//D:\JSP작업\apache-tomcat-7.0.78\apache-tomcat-7.0.78\
//web.xml파일을 노트패드로 열어서 session부분의 값을 변경하면 된다.

int sessionInterval=session.getMaxInactiveInterval();
out.println("sessionInterval:"+sessionInterval+"<br/>");
out.println("=======================================<br/><br/>");

//mySessionName세션의 특정한 값을 삭제함.
session.removeAttribute("mySessionName");
Enumeration<String> el=session.getAttributeNames();

//session데이터가 jew만 남아 있을 것이다.
while(el.hasMoreElements()){
	sName=el.nextElement(); //있으면 가져와라
	sValue=session.getAttribute(sName).toString();
	out.println("sName:"+sName+"<br/>");
	out.println("sValue:"+sValue+"<br/>");
	
}
out.println("=======================================<br/><br/>");
//session의 모든 데이터값을 지운다.
session.invalidate();
//유효한 세션id가 있으냐?
		if(request.isRequestedSessionIdValid()){
			out.println("session valid");
		}
//없으면 출력
else{
	out.println("session invalid");
}
%>

</body>
</html>