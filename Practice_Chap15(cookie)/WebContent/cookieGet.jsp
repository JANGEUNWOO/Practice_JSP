<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>쿠키의 값들을 출력하는 cookieGet.jsp 페이지이다. 이 페이지도 서버에서 실행하는 부분이다.</h1>
<% System.out.println("서버에서 쿠키객체를 생성하였으며, 생성된 쿠키의 값을 찍어보자."); 
//요청들어온 쿠키들의 값들들 받는다.(수신자 역할)
Cookie[] cookies = request.getCookies();
for(int i=0; i<cookies.length; i++){
   //쿠키의 이름을 얻는다.
   String str = cookies[i].getName();
   //만약 쿠키의 이름이 jsh라면 출력한다.
   if(str.equals("jsh")){
      out.println("cookies["+i+"] name :"+cookies[i].getName()+"<br>"); //쿠키 이름 출력
      out.println("cookies["+i+"] value :"+cookies[i].getValue()+"<br>"); //쿠키 값 출력
   }
}


%>
<br><br>
<a href="cookieDel.jsp">쿠키삭제</a>
</body>
</html>