<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커넥션풀 테스트</title>
</head>
<body>
	<%
		Context context = new InitialContext();
		//Context.xml파일에서 name을 찾는다(name이 jdbc/dbtool)
		DataSource ds = (DataSource)context.lookup("java:comp/env/"+"jdbc/dbtool");
		ds.getConnection();
		System.out.println("드라이버 성공");
		
	%>
</body>
</html>