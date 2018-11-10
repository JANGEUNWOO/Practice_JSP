<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="Customer" class="sec02_exam.Customer" scope="page" />


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:setProperty property="*" name="Customer" />

	<h2>자바빈 속성 값 출력</h2>
	이름:
	<jsp:getProperty property="name" name="Customer" /><br /> 
	나이:
	<jsp:getProperty property="addr" name="Customer" /><br /> 
	학년:
	<jsp:getProperty property="email" name="Customer" /><br /> 
	번호:
	<jsp:getProperty property="birthday" name="Customer" /><br />

</body>
</html>