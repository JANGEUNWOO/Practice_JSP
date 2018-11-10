<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>forward.jsp 페이지입니다.</h1>
	<%
		System.out.println("forwardParam으로 넘기기전 forward페이지입니다.");
	%>
	
	<!--forward액션태그를 이용해서 페이지 이동을 하고 있다. 안에 파라미터를 전달하고자 jsp:param액션태그를 사용했다. 아울러
	페이지 이름을 하면 내부객체인 request객체는 서로 공유하기 떄문에 forwardParam.jsp페이지에서 넘긴 이 값을 받아서 사용할 수 있다.
	또 강조하지만 URL은 변하지 아니한다.  -->
	
	<jsp:forward page="forwarParam.jsp">
		<jsp:param value="perpear" name="id"/>
		<jsp:param value="12345" name="pw"/>
	</jsp:forward>
</body>
</html>