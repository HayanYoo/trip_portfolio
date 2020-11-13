<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../header.jsp" %>
<br><br><h3 class="text-center">My Page</h3>

<%@ include file ="sub_menu.jsp" %>


<div class="mypage-left">
	<table>
		<tr>
			<td>이름</td>
			<td>${member.name}홍길동</td>
		</tr>
		<tr>
			<td>아이디</td>
			<td>${member.user_id}아이디</td>
		</tr>
		<tr>
			<td>생일</td>
			<td>${member.birth}생일</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>${member.phone}전화번호</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>${member.birth}이메일</td>
		</tr>
	</table>
</div>

<br>
<%@ include file ="../footer.jsp" %>