
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>pageOrderExample.jsp파일입니다.</h1>
	<%
		int[] iArr = new int[] { 100, 200, 400 }; //선언과 동시 초기화
		//Arrays클래스의 정적 메서드인 toString()을 직접 호출코드를 작성하니 위에
		//페이지 지시자에 import="java.util.Arrays"가 나타남을 볼 수 있다.
		out.println(Arrays.toString(iArr));
	%>
</body>
</html>