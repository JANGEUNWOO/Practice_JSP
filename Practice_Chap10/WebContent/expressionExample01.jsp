<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;  charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!int i = 10;
	String str = "장은우";

	private int mul(int a, int b) {
		return a + b;
	}%>
	<!-- 표현식에서는 ;을 붙이지 않는다. -->
	<%=i%><br />
	<%=str%><br />
	<%=mul(100, 50)%><br />
</body>
</html>