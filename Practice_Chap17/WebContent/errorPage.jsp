<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!--페이지 지시자를 이용하여 isErrorPage속성을 true로 설정해준다. 설정을 해줘야 exception 객체를 참조할 수 있으며, 이페이지가 실행이 되는 것이다. 원래, 기본값은 
false가 되어 있다.  -->

<%@ page isErrorPage="true"%>

<!--정상적인 페이지라고 명시하기 위해 response 객체의 setStatus메서드를 이용해서 200이란 값을 지정해 주고 있다. 그렇지 아니하면 웹컨테이너에서 보통 500으로 설정을
하려고 해서 예외 페이지로 이동하지 않고 보기 싫은 페이지로 이동한다. 현재 이페이지는 예외가 발생한 페이지가 아니다. 단지, 다른 페이지에서 예외가 발생하여 이 페이지를 이동을 시키게 되면 작동하는 
정상적인 페이지 인 것이다. 근데 버전이 업그레이드 되면서 500으로 설정을 해주지 않는 경우도 발생한다.(간혹)  -->

<%
response.setStatus(200);
response.setCharacterEncoding("UTF-8");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 페이지를 찾지 못하는 404에러 같은 경우는, 이동하려는 대상 페이지가 존재하기 떄문에 그 페이지가 존재하지 않는 상태이므로 exception객체를 참조할 수 없다.
하여, 404에러 같은 경우에는 exception객체를 사용하지 않도록 한다. -->

에러 발생 <br/>
<!--표현식으로 에러가 발생한 내용을 보여준다.  -->
<%=exception.getMessage() %>

</body>
</html>
