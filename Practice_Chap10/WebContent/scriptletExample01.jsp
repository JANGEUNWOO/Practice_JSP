<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content=Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 아래 스크리트릿을 이용하여 자바코드를 삽이하여 로직을 수행하게 하였다.-->
<%
		int i=0;
		while(true){
			i++;
			//out은 내부객체이다.
			out.println("2*"+i+" = "+2*i+"<br/>");
%>
<!-- =======이부분은 html코드이다.-->
=================<br />
<%
		if(i>=9)
			break;

	}
%>
<!-- 우클릭을 하여 소스코드보기를 해보자.  -->
</body>
</html>