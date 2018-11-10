<%@page import="sec01_exam.New_MemberDTO"%>
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
   <!-- <form action="InputDataFormOk.jsp" method="post"> -->
   <form method="post">
      이름 : <input type="text" name="name" size="10"><br />
      아이디 : <input type="text" name="id" size="10"><br />
      비밀번호 : <input type="password" name="pw" size="10"><br />      
      전화번호1 : <input type="text" name="phone1" size="5">&nbsp;
      전화번호2 : <input type="text" name="phone2" size="10">&nbsp;
      전화번호3 : <input type="text" name="phone3" size="10"><br />
      성별 : <input type="text" name="gender" size="10"><br />
      <input type="submit" value="데이터입력">
      <input type="reset" value="취소">
   </form>
   
   <%   
   String name = request.getParameter("name");
   if(name != null){
      String id = request.getParameter("id");
      String pw = request.getParameter("pw");
      String phone1 = request.getParameter("phone1");
      String phone2 = request.getParameter("phone2");
      String phone3 = request.getParameter("phone3");
      String gender = request.getParameter("gender");   
      New_MemberDAO memberDao = new New_MemberDAO();
      int a = memberDao.memberInsert(new New_MemberDTO(name, id, pw, phone1, phone2, phone3, gender));
      
      request.setCharacterEncoding("UTF-8");
      
      if(a == -1){
   %>
   <script type="text/javascript">
      alert('데이터 입력 실패');
   </script>
   <%
      }
      else{
   %>
   <script type="text/javascript">
      alert('데이터 입력 성공');
   </script>
   <%         
      }   
   }
   %>   
</body>
</html>