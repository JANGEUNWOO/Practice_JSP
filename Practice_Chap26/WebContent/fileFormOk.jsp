<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
//실제 파일이 저장되어지는 곳이다.
String path=request.getRealPath("fileFolder");
int size=1024*1024*10; //10M
//file은 실제 업로드한 파일 이름이며, orifile은 업로드 하려고 보니 똑같은 이름이 있는 경우도 있을 것이다.
//그것을 대비하여 만들어 놓은 형태이다.
//즉, 원본 파일은 그대로 있고 그 이름에 -1이렇게 붙이는 용도인 것이다.
String file="";
String orifile="";
out.println(path+"<br/>");
try{
	//Multipartrequest클래스와 DefaultFilerenamePolicy클래스는 cos.jar에 
	//있는 클래스들이다. DefaultFileRenamePolicy클래스를 매개값으로 주는 것은
	//으ㅏㄴ버파일의 이름에 1,2,3,... 이렇게 붙게하는 역할을 하는 것이다.
	MultipartRequest multi=new MultipartRequest(
			request,path,size,"UTF-8",
			new DefaultFileRenamePolicy());
	//생성된 MultipartRequest객체로 파일 이름을 다 얻어온다
	Enumeration files=multi.getFileNames();
	//파일이름을 어어온다
	String str=(String)files.nextElement();
	file=multi.getFilesystemName(str);
	//실제 있는 파일이름을 구해오는 역할
	orifile=multi.getOriginalFileName(str);
	out.println(file+"<br/>"); //업로드 파일이름 출력
	out.println(orifile+"<br/>");// 이전 파일이름 출력
}catch(Exception e){e.printStackTrace();}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>
파일업로드 성공



</body>
</html>