<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//여기서 분명 예외가 발생할 것이다 . 그렇다고 페이지 지시자를 이용해서 하지 않는다.
	//미리 web.xml 파일에 예외처리 코드를 삽입해두었기 떄문이다.
	int i=40/0;
%>
</body>
</html>