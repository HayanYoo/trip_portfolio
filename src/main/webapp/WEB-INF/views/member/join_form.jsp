<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>



<br><br><br>
   <h3 class="join-title">JOIN</h3><br><br><br>
    <form id="join" action="join" method="post" name="formm" enctype="multipart/form-data">
   <div class="join-form"> 
        <h4>회원정보</h4><br>
        <hr><Br>
        <label class="col-2">프로필사진</label>
        <input type="file" name="member_image"><br>
        <label class="col-2">이름</label>
        <input type="text"      name="name" size="10"><br> 
        <label class="col-2">아이디</label>
        <input type="text"      name="user_id">
        <input type="hidden"    name="reid">
        <input type="button"    value="중복 체크"  class="dup" onclick="idcheck()"><br>
        <label class="col-2">비밀번호</label>
        <input type="password"  name="pwd"><br> 
        <label class="col-2">비밀번호 확인</label>
        <input type="password"  name="pwdCheck"><br>
        <label class="col-2">생일</label>
        <input type="date"      name="birth"><br>
        <label class="col-2">전화번호</label> 
        <input  type="text"       name="phone"><br>
        <label class="col-2">이메일</label>
        <input type="email"      name="email" size="45"><br><br>
         <hr><br>
        
        <div id="buttons">
			<input type="button" value="회원가입" class="submit btn btn-danger" onclick="go_save()">&nbsp;&nbsp;&nbsp; 
			<input type="reset" value="취소" class="btn btn-secondary"><br>
		</div>
    </div>

</form>
<br><br>
<%@ include file="../footer.jsp"%>
