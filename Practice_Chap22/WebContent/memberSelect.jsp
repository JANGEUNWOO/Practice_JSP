<%@page import="sec01_exam.New_MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sec01_exam.New_MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
 //MemberDAO를 생성하고 memberSelect()를 호출하고 있다.
 New_MemberDAO memberDao = new New_MemberDAO();
 ArrayList<New_MemberDTO> dtos = memberDao.memberSelect();
 request.setCharacterEncoding("UTF-8");
 //반환값으로 받은 ArrayList<MemberDAO>를 하나씩 얻어서 출력하고 있다.
 for(int i=0; i<dtos.size(); i++){
	 //ArrayList<MemberDTO>에서  추가된 MemberDTO객체를 하나씩 꺼내고 있다.
	 New_MemberDTO dto = dtos.get(i);
	 String name = dto.getName();
	 String id = dto.getId();
	 String pw = dto.getPw();
	 String phone = dto.getPhone1() + "-" + dto.getPhone2() + "-" + dto.getPhone3();
	 String gender = dto.getGender();
	 
	 out.println("이름:"+name+"아이디:"+id+"비밀번호:"+pw+"전화번호:"+phone+"성별:"+gender+"<br>");
 }
%>
</body>
</html>
<!-- 데이터 입력폼 만들기: inputDataForm.jsp 
DAO클래스에 public int memberInsert(New_MemberDTO new_MemberDTO){}메서드 추가하기,
입력되는 것을 확인하기 위해 기 만들어진 memberSelect()로 확인하고
DAO파일과 inputDataForm.jsp파일의 내용을 txt파일로 만들어서 메일로 보내기-->