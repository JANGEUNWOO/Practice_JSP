<%@page import="sec01_exam.MemberDto"%>
<%@page import="sec01_exam.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%  
	//인코딩설정 후 id값으로 dto객체의 정보를 다 가져오고 있다.
	request.setCharacterEncoding("UTF-8");
	String id  = (String)session.getAttribute("id");
	MemberDao dao = MemberDao.getInstance();
	MemberDto dto = dao.getMember(id);
%>

    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<!-- 자바스크립스 소스를 쓰겠다고 다시 명시한다. -->
<script lang="JavaScript" src="members.js"></script>

</head>
<body>
	<form action="modifyOk.jsp" method="post" name="reg_frm">
		<!-- 아이디와 이름은 변경되지 말아야 할것이다. 하지만 원한다면 이름은 개명했을 경우 변경가능하게 하면 될것이다. -->
		<!-- dto객체로 부터 id와 mail, adress를 가져와서 익스프레션으로 미리 찍어주고 있다. -->	
		아이디 : <%= dto.getId() %> <br/>
		비밀번호 : <input type="password" name="pw" size="20"><br/>
		비밀번호 확인: <input type="password" name="pw_check" size="20"><br/>
		이름 : <%=dto.getName() %> <br />
		메일 : <input type="text" name="eMail" size="20" value="<%=dto.geteMail() %>" > <br/>
		주소 : <input type="text" name="address" size="20" value="<%=dto.getAddress()%>" > <br/>
		
		<input type="button" value="수정" onclick="updateInfoConfirm()"> &nbsp;&nbsp;&nbsp;&nbsp;
		<input type="reset"  value="취소" onclick="javascript:window.location='login.jsp'" >	
	</form>	
</body>
</html>