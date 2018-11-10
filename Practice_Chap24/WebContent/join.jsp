<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script lang="JavaScript" src="members.js"></script>
</head>
<body>
   <!-- 여기서 form의 이름이 reg_frm이란 것이 추가된 것을 확인하자. -->
   <form action="joinOk.jsp" method="post" name="reg_frm">
      아이디 : <input type="text" name="id" size="20"><br>
      비밀번호  : <input type="password" name="pw" size="20"><br>
      비밀번호 확인 : <input type="password" name="pw_check" size="20"><br>
      이름 : <input type="text" name="name" size="20"><br>
      메일  : <input type="text" name="eMail" size="20"><br>
      주소  : <input type="text" name="address" size="50"><br>
      <!-- 
         자바스크립트를 이용하여 버튼을 누르면 members.js파일의 infoConfirm()메서드를 호ㅜㄹ
         현업에서는 이렇게 자바스크립트를 이용해서 사요한는 경우가 많다.
         그렇기 때문에 자바스크립트도 기본은 알아야한다.
       -->
      <input type="button" value="회원가입"
       onclick="infoConfirm()">&nbsp;&nbsp;&nbsp;
      <input type="reset" value="취소"
       onclick="javascript:window.location='login.jsp'">
   </form>
</body>
</html>