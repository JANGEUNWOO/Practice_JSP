

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%
/*responseExample02.jsp 페이지를 보내고 있다.  */
System.out.println("responseExample01.jsp파일을 실행함!");
response.sendRedirect("responseExample02.jsp");
%>