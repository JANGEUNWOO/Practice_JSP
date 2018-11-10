<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    //아래 내용은 현재 로그인이 되어 있다면 main.jsp로 forward시키라는 것이다.
    //이미 jsp액션태그에서 배운 forward를 이용한 것이다.
    if(session.getAttribute("validMem") != null){%>
    <jsp:forward page="main.jsp"></jsp:forward>
    <% }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style type="text/css">
input[type=text]{color: blue;}
input[type=submit]{color: blue;}
input:hover { background: blue;}
</style>
</head>
<body>
<form action="loginOk.jsp" method="post">
<!-- 아래 내용은 기존의 input태그이다. 하지만 value부분에서 자바코드가 들어가 있다. 설명을 하자면, 내장객체인 session을 이용하여
id가 session에 연결된게 있다면, 그 id 값을 id입력공간에 표시하라는 것이다. -->
아이디 : <input type="text" name="id" value="<% if(session.getAttribute("id")!=null)
   out.println(session.getAttribute("id"));%>"><br>
비밀번호 : <input type="password" name="pw"> <br/><br/>
      <input type="submit" value="로그인"> &nbsp;&nbsp;
      
      <!-- 아래 내용에서 onclick 부분은 javascript를 이용하여 회원가입 버튼을 누르면 join.jsp로 이동하는 것이다. -->
      <!-- 기본적인 html과 javascript를 어느정도 공부해두자 -->
      <input type="button" value="회원가입" onclick="javascript:window.location='join.jsp'"> &nbsp;&nbsp;
   </form>
</body>
</html>

</form>
</body>
</html>