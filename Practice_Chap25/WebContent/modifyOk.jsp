<%@page import="sec01_exam.MemberDao"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<!-- 클래스인 MemberDto를 사용하겠다 무엇으로? useBean 액션태그를 이용하여.. 
	 또한, dto빈의 모든 속성들을 기본값으로 set하고 있다.-->	
<jsp:useBean id="dto" class="sec01_exam.MemberDto"></jsp:useBean>

<!-- bean에 set을 할때 *을 사용하기 위해서는 반드시 DTO의 필드와 DB의 컬럼이름과 form태그의 name값을 일치되게 해주어야 한다. 
     그것은 프로그래머의 기본이다. -->
<jsp:setProperty name="dto" property="*" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입인증</title>
</head>
<body>

<%
	String id = (String)session.getAttribute("id");
	dto.setId(id);
	
	MemberDao dao = MemberDao.getInstance();
	
	int ri = dao.updateMember(dto);
	if(ri == 1) {
%>
	<script lang="javascript">
		alert("정보 수정되었습니다.");
		document.location.href="main.jsp";
	</script>
<%
	} 
	else {
%>
	<script lang="javascript">
		alert("정보수정에 실패하였습니다.");
		history.go(-1);
	</script>
<%
	}
%>
</body>
</html>