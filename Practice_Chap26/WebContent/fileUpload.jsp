<%@page import="javax.security.auth.Subject"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    //업로드될 파일의 위치
    String uploadPath=request.getRealPath("/upload");
    int size=100*1024*1024; //100메가
    String name="";
    String subject="";
    String filename1="";
    String filename2="";
    String origfilename1="";
    String origfilename2="";
    
    try{
    	//request : 입력요청폼에서 넘어온 request객체
    	//uploadPath : 업로드 될 파일의 위치
    	//size : 한번에 올릴 수 있는 파일 크기(넘으면 예외발생)
    	//UTF-8 : 인코딩 방식
    	//new DefaultFileRenamePolicy() : 파일 이름 중복 방지를 하는 클래스
    	MultipartRequest multi=
    	new MultipartRequest(request, uploadPath, size, "UTF-8", new DefaultFileRenamePolicy());
    	//request객체로 받는 것이 아니라, MultipartRequest객체로 받고 있는 것에 주목하자.
    	name=multi.getParameter("name"); //올린사람
    	subject=multi.getParameter("subject"); //제목
    	//업로드 할 파일 이름 리스트를 열거타입으로 리턴
    	Enumeration files=multi.getFileNames();
    	//첫번째 업로드할 파일명 가져온다.
    	String file1=(String)files.nextElement();
    	//서버쪽에 올라가는 파일명 리턴(다를 수 있다)
    	filename1=multi.getFilesystemName(file1);
    	origfilename1=multi.getOriginalFileName(file1);
    	String file2=(String)files.nextElement();
    	filename2=multi.getOriginalFileName(file2);
    } catch(Exception e){e.printStackTrace();}
    
    %>
    
<html>
<body>
<form name="filecheck" action="fileCheck.jsp" method="post" >
<!--type을 hidden으로 설정하였다. hidden타입은 숨겨진 입력필드를 정의할 때, 사용한다.
화며상에 보이지 않지만, 폼데이터를 서버로 전송할 때 사용한다. 예를 들면, 회원가입시 가입경로나 날짜 같은 경우이다. 여기서는 file은 보여지지 않기 때문에 hidden으로 두었다.-->
<input type="hidden" name="name" value="<%=name%>">
<input type="hidden" name="subject" value="<%=subject%>">
<input type="hidden" name="filename1" value="<%=filename1%>">
<input type="hidden" name="filename2" value="<%=filename2%>">
<input type="hidden" name="origfilename1" value="<%=origfilename1%>">
<input type="hidden" name="origfilename2" value="<%=origfilename2%>">
<input type="submit" value="업로드 확인 및 다운로드 페이지 이동">
</form>
</body>
</html>