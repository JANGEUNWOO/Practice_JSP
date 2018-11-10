<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% System.out.println("forwardExample02 지나감"); %>
	<jsp:forward page='<%=request.getParameter("forwardPage")%>'>
	<jsp:param value="034-1234-5678" name="tel"/>
	</jsp:forward>
	
</body>
</html>