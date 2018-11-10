<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>서버에서 쿠키를 생성하는 cookieSet.jsp페이지 입니다.</h1>
   <%
      System.out.println("서버에서 쿠키객체를 생성하였으며, 응답하기 위해 response객체에 추가하였다.");
      request.setCharacterEncoding("UTF-8");
      //쿠키는 통상 클라이언트가 접속하면 서버쪽에서 생성하여 해당 클라이언트에게 보내어 로컬 PC에 저장하게 하는 방식이다.
      //하여 1명의 클라이언트이기 때문에 하나의 쿠키를 생성할 수가 있다.
      //아울러 쿠키속성(이름, 값)을 설정할 때는, 한글로 만들어지지 않기 때문에 영문이나 숫자로만 설정을 하도록 하자.
      Cookie cookie = new Cookie("jew", "1234");
      cookie.setMaxAge(60*60); //쿠키의 유효시간 설정(1시간)
      //어떠한  파일에서 set한 쿠키속성을 읽어가기 위해서 response객체에 추가하는 것이다.
      //헷갈리지 않도록하자. 이 파일은 보내는 쪽이다.
      response.addCookie(cookie); //내장객체에다가 쿠키를 저장하므로써 1시간동안 쿠키파일은 유효하게 돌아가는 것이다.
   %>
   <!-- 앵커로 하이퍼링크 설정 -->
   <a href="cookieGet.jsp">쿠키값 얻기</a>
   <br>
   <br>
</body>
</html>