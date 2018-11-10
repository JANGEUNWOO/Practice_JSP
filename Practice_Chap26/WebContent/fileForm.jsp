<!--파일명 : fileForm.jsp  -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!--파일 전송시 enctype을 multipart/form-data로 지정해주어야 하는데 이것은 binary-type(2진화)으로 폼을 전송하라는 것을 명시하는 것이다.  -->
<form action="fileFormOk.jsp" method="post" enctype="multipart/form-data">
<!--input type을 file로 지정하면 자동 ui가 만들어진다.  -->
파일:<input type="file" name="file"><br/>
<input type="submit" value="파일업로드">
</form>

</body>
</html>