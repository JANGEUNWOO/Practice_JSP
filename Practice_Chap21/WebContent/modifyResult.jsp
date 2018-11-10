<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
		alert('정보변경완료');
	</script>
	<% 
	String name = (String)session.getAttribute("name");
	%>
	<h1><%=name %>님의 회원정보가 수정 되었습니다!!!!!</h1>
	<br>
	<br>
	<br>
	<a href="logOut.jsp">[로그아웃]</a>
</body>
</html>