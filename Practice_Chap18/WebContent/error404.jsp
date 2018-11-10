<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page isErrorPage="true" %>
<% response.setStatus(200); %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 페이지를 찾지 못하는 404에러 같은 경우는, 이동하려는 대상 페이지가 존재하기 떄문에 그 페이지가 존재하지 않는 상태이므로 exception객체를 참조할 수 없다.
하여, 404에러 같은 경우에는 exception객체를 사용하지 않도록 한다. -->
	<h1>404에러입니다. 페이지가 없습니다.</h1>
	<%-- <%=exception.getMessage() %> --%>
</body>
</html>