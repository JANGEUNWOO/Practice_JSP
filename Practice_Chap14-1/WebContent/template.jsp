<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String pagefile = request.getParameter("page");
	if (pagefile == null) {
		pagefile = "newitem";

	}
%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	margin: auto;
	width: 1024px;
	height: 768px;
	color: gray;
	border: 2px red;
}
</style>
</head>
<body>

	<table border="1">
		<tr>
			<td height="15%" width="20" align="center">쇼핑몰 로고</td>
			<td height="15%" colspan="2" align="right"><jsp:include
					page="top.jsp" /></td>
		</tr>
		<tr>
			<!--left부분을 표시한다. -->
			<td width="20%" align=right valign=top><br> <jsp:include
					page="left.jsp" /></td>

			<!--center부분을 표시한다. -->
			<td colspan=2 align=center><jsp:include
					page='<%=pagefile + ".jsp"%>' /></td>
		</tr>
		<tr>
			<!--bottom부분을 표시한다. -->
			<td width="100%" height="10%" colspan="3"><jsp:include
					page="bottom.jsp" /></td>
		</tr>

	</table>

</body>
</html>