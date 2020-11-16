<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../header.jsp" %>
<%@ include file ="sub_menu.jsp" %>

<form name="formm">
	<div class="mypage-left">
		<br><br><h3 class="text-center">My Page</h3>
		<br><br>
		<table>
			<tr>
				<th style="width:130px;">이름</th>
				<td style="width:450px;"><input type="text" name = "name" value="${member.name}"/></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td>${member.user_id}</td>
				<input type="hidden" name="user_id" value="${member.user_id}"/>
				<input type="hidden" name="pwd" value="${member.pwd}"/>
				
			</tr>
			<tr>
				<th>생일</th>
				<td><input type="date" name = birth value="${member.birth}"/></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name = "phone" value="${member.phone}"/></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name = "email" value="${member.email}"/></td>
			</tr>
		</table><br><br>
		<div class="text-center">
			<input type="button" value="정보 수정" class="btn btn-danger" onClick="change_info()"/>
			<input type="button" value="비밀번호 변경" class="submit btn btn-danger" onClick="location.href='change_pass'"/>
			
		</div>
	</div>
</form>
<br><br><br>
<%@ include file ="../footer.jsp" %>