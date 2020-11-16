<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../header.jsp" %>
<%@ include file ="sub_menu.jsp" %>

<form name="formm">
	<div class="mypage-left">
		<br><br><h3 class="text-center">My Page</h3>
		<br><br>
		<input type="hidden" name ="name" value="${member.name}"/>
		<input type="hidden" name ="user_id" value="${member.user_id}"/>
		<input type="hidden" name ="email" value="${member.email}"/>
		<table>
			<tr>
				<th style="width:130px;">이름</th>
				<td style="width:450px;">${member.name}</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td>${member.user_id}</td>
			</tr>
			<tr>
				<th>생일</th>
				<td>${member.birth}</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>${member.phone}</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>${member.email}</td>
			</tr>
		</table><br><br>
		<div class="text-center">
			<input type="button" value="메인으로" class="submit btn btn-danger" onClick="location.href='index'"/>
			<input type="button" value="탈퇴하기" class="btn btn-secondary" onClick="withdraw_confirm()"/>
		</div>
	</div>
</form>
<br><br><br>
<%@ include file ="../footer.jsp" %>