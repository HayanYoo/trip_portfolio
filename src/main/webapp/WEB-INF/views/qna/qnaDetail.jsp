<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<br><br><br>
<div class="qna-center">
	<h2>Q&A</h2><br>
	<form name="frm" method="post">	
		<br><input type="hidden" name="qseq" value="${qna.qseq}"/>
		<table id="cartList" >
			<tr>
				<th style="width:80px;">제목</th>
				<td><div style="margin:3px; text-align : left;">${qna.subject}</div></td>			
			</tr>
			<tr>
				<th style=" height:250px;">내용</th>
				<td class="qna-table">
					<div style="margin:15px 3px; text-align : left;">${qna.content}</div>
				</td>	
			</tr>
			<c:choose>
				<c:when test="${!empty qna.reply}">
					<tr>
						<th style="background-color:#6c757d21;">답변</th>
						<td class="qna-table">
							<div style="margin:15px 3px; text-align : left;">${qna.reply}</div>
						</td>	
					</tr>
				</c:when>
			</c:choose>
		</table>
		<br><br>
		<div class="bottons">
			<input type="button" value="삭제" class="submit btn btn-danger login-btn" style="margin-bottom: 10px;" onclick="delete_qna()"/>
			<input type="button" value="목록" class="submit btn btn-secondary login-btn" style="margin-bottom: 10px;" onclick="location='qna_list'"/>
		</div>
		<br>
	</form>
</div>

<%@ include file="../footer.jsp" %>