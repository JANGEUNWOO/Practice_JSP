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
   	String id, pw;
   id=request.getParameter("id");
   pw=request.getParameter("pw");
   
   //지금은 DB를 설정하지 않아 아래와 같은 코드를 직접 코딩하였지만,
   //추후 DB연동하고 난뒤에는 코드를 쉽게 변경할 수 있다.
   if(id.equals("jew")&&pw.equals("1234")){
	   //쿠키의 이름은 id이고 값은 jew가 된다.
	   session.setAttribute("mySessionName", "mySessionData");
	   session.setAttribute("jew", 1234);
	   
	   response.sendRedirect("welcome.jsp");
   }else {
	   //그렇지 않다면 다시 loginFail.jsp 페이지로 이동한다.
	   response.sendRedirect("loginFail.jsp");
   }

   %>
</body>
</html>