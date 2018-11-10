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
	<%!String name, gender;
	String[] hobbys;%>

	<%
		request.setCharacterEncoding("UTF-8");
		name = request.getParameter("name");
		gender = request.getParameter("gender");

		hobbys = request.getParameterValues("hobby");
	%>
	<table border="1">
		<tr>
			<!-- 첫 번째 행 -->
			<td><label>전송받은 이름</label>
			<td><%=name%><br /></td>
		</tr>
		<tr>
			<!-- 두 번쨰 행 -->
			<td><label>전송받은 성별</label>
			<td><%=gender%><br /></td>

		</tr>
		<tr>
			<!-- 세 번쨰 행 -->
			<td><label>전송받은 취미</label>
			<td><%=Arrays.toString(hobbys)%></td>
		</tr>

	</table>
</body>
</html>