<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>쿠키의 값들을 삭제되었는지 확인하는 cookieTest.jsp 페이지입니다. 이페이지도 서버에서 실행하는 부분입니다.</h1>

<%
	Cookie[] cookies=request.getCookies(); //알선 cookiesDel.jsp에서
	//확인해보면 jseseionid... 이런게 뜨는데 이건 기본적으로 그냥 무시하자.
	if(cookies !=null){
		for(int i=0;i<cookies.length;i++){
			out.println("현재 남아있는 쿠키 이름:"+cookies[i].getName());
			out.println("현재 남아있는 쿠키 값:"+cookies[i].getValue());
		}
	}
	//여기서 꼭 기억할 것은 쿠키를 생성하고 response객체에 탑재를 한다.
	//아울러 그 쿠키의 변경이 일어나면 반드시 response갹체에 또 탑재를 해야 한다는 것이다.
%>

</body>
</html>