<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
   //session의 값이 ValidMem속성이 null이라면, 경고창 띄우고
   if(session.getAttribute("ValidMem") == null){
%>
   <!-- 다시 로그인페이지로 돌려보낸다. -->
   <jsp:forward page="login.jsp"/>
<%
   }
   //session.getAttribute()반환타입은 Object이다. 하여 캐스팅하였다.
   String name = (String)session.getAttribute("name");
   String id = (String)session.getAttribute("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 인증</title>
</head>
<body>
   <!-- 로그인한 사람의 이름을 출력한다. -->
   <h1><%=name %>님 하잇!</h1><br/>
   <form action="login.jsp" method="post">
      <input type="submit" value="로그아웃"> &nbsp;&nbsp;&nbsp;
      <input type="button" value="정보수정" onclick="javascript:window.location='modify.jsp'">
   </form>
</body>
</html>
<!-- 과제 : joinOk.jsp, logout.jsp, modify.jsp, modifyOk.jsp
   4개의 파일을 만들어서 프로그램이 정상 작동하는지 확인하며 텍스트 파일로 작성하여 메일로 보낸다. -->