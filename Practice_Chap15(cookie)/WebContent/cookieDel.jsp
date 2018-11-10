<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>쿠키의 값들을 삭제하는 cookieDel.jsp 페이지입니다.
	이 페이지에서도 서베에서 실행하는 부분입니다.</h1>
	
	<%
	Cookie[] cookies=request.getCookies();
	for(int i=0;i<cookies.length;i++){
		String str=cookies[i].getName();
		//쿠키의 이름이 jew라면..
		if(str.equals("jew")){
			out.println("name : "+cookies[i].getName());
			//유효기간을 0초로 설정하면 삭제효과를 지닌다.
			cookies[i].setMaxAge(0);
			//또한 위의 변경된 속성의 쿠키를 response객체에 담는다.
			//(물론 기존의 값은 쿠키이다.)
			response.addCookie(cookies[i]);
		}
	}
	
	%>
	<br/><br/>
	<a href="cookieTest.jsp">쿠키 확인</a>

</body>
</html>