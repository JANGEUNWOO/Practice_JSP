<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%
   Cookie[] cookies=request.getCookies(); //1. ��Ű�� �����ϰ�

   for(int i=0;i<cookies.length;i++){
      String str=cookies[i].getName();
      if(str.equals("cookieN")){
         out.println("name:"+cookies[i].getName()+"<br/>");
         cookies[i].setMaxAge(0);   //2. ��Ű ��ȿ�Ⱓ�� 0�ʷ� ���� 
         response.addCookie(cookies[i]); //3. response�� ž��(������ �������� ������ ���������̴�.)
         
      }
   }
%>

<a href="cookietest.jsp">��ŰȮ��</a>

</body>
</html>