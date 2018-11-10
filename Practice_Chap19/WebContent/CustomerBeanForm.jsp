<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>
#formArea {
	margin: auto;
	width: 400px;
	border: 1px solid black;
	background-color: yellow;
}

h1, fieldset {
	text-align: center;
}
</style>

<body>

	<!--section태그안에 id값 설정 및 form태그를 삽입하며, post방식으로
customerbeanTest02.jsp에 데이터를 전송한다.  -->
	<section id="formArea">
		<h1>사용자 입력</h1>
		<form action="CustomerbeanTest02.jsp" method="post">
			<fieldset>
				<!--value값은 사용자로 부터 입력받는다.  -->
				<label>이름:</label> <input type="text" name="name" id="name" /><br>
				<label>주소:</label> <input type="text" name="addr" id="addr" /><br>
				<label>이메일주소:</label> <input type="email" name="email" id="email" /><br>
				<label>생년월일:</label> <input type="date" name="birthday"
					id="birthday" /><br> <input type="submit" value="전송">
			</fieldset>
		</form>
	</section>

</body>
</html>