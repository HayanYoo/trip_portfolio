<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<br><br>
<div class="product-center">
	<h2>Q&A</h2><br><br>

	<br>
	<table id="cartList">
		<tr style="height: 30px;">
			<th>번호</th>
			<th>제목</th>
			<th>등록일</th>
			<th>답변</th>
		</tr>
		<c:forEach items="${qnaList}" var="qna">
		<tr style="height: 25px;">
			<td>${qna.qseq}</td>
			<td><a href="qna_detail?qseq=${qna.qseq}">${qna.subject}</a></td>
			<td style="width:200px;"><fmt:formatDate value="${qna.indate}" pattern="yyyy년 MM월 dd일"/></td>
			<c:choose>
				<c:when test="${qna.rep == 1}">
				<td>미처리</td>
				</c:when>
				<c:otherwise>
				<td style="font-weight : bold;">답변완료</td>
				</c:otherwise>
			</c:choose>
		</tr>	
		</c:forEach>
	</table>
	<br><br>
	<div class="bottons">	
		<input type="button" value="1:1 질문하기" class="submit btn btn-danger login-btn" style="margin-bottom: 10px;" onclick="location.href='qna_form'"/>
	    <input type="button" value="메인으로" class="submit btn btn-danger login-btn" style="margin-bottom: 10px;" onclick="location.href='index'"/>
	</div>
	<br>
</div>

<%@ include file="../footer.jsp" %>