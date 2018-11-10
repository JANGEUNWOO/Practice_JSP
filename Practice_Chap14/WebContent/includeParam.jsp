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
		String name, age;
		name = request.getParameter("name");
		age = request.getParameter("age");
	%>
	
	<h2>includeParam 페이지입니다.</h2>
	넘어온 이름 : <%= name %><br/>
	넘어온 나이 : <%= age %>

</body>
</html>