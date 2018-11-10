<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!String age;%>

	<%
	
		request.setCharacterEncoding("UTF-8");
		age = request.getParameter("age");
		System.out.println("request_send.jsp 호출나이는: "+age);
	    if(Integer.parseInt(age)>=20){
	    	
	    	response.sendRedirect("pass.jsp?age="+age);
	    }else{
	    	
	    	response.sendRedirect("na.jsp?age="+age);
	    }
	%>

</body>
</html>