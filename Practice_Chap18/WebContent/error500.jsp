<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--페이지 지사자를 이용해서 isErrorPage속성을 true로 설정하고 있다. 그래야 exception객체를 참조할 수 있다고 하였다.  -->
<%@ page isErrorPage="true" %>
<% response.setStatus(200); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br/>
<h1>500에러입니다. 연산부분을 확인하세요.</h1><br/>
<%=exception.getMessage() %>
</body>
</html>