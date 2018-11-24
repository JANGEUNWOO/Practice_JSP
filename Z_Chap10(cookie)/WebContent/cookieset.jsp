<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%
   Cookie cookie=new Cookie("cookieN","cookieV");  //1. 서버에서 쿠기 생성(앞의 cookieN은 이름 cookieV는 값)
   cookie.setMaxAge(60*60);  //2. 속성지정 60초 *60  = 1시간동안 이 쿠키는 유지된다.
   response.addCookie(cookie); //3. response
%>

<a href="cookieget.jsp">cookie get</a>

</body>
</html>