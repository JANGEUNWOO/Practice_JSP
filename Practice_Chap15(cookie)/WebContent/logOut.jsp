<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2> 로그아웃 되었습니다. </h2>

	<%
	Cookie[] cookies=request.getCookies();
	if(cookies !=null){
		for(int i=0;i<cookies.length;i++){
			String id=cookies[i].getValue();
			if(id.equals("jew")){
				cookies[i].setMaxAge(0);
				
				response.addCookie(cookies[i]);
				out.println(id+"님이 로그아웃 하였습니다.");
			}
		}
	}
	%>
	<br/><br/>
	<a href="cookieTest.jsp">쿠키테스트</a>
</body>
</html>