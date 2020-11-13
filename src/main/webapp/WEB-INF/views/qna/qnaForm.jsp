<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<br><br><br>
<div class="qna-center">
	<h2>1:1 질문하기</h2><br>
	<form name="frm" method="post">	
		<br><input type="hidden" name="user_id" value="${sessionScope.loginUser.user_id}">
		<table id="cartList">
			<tr>
				<th style="width:80px;">제목</th>
				<td><input type="text" name="subject" size="77"  style="margin:3px;"></td>			
			</tr>
			<tr>
				<th>내용</th>
				<td class="qna-table"><textarea rows="15" cols="80" name="content" style="margin:3px;"></textarea></td>	
			</tr>
			
		</table>
		<br><br>
		<div class="bottons">	
			<input type="button" value="질문등록" class="submit btn btn-danger login-btn" style="margin-bottom: 10px;" onclick="insert_qna()"/>
			<input type="button" value="취소" class="submit btn btn-secondary login-btn" style="margin-bottom: 10px;" onclick="location='qna_list'"/>
		</div>
		<br>
	</form>
</div>

<%@ include file="../footer.jsp" %>