<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>include01.jsp페이지입니다.</h1>
	<!--앞서 include를 사용해봤는데 그때의 include는 페이지지시자(directive)를 이용한 것이고
	이번에는 액션태그를 이용한 것이다. 차이점이라면, 액션태그는 페이지를 모듈화(합침)하는데
	사용되어지고, 처기 결과만 포함되는 것이다. 하지만, 페이지 지시자는 소스코드가 텍스트로 포함되어진다.
	그래서 조각코드를 삽입할 정도로 많이 사용한다.
	
	그리고 flush속성을 true로 설정을 하면 포함될 페이지로 이동하기 전에 현재 페이지가 지금까지 버퍼에 가지고 있던 내용을 다 
	웹브아두저에 출력하고 버퍼를 비운다. 통산 false로 설정해주는데 true로 설정하면 버퍼에 저장되어 있던 내용을 웹브라우저에 전송
	할 때 , 헤더정보도 같이 전송하고 이렇게 되면 헤더정보를 추가해도 더이상 반영되지 않기 떄문이다.
	또한, include액션태그는 제어권을 임시로 포하뫼어진 페이지로 넘겼다가 그 페이지의 요청이 끝나면 다시 원래 페이지가 제어권을 갖게 된다.
	그리고 페이지 지시자 include는 정적인 코드(저작권 표시)포함할때 주로 사용하고 include액션태그는 동적인 페이지를 포함시키고자 할 때 사용
	이렇게 include액션태그는 여러 페이지를 동적으로 하나의 페이지로 묶을 수 있으므로, 각각의 페이지를 기능별로 모듈화가 가능하다.
	이것을 탬플릿 페이지라고 한다. forward는 버퍼자체를 지우고 새로운 페이지로 이동하는 것이다. 하지만 include는 말 그대로 포함하는 것이다.
 -->
	<jsp:include page="include02.jsp" flush="false"/>
	<h1>다시 include01.jsp 페이지입니다.</h1>

</body>
</html>