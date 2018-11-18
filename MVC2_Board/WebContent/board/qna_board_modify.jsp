<!-- qna_board_modify.jsp -->
<%@page import="vo.BoardBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	BoardBean article = (BoardBean)request.getAttribute("article");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
	<title>MVC 게시판</title>
	<script type="text/javascript">
	/* 수정 버튼을 눌렀을때, 실제로 여기서 submit이 일어난다. */
	function modifyboard() {
		modifyform.submit();
	}
	</script>
	<style type="text/css">
   #registForm{
      width: 500px;
      height: 600px;
      border : 1px solid red; 
      margin:auto; 
   }   
   h2{
      text-align: center;
   }
   table{
      margin:auto;
      width: 450px;
   }
   .td_left{
      width: 150px;
      background:orange;
   }
   .td_right{
      width: 300px;
      background:skyblue;
   }
   #commandCell{
      text-align: center;      
   }
</style>
</head>
<body>
<!-- 게시글 수정 -->
<section id = "writeForm">
<h2>게시판글 수정</h2>
	<form action="boardModifyPro.bo" method="post" name="modifyform">
	<input type = "hidden" name = "BOARD_NUM" 
		   value="<%=article.getBOARD_NUM()%>"/>
	<table>
	<tr>
		<td class="td_left"><label>글쓴이</label></td>
		<td class="td_right">
			<input type="text" name="BOARD_NAME" id="BOARD_NAME" 
				   value="<%=article.getBOARD_NAME()%>"/>
		</td>
	</tr>
	<tr>
		<td class="td_left"><label>비밀번호</label></td>
		<td class="td_right">
			<input name="BOARD_PASS" type="password" id="BOARD_PASS"/>
		</td>
	</tr>
	<tr>
		<td class="td_left"><label>제 목</label></td>
		<td class="td_right">
			<input name="BOARD_SUBJECT" type="text" id="BOARD_SUBJECT" 
				   value="<%=article.getBOARD_SUBJECT()%>"/>
		</td>
	</tr>
	<tr>
		<td class="td_left"><label>내 용</label></td>
		<td>
			<textarea id="BOARD_CONTENT" name="BOARD_CONTENT" 
			cols="40" rows="15"><%=article.getBOARD_CONTENT()%>
			</textarea>
		</td>
	</tr>
	</table>
	<section id="commandCell">
		<!-- 수정버튼을 눌렸을때 자바스크립트 함수인 modifyboard()를 호출하고 있다. -->
		<a href="javascript:modifyboard()">[수정]</a>&nbsp;&nbsp;
		<a href="javascript:history.go(-1)">[뒤로]</a>
	</section>
</form>
</section>
</body>
</html>