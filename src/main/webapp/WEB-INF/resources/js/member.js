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


function addoption(){
	if(document.formm.area.value == ""){
		alert("지역을 입력해 주세요!");
		document.formm.area.focus();
	} else if(document.formm.startdate.value == ""){
		alert("여행 시작일을 입력 해주세요!");
		document.formm.startdate.focus();
	} else if(document.formm.enddate.value == ""){
		alert("여행 종료일을 입력해 주세요!");
		document.formm.enddate.focus();
	} else if(document.formm.adult.value == ""){
		alert("성인 인원 수를 주세요!");
		document.formm.adult.focus();
	} else if(document.formm.kid.value == ""){
		alert("아동 인원 수를 주세요!");
		document.formm.kid.focus();
	} else if(document.formm.minbudget.value == ""){
		alert("최소 예산액을 입력해 주세요!");
		document.formm.minbudget.focus();
	} else if(document.formm.maxbudget.value == ""){
		alert("최대 예산액을 입력해 주세요!");
		document.formm.maxbudget.focus();
	} else if(document.formm.minoption.value == ""){
		alert("최소 옵션 갯수를 입력해 주세요!");
		document.formm.minoption.focus();
	} else if(document.formm.maxoption.value == ""){
		alert("최대 옵션 갯수를 입력해 주세요!");
		document.formm.maxoption.focus();
	} else {
		document.formm.action="product_list";
		document.formm.submit();
		}
}


function find_id(){
	if(document.findId.name.value == "") {
		alert("이름을 입력해주세요.");
		document.findId.name.focus();
	} else if (document.findId.email.value == "") {
		alert("이메일을 입력해주세요.");
		document.findId.email.focus();
	} else {
		document.findId.action = "find_id";
		document.findId.submit();
	}
}


function find_pwd(){
	
	 if (document.theForm.user_id.value == "") {
		alert("아이디를 입력해주세요.");
		document.theForm.user_id.focus();
	}	
	else if(document.theForm.name.value == "") {
		alert("이름을 입력해주세요.");
		document.theForm.name.focus();
	} else if (document.theForm.email.value == "") {
		alert("이메일을 입력해주세요.");
		document.theForm.email.focus();
	} else {
		document.theForm.action = "find_pwd";
		document.theForm.submit();
	}
	
}

function change_pwd() {
	if(document.formm.pwd.value == ""){
		alert("비밀번호를 입력해 주세요!");
		document.formm.pwd.focus();
	} else if(document.formm.pwd.value != document.formm.pwdChk.value){
		alert("비밀번호를 확인해주세요!");
		document.formm.pwd.focus();
	} else {
		document.formm.action = "change_pwd";
		document.formm.submit();
	}
}


function insert_qna() {
	if(document.frm.subject.value ==""){
		alret("제목을 입력해주세요!");
		document.frm.subject.focus();
	} else if(document.frm.content.value ==""){
		alret("내용을 입력해주세요!");
		document.frm.content.focus();
	} else {
		document.frm.action="insert_qna";
		document.frm.submit();
	}
}


function delete_qna() {
	var result = confirm("삭제하시겠습니까?");
	
	if (result){
		document.frm.action ="delete_qna";
		document.frm.submit();
	} 
}



function withdraw_confirm() {
	result = confirm("탈퇴하시겠습니까?");
	
	if (result){
		document.formm.action="withdraw";
		document.formm.submit();
	}
}


function change_info() {
	 if(document.formm.name.value == ""){
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
		document.formm.action = "change_info";
		document.formm.submit();
	}
}

