<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>forwardParam.jsp 페이지 입니다.</h1>	
	<!-- 선언부  -->

	<!-- 스크립트릿을 사용해서 아래와 같이 request객체를 이용해서 넘어온 값을 받아오고 있다.  -->
	<%
		String id, pw;
		id=request.getParameter("id");
		pw=request.getParameter("pw");
	%>
	<!--표현식을 사용해서 아래와 같이 출력하고 있다.  -->
	넘어온 파라미터의 값을<br/>
	아이디    : <%=id %><br/>
	비밀번호 : <%=pw %><br/>
</body>
</html>