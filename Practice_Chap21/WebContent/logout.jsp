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
		//session에서 name값을 얻는다.
		String name = (String) session.getAttribute("name");
	%>
	<!-- 자바 스크립트 태그로 알림창을 띄운다. -->
	<script type="text/javascript">
		alert('로그아웃 되었습니다.');
	</script>
	<%
		System.out.println(name + "님이 로그아웃하셨습니다.");
		//세션의 모든 값을 제거한다.
		session.invalidate();
		//다시 로그인창으로 유도한다.
		response.sendRedirect("login.jsp");
	%>
</body>
</html>