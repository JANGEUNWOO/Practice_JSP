<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 가입</title>
<!-- 아래 script는 언어를 JavaScript를 쓰겠다는 것이고 참조할 소스는 members.js를 
	  하겠다는 것이다. -->
<script lang="JavaScript" src="members.js"></script>
</head> 
<body>
	<!-- 여기서 form의 이름이 reg_frm이란것이 추가된 것을 확인하자.  -->
	<form action="joinOk.jsp" method="post" name="reg_frm">
		아이디 : <input type="text" name="id" size="20"><br />
		비밀번호 : <input type="password" name="pw" size="20"><br />
		비밀번호 확인 : <input type="password" name="pw_check" size="20"><br />
		이름 : <input type="text" name="name" size="20"><br />
		메일 : <input type="text" name="eMail" size="20"><br />
		주소 : <input type="text" name="address" size="50"><br />		
		<!-- 역시 아래줄도 submit이 아니라 버튼으로 되어 있다. 
		javascript를 이용하여 버튼을 누르면	members.js파일의 infoConfirm()
		메서드를 호출한다.현업에서는 이렇게 자바스크립트를 이용해서 사용하는 경우가 많다.
		그렇기 때문에 심화 과정은 아니더라도 기본적인 정도는 학습을 해야 한다. -->		
		<input type="button" value="회원가입" 
			onclick="infoConfirm()">&nbsp;&nbsp;&nbsp; 
		<input type="reset" value="취소" 
			onclick="javascript:window.location='login.jsp'">
	</form>
	<!-- 과제 : joinOk.jsp, logout.jsp, modify.jsp, modifyOk.jsp
		 4개의 파일을 만들어서 프로그램이 정상 작동하는 확인하며, 텍스트 파일로 작성하여
		  메일로 보낸다. 
	--> 
</body>
</html>