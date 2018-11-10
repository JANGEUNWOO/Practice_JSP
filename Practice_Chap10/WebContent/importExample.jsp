<!--페이지 지시자로 속성들을 지시하고 있다. jsp를 지원하는 언어는 현존하는 언어중 자바밖에 없다
1. 페이지 지시자의 형식

2.속성의 종류와 사용법						,기본값		,설명
--------------------------------------------------------------------------
-language	,language="java"		,java		,스크립트 요소에서 사용할 언어 설정
-extends	,extends="클래스명"		,없음			,상송받을 클래스를 설정
-import		,import-"패키지, 클래스명"	,없음			,import할 패키지,클래스 설정
-session	,session="true"			,true		,HttpSession사용여부를 설정
-buffer		,buffer="16kb"			,8kb		,jsp페이지의 출력버퍼크기를 설정
-autoFlush	,autoFlush="true"		,true		,출력버처가 다 찼을 경우 처리방법 설정
-isThreadSafe,isThreadSafe="true" 	,없음			,다중스레드 동시실행 여부를 설정
-info		,info="페이지 설명"			,없음			,페이지 설명
-errorPage	,errorPage="에러페이지.jsp",없음			,에러 페이지로 사용할 페이지를 지정
-contentType,contentType="text/html",ISO-8859-1	,JSP페이지가 생성할 문자의 타입을 지정
-isErrorPage,isErrorPage="false"	,false		,현재 페이지를 에러페이지로 지정할지 설정
-pageEncoding, PageEncoding="UTF-8"	,ISO-8859-1	,현재 페이지의 문자 인코딩 타입 설정
 -------------------------------------------------------------------------
 -->
<!-- 페이지 지시자들이다. 잘확인해보자. -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!--import속성  -->
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<html>
<head>
<meta http-equiv="content-Type" content="text/html" charset="UTF-8">
<title>import 속성 스레드</title>
</head>
<body>
	<h1>현재 시간은 <%=new SimpleDateFormat().format(new Date()) %>입니다.</h1>
</body>
</html>