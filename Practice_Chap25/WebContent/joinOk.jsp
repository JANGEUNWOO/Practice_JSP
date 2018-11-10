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
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원 가입 인증</title>
</head>
<body>
<%
	//아래 setrDate는 현재 시스템의 시간을 set하고 있는 것이다. 이미 자바에서 공부했다.
	dto.setrDate(new Timestamp(System.currentTimeMillis()).toString());
	MemberDao dao = MemberDao.getInstance();
	
	if(dao.confirmId(dto.getId()) == MemberDao.MEMBER_EXISTENT) {
%>
	<script lang="javascript">
		alert("아이디가 이미 존재 합니다.");
		history.back();
	</script>
<%
	} 
	else {		
		int ri = dao.insertMember(dto);		
		if(ri == MemberDao.MEMBER_JOIN_SUCCESS) {
			session.setAttribute("id", dto.getId());
%>
		
		<script lang="javascript">
			alert("회원가입을 축하 합니다.");
			document.location.href="login.jsp";
		</script>
<%
		} else {
%>
		<script lang="javascript">
			alert("회원가입에 실패했습니다.");
			document.location.href="login.jsp";
		</script>
<%
		}
	}
%>
</body>
</html>