/**
 * 
 */

// 약관 동의 확인
function go_next() {
	if(document.formm.okon1[0].checked == true){
		document.formm.action="join_form";
		document.formm.submit();
	} else {
		alert("약관에 동의하셔야 합니다.");	
	}
}

// 아이디 중복확인
function idcheck() {
	if(document.formm.user_id.value == ""){
		alert("아이디를 입력해주세요!");
		document.formm.user_id.focus();
		return;
	}
	
	var url="id_check_form?user_id=" + document.formm.user_id.value;
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable = no, width=450, height=230");
	
}

//회원가입시 항목이 전부 입력됐는지 확인
function go_save(){
	if(document.formm.user_id.value == ""){
		alert("아이디를 입력해 주세요!");
		document.formm.user_id.focus();
	} else if(document.formm.reid.value == ""){
		alert("아이디 중복확인을 해주세요!");
		document.formm.reid.focus();
	} else if(document.formm.pwd.value == ""){
		alert("비밀번호를 입력해 주세요!");
		document.formm.pwd.focus();
	} else if(document.formm.pwd.value != document.formm.pwdCheck.value){
		alert("비밀번호를 확인해주세요!");
		document.formm.pwd.focus();
	} else if(document.formm.name.value == ""){
		alert("이름을 입력해 주세요!");
		document.formm.name.focus();
	} else if(document.formm.birth.value == ""){
		alert("생일을 입력해 주세요!");
		document.formm.birth.focus();
	} else if(document.formm.phone.value == ""){
		alert("전화번호를 입력해 주세요!");
		document.formm.phone.focus();
	} else if(document.formm.email.value == ""){
		alert("이메일을 입력해 주세요!");
		document.formm.email.focus();
	} else {
		document.formm.action = "join";
		document.formm.submit();
	}
}

