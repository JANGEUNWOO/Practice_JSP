<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//아래 내용은 현재 로그인이 되어 있다면 main.jsp로 forward시키라는 것이다.
	//이미 jsp액션태그에서 배운 forward를 이용한 것이다.
	if(session.getAttribute("ValidMem") != null) { %> 
		<jsp:forward page="main.jsp"></jsp:forward>
   <% } 
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
<style>
	input[type=text]{
		color: blue;
	}
	input[type=submit]{
		color: blue;
	}	
	input: hover{
		background: blue;
	}	
</style>
</head>
<body>
	<form action="loginOk.jsp" method="post">
	<!-- 아래 내용은 기존의 input태그이다. 하지만 value부분에서 자바코드가 들어가있다.
 	   설명을 하자면, 내장객체인 session을 이용하여 id가 session에 연결된게 있다면, 
 	   그 id값을 id입력공간에 표시하라는 것이다. -->
		아이디 : <input type="text" name="id" 
			   value= "<% if(session.getAttribute("id") != null) 
			   	 out.println(session.getAttribute("id")); %>"><br/>
		비밀번호 : <input type="password" name="pw"> <br/><br/>
		<input type="submit" value="로그인"> &nbsp;&nbsp;  
		<!-- 아래 내용에서 onclick부분은 javascript를 이용하여 회원가입 버튼을 누르면
		join.jsp로 이동하라는 뜻이다.
		강의에서 이미 여러 번 강조했지만, 기본적인 html과 javascript는 어느정도 공부를
		하라고 했다. -->
		<input type="button" value="회원가입" 
		onclick="javascript:window.location='join.jsp'"> &nbsp;&nbsp;		
		<!-- 아래부분을 추가해서 비밀번호 재설정 하는 부분을 작성해보자. -->
		<!-- 	<input type="button" value="비밀번호 재설정" onclick="javascript:window.location='rePassword.jsp'"> -->	
	</form>
</body>
</html>