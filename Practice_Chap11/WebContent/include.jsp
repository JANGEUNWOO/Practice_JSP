<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" >
<title>Insert title here</title>
</head>
<body>
<h1>include.jsp페이지 입니다.</h1>
<!-- 페이지 지시자를 이용하여 다른 페이지를 부르고 있다. -->
<%@ include file="include01.jsp" %>
<%@ include file="pageOrderExample.jsp" %>
<h1>다시 include.jsp페이지 입니다.</h1>
</body>
</html>