<%@page import="com.green.biz.schedule.ScheduleVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.green.biz.schedule.RandomVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<form name="frmm">

	
	<br><br><br>
	
	<div class="qna-center save-trip-tr">
		<h2 style="font-style: italic;">나의 여행</h2><br><br>
		<c:forEach items="${scheduleList}" var="schedule">
		<%! int num = 1 ;%>
			<script>
				var totalprice = 0;
			</script>
			<span>&lt;<%= num %>번&gt;</span>
			<% num ++; %>
		<table width="100%">
			<tr>
				<th>지역</th>
				<th>시작/종료</th>
				<th>예산</th>
				<th width="15%">옵션 수</th>
			</tr>
			<tr>
				<td height="50px;">${schedule.area}</td>
				<td><fmt:formatDate value="${schedule.startdate}" pattern="YYYY-MM-dd"/> ~ <fmt:formatDate value="${schedule.enddate}" pattern="YYYY-MM-dd"/></td>
				<td>${schedule.minbudget} ~ ${schedule.maxbudget}</td>
				<td>${schedule.minoption} ~ ${schedule.maxoption}</td>
			</tr>
		</table>
		<table width="100%">
			<tr><!-- 옵션갯수 3개마다 tr행 추가 -->
			<% int i = 0; %>
				<c:forEach items="${randomList}" var="product"> 
					<c:if test="${schedule.sseq == product.sseq}">
					<% 
						if (i%3 == 0) {
							out.print("<tr>");				
							out.print("<th>관광지</th>");
							out.print("<th>관광지</th>");
							out.print("<th>관광지</th>");
							out.print("</tr>");
						}
					%>	
					<script>
						 totalprice += (${product.aprice} * ${schedule.adult} + ${product.kprice} * ${schedule.kid})
					</script>
					<td width="33%"><span>${product.name}</span><br>
					<img class="img-fluid" style="width:250px; height:200px;" src="product_images/${product.image}"/></td>		
							
					<% i++; %>
					</c:if>	
				</c:forEach>
			<tr>
			<tr>
				<td style="border-top: 1px solid #ff979c; border-bottom: 1px solid #ff979c;"></td>
				<td style="border-top: 1px solid #ff979c; border-bottom: 1px solid #ff979c;"></td>
				<th>총합 : <script>document.write(totalprice.toLocaleString());</script> 원</th>	<!-- 세자리마다 콤마찍기 -->
			</tr>
		</table><br><br><br>
		</c:forEach>
		<% num = 1; %>		
		<input type="button" value="메인으로" class="submit btn btn-secondary login-btn w-30" style="margin-bottom: 10px;" onClick="location.href='index'"/>
		<br><br><br>
	</div>
</form>

<%@ include file="../footer.jsp"%>