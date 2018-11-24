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
   Cookie[] cookies=request.getCookies(); //1. 쿠키를 생성하고

   for(int i=0;i<cookies.length;i++){
      String str=cookies[i].getName();
      if(str.equals("cookieN")){
         out.println("name:"+cookies[i].getName()+"<br/>");
         cookies[i].setMaxAge(0);   //2. 쿠키 유효기간을 0초로 설정 
         response.addCookie(cookies[i]); //3. response에 탑재(삭제도 생성때와 순서가 마찬가지이다.)
         
      }
   }
%>

<a href="cookietest.jsp">쿠키확인</a>

</body>
</html>