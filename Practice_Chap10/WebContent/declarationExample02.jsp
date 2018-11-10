<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!-- 표현식은 세미콜론을 붙이지 않음을 꼭 기억하자. -->
<h1><%=getStr()%></h1>




<%!
	private String str = "선언문 ";

	private String getStr() {
		str += "테스트입니다.";
		return str;
	}
%>