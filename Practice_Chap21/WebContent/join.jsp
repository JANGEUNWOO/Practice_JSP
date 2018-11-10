<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- form태그를 작성해서 joinOk(자바파일, 서블릿)로 값을 넘기고 있다 -->
	<form action="joinOk" method="post">
		아이디 : &nbsp;&nbsp;<input type="text" name="id" size="10"><br>
		비밀번호:<input type="password" name="pw" size="10"><br> 
		이름:<input type="text" name="name" size="15"><br> 
		이메일:<input type="text" name="eMail" size="20"><br> 
		주소:<input type="text" name="address" size="50"><br> 
		<input type="submit" value="회원가입"> 
		<input type="reset" value="취소">
	</form>
</body>
</html>