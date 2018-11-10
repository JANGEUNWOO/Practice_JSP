<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%!
   Connection conn = null;
   PreparedStatement psmt = null;
   ResultSet set = null;

   private String id, pw, name, eMail, address, rDate;
%>
<html>
<head>
<meta charset="UTF-8">
<title>정보수정</title>
</head>
<body>
<%
   //아직 세션이 살아있기 때문에 id값을 얻어온다.
   id = (String)session.getAttribute("id");
   //DB연결문 설정
   String driver = "com.mysql.jdbc.Driver";
   String url = "jdbc:mysql://localhost/sqldb";
   String uid = "root";
   String upw = "1234";
   String query = "select* from members where id = ?";
   try{
      Class.forName(driver);
      conn = DriverManager.getConnection(url, uid, upw);
      psmt = conn.prepareStatement(query);
      psmt.setString(1, id);
      set = psmt.executeQuery();
      System.out.println(query);
   }catch(Exception e){e.printStackTrace();}
   
   while(set.next()){
      //System.out.println("while()");
      id = set.getString("id");
      pw = set.getString("pw");
      name = set.getString("name");
      eMail = set.getString("eMail");
      address = set.getString("address");
      rDate = set.getString("rDate");
   }
%>

<form action="modifyOk" method="post">
   아이디 : <input type="text" name="id" value=<%=id %> size="10"><br/>
   <!-- 비밀번호 수정하기 위해 재입력을 받는다. -->
   비밀번호 : <input type="password" name="pw"size="10"><br/>
   이름 : <input type="text" name="name" value=<%=name %> size="15"><br/>
   이메일 : <input type="text" name="eMail" value=<%=eMail %> size="20"><br/>
   주소 : <input type="text" name="address" value=<%=address %> size="50"><br/>
   <input type="submit" value="회원정보 수정">
   <input type="reset" value="취소">     
   

</form>

</body>
</html>