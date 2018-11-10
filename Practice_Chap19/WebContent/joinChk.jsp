<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("UTF-8");
%>
    
<jsp:useBean id="Member" class="sec03_exam.Member" scope="page" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:setProperty property="*" name="Member"/>

	아이디:<jsp:getProperty property="id" name="Member" /><br /> 
	비밀번호:<jsp:getProperty property="pass" name="Member" /><br /> 
	이름:<jsp:getProperty property="name" name="Member" /><br /> 
	성별:<jsp:getProperty property="sex" name="Member" /><br />
	나이:<jsp:getProperty property="age" name="Member" /><br />
	이메일주소:<jsp:getProperty property="email" name="Member" /><br />
    <br/>
    <br/>


</body>
</html>