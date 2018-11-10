<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<style type="text/css">
h1, #commandCell {
   text-align: center;
}

table {
   margin: auto;
   width: 400px;
   border: 1px solid red;
   background-color: yellow;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>Request 예제</h1>
   <!-- requestExample01.jsp파일에 post방식으로 요청하고 있다. -->
   <form action="requestExmple01.jsp" method="post">
      <!-- 테이블 생성 -->
      <table border="1">
         <tr>
            <!-- 첫 번째 행 -->
            <td><label>이름</label>
            <td><input type="text" name="name" id="name"></td>
         </tr>
         <tr>
            <!-- 두 번쨰 행 -->
            <td><label>성별</label>
            <td>남<input type="radio" name="gender" value="male" id="gender">
               여<input type="radio" name="gender" value="female">
            </td>

         </tr>
         <tr>
            <!-- 세 번쨰 행 -->
            <td><label>취미</label>
            <td>독서 <input type="checkbox" name="hobby" value="독서"
               id="hobby"> 게임 <input type="checkbox" name="hobby"
               value="게임" id="hobby"> TV시청 <input type="checkbox"
               name="hobby" value="TV시청" id="hobby"> 축구 <input
               type="checkbox" name="hobby" value="축구" id="hobby"> 기타 <input
               type="checkbox" name="hobby" value="기타" id="hobby">
            </td>
         </tr>
         <tr>
            <!-- 네 번쨰 행 -->
            <td colspan="2" id="commandCell"><input type="submit"
               value="전송">
      </table>


   </form>
</body>
</html>