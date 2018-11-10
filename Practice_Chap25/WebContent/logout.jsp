<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.invalidate();  //session들 다 종료시킨다.
	//다시 로그인 페이지로 이동시킨다.
	response.sendRedirect("login.jsp"); 
%>     
  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그아웃</title>
</head>
<body>
</body>
</html>