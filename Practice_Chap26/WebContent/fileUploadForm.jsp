<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
/* id선택자 */
#uploadFormArea{
margin:auto;
width:350px;
border:1px solid black;
}
/* 클래스 선택자  */
.td_title{
font-size: xx-Large;
text-align: center;
}
</style>
</head>
<body>
<section id="uploadFormArea">
<!--파일을 업로드 하기 위해서 enctype을 multipart/form-data로 설정하였다.  -->
<form action="fileUpload.jsp" method="post" enctype="multipart/form=data">
<table>
<tr>
<td colspan="2" class="td_title">파일 업로드 폼</td>
<tr>
<td><label>올린 사람:</label></td>
<td><input type="text" name="name" id="name"></td>
</tr>
<tr>
<td><label>제목:</label></td>
<td><input type="text" name="subject" id="subject"></td>
</tr>
<tr>
<td><label>파일명1:</label></td>
<!--업로드할 파일을 설정하기 위해서 type을 file로 하였다.  -->
<td><input type="file" name="fileName1" id="fileName1"></td>
</tr>
<tr>
<td><label>파일명2:</label></td>
<!--업로드할 파일을 설정하기 위해서 type을 file로 하였다.  -->
<td><input type="file" name="fileName2" id="fileName2"></td>
</tr>
<tr>
<td colspan="2" align="center">
<input type="submit" value="전송"></td>
</tr>
</table>
</form>
`
</section>


</body>
</html>