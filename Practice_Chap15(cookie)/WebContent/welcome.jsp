<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>환영합니다.<br/> </h2>
로그인에 성공했습니다.<br/>

<script type="text/javascript">
alert('로그인 성공');
</script>

<% System.out.println("서버에서 쿠키객체를 생성하였으며, 생성된 쿠키의 값을 찍어보자."); 

Cookie[] cookies = request.getCookies();
for(int i=0; i<cookies.length; i++){
   
   String id = cookies[i].getValue();

   if(id.equals("jew")){
      out.println(id+"님 반갑습니다."); //쿠키 이름 출력
     
   }
}
%>

<br/>
<a href="logOut.jsp">로그아웃 합시다.</a>

</body>
</html>