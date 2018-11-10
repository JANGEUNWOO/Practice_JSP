/*파일명 : members.js*/
/*
  	자바스크립트 파일인 members.js파일입니다. 여기는 javascript를 사용하기 위해서 
  	선언한 함수들의 리스트를 적습니다.
  	혹여 한글이 깨져서 나오는 경우는 인코딩방식이 잘못되었기 때문에 반드시 unicode로 인코딩을
  	바꿔줘야 한다.
*/
function infoConfirm() {
	//여기서 document는 현재페이지를 의미하고, reg_frm은 form의 이름이다.
	//하여 form의 id.value는 사용자가 입력한 값 그리고 length는 역시 값의 길이인것이다.
	if(document.reg_frm.id.value.length == 0) {
		alert("아이디는 필수사항입니다.!")
		reg_frm.id.focus();  //alert를 띄우고 다시 id입력란으로 초점을 이동하라는 것이다(focus())
		return;
	}	
	if(document.reg_frm.id.value.length < 4) {
		alert("아이디는 최소 4글자 이상이어야 합니다.!")
		reg_frm.id.focus();
		return;
	}	
	if(document.reg_frm.pw.value.length == 0) {
		alert("비밀번호는 필수 사항입니다.");
		reg_frm.pw.focus();
		return;
	}	
	if(document.reg_frm.pw.value != document.reg_frm.pw_check.value) {
		alert("비밀번호가 일치하지 않습니다.");
		reg_frm.pw.focus();
		return;
	}	
	if(document.reg_frm.name.value.length == 0) {
		alert("이름는 필수 사항입니다.");
		reg_frm.name.focus();
		return;
	}	
	if(document.reg_frm.eMail.value.length == 0) {
		alert("메일은 필수 사항입니다.");
		reg_frm.eMail.focus();
		return;
	}	
	//join.jsp파일엔 submit이 없다. 하여 위의 조건을 다 만족한다면 
	//비로서 자바스크립트 이파일에서 submit()을 호출하여 전송한다.
	document.reg_frm.submit();
}


function updateInfoConfirm() {
	if(document.reg_frm.pw.value.length == 0)	{
		alert("패스워드를 입력하세요.");
		document.reg_frm.pw.focus();
		return;
	}
	
	if(document.reg_frm.pw.value != document.reg_frm.pw_check.value) {
		alert("패스워드가 일치하지 않습니다.");
		reg_frm.pw.focus();
		return;
	}
	
	document.reg_frm.submit();	
}

