<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%!String age;%>

<% 
request.setCharacterEncoding("UTF-8");
age = request.getParameter("age");
%>

나이:<%=age%><br>
미성년자인데 어디 소주를 살려고 하지요? 나가세요!<br>
<a href="requestExample.html">처음으로 돌아감</a>

</body>
</html>