<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_menu_make.jsp" %>


<form name="frmm">
	<% int i = 0; %>
	<br><br>
	
	<div class="panel-center make-trip-tr">
		<h2 style="font-style: italic;">MAKE TRIP!</h2><br>
		<table width="100%">
			<tr>
				<th>지역</th>
				<th>시작/종료</th>
				<th>예산</th>
				<th width="15%">옵션 수<span style="color:#ff979c;">(선택)</span></th>
			</tr>
			<tr>
				<td>${condition.area}</td>
				<td>${condition.startdate}<br>${condition.enddate}</td>
				<td>${condition.minbudget} ~ ${condition.maxbudget}</td>
				<td>${condition.minoption} ~ ${condition.maxoption}<span style="color:#ff979c;">${selectedListLength}</span></td>
			</tr>
		</table>
		<table width="100%">
			<tr><!-- 옵션갯수 3개마다 tr행 추가 -->
				<c:forEach items="${makeTrip}" var="product">
					<% 
						if (i%3 == 0) {
							out.print("<tr>");				
							out.print("<th>관광지</th>");
							out.print("<th>관광지</th>");
							out.print("<th>관광지</th>");
							out.print("</tr>");
						}
					%>	
					<td width="33%"><span>${product.name}</span><br>
					<img class="img-fluid" style="width:180px; height:130px;" src="product_images/${product.image}"/></td>				
					<% i++; %>
				</c:forEach>
			<tr>
			<tr>
				<td style="border-top: 1px solid #ff979c; border-bottom: 1px solid #ff979c;"></td>
				<td style="border-top: 1px solid #ff979c; border-bottom: 1px solid #ff979c;"></td>
				<th>총합 : <fmt:formatNumber value="${selectedTotalPrice}" type="number" maxFractionDigits="3"></fmt:formatNumber> 원</th>
			</tr>
		</table><br>
		
		<input type="hidden" name="area" value="${condition.area}"/>
		<input type="hidden" name="startdate" value="${condition.startdate}"/>
		<input type="hidden" name="enddate" value="${condition.enddate}"/>
		<input type="hidden" name="adult" value="${condition.adult}"/>
		<input type="hidden" name="kid" value="${condition.kid}"/>
		<input type="hidden" name="minbudget" value="${condition.minbudget}"/>
		<input type="hidden" name="maxbudget" value="${condition.maxbudget}"/>
		<input type="hidden" name="minoption" value="${condition.minoption}"/>
		<input type="hidden" name="maxoption" value="${condition.maxoption}"/>
				
		<input type="button" value="재검색" class="submit btn btn-secondary login-btn w-30" style="margin-bottom: 10px;" onClick="make_trip()"/>
		<input type="button" value="저장" class="submit btn btn-danger login-btn w-30" style="margin-bottom: 10px;" onClick="#"/><br>	
	
	<br>
	</div>
</form>
<%@ include file="../footer.jsp"%>