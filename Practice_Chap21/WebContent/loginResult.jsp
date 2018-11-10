
<%@page import="java.util.Date"%>
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
 String name, id, pw, rDate;
 Date now = new Date(); //접속 일자와 시간을 찍기 위해서
 request.setCharacterEncoding("UTF-8");
 String sessionID = session.getId(); //유니크한 세션ID값 얻음
 //앞선 강의에서도 설명헀듯이 session의 get값은 Object이므로 강제타입 변환을 해야한다.
 id = (String)session.getAttribute("id");
 pw = (String)session.getAttribute("pw");
 name = (String)session.getAttribute("name");
 rDate = (String)session.getAttribute("rDate");
 //유니크한 세션값을 한번 찍어봄
 out.println("세션아이디:"+sessionID+"<br>");
 %>
 <%=name %>님 반갑습니다.<br>
 접속일시: <%=now.toString() %><br> <!-- 접속일시 -->
 가입일시: <%out.print(rDate); %><br> <!-- 가입일시 -->
 <a href="modify.jsp">회원정보 수정</a>
</body>
</html>