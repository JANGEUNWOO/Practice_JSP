<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 폼</title>
<style type="text/css">
#formArea {
   margin: auto;
   width: 400px;
   border: 1px solid gray;
   text-align: center;
}

h1 {
   text-align: center;
}

table {
   width: 300px;
   margin: auto;
   text-align: center;
}
</style>
</head>
<body>
   <section id="formArea">
      <h1>회원정보 입력</h1>
      <!-- 아래와 같이 회원정보를 입력받고 joinChk.jsp로 post방식으로 보내고 있다. -->
      <form action="joinChk.jsp" method="post">
         <table>
            <tr>
               <td><label>아이디: </label></td>
               <td><input type="text" name="id" id="id"></td>
            </tr>
            <tr>
               <td><label>비밀번호: </label></td>
               <td><input type="password" name="pw" id="pw"></td>
            </tr>
            <tr>
               <td><label>이름: </label></td>
               <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
               <td><label>성별: </label></td>
               <td><input type="radio" name="sex" id="sex" value="1"
                  checked="checked">남 <input type="radio" name="sex"
                  id="sex" value="2">여</td>
            </tr>
            <tr>
               <td><label>나이: </label></td>
               <td><input type="text" name="age" id="age"></td>
            </tr>
            <tr>
               <td><label>이메일 주소: </label></td>
               <td><input type="email" name="email" id="email"></td>
            </tr>
            <tr>
               <td colspan="2"><input type="submit" value="가입"> 
               <input type="reset" value="다시 작성"></td>
            </tr>
         </table>
      </form>
   </section>
</body>
</html>