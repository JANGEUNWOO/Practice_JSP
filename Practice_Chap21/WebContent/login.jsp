<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="loginOk" method="post">
		아이디 : <input type="text" name="id" size="15"><br> 
		비밀번호 : <input type="password" name="pw" size="15"><br> <br>
		<input type="submit" value="로그인">&nbsp;&nbsp;&nbsp; 
		<input type="reset" value="초기화">
	</form>
	<br>
	<br>
	<a href="join.jsp">회원가입</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<!-- 과제 -->
	<a href="list.jsp">회원 목록</a>
</body>
</html>