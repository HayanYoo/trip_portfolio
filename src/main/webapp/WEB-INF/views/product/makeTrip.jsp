<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<div class="nav-center"><br><br>
<%@ include file="sub_menu_make.jsp" %>


<form name="frmm">
	<% int i = 0; %>
	
	
	<div class="panel-center make-trip-tr">
		<h2 style="font-style: italic;">MAKE TRIP!</h2><br>
		<table width="100%">
			<tr>
				<th width="25%">지역</th>
				<th width="35%">시작일/종료일</th>
				<th>예산</th>
				<th width="25%">옵션 수</th>
			</tr>
			<tr>
				<td>${condition.area}</td>
				<td>${condition.startdate}<br>${condition.enddate}</td>
				<td>${condition.minbudget} ~ ${condition.maxbudget}</td>
				<td>${condition.minoption} ~ ${condition.maxoption}</td>
			</tr>
		</table>
		
		<table width="100%">
			<tr><!-- 옵션갯수 3개마다 tr행 추가 -->
				<c:forEach items="${tempProduct}" var="product">
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
					<a class="btn btn-default" data-target="#modal<%=i%>" data-toggle="modal"><img class="img-fluid" style="width:180px; height:130px;" src="product_images/${product.image}"/></a></td>					
					
					<!-- modal -->
						<div class="modal" id="modal<%=i%>" tabindex="-1">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										${product.name}
										<button class="close" data-dismiss="modal">&times;</button>
									</div>
									<div class = "modal-body" style="text-align:center;">
										<img src="product_images/${product.image}" class="img-fluid" style="width:400px; height:300px;"><br><br>
									
										<c:choose>
											<c:when test="${product.aprice == 0 && product.kprice ==0}">
												<p><span style="color : #ff4a52; font-size:15px;">무료</span></p>
											</c:when>
											<c:otherwise>
												<p><span style="color : #ff4a52; font-size:15px;">성인 ${product.aprice}원 &nbsp;&nbsp;/&nbsp; 아동  ${product.kprice }원</span></p>
											</c:otherwise>
										</c:choose>
									
										<span style="font-weight: bold;">주소 : ${product.address }</span><br><br>
										<span class="modal-des" style="font-weight:400; font-size:12px;">${product.des}</span><br>
																					
									</div>
									<div class="modal-footer">
									<button class="btn btn-danger" data-dismiss="modal">닫기</button>
									</div>
								</div>				
							</div>
						</div>
					<!-- 모달 종료 -->	
					<% i++; %>	
				</c:forEach>
			<tr>
			<tr>
				<td style="border-top: 1px solid #ff979c; border-bottom: 1px solid #ff979c;"></td>
				<td style="border-top: 1px solid #ff979c; border-bottom: 1px solid #ff979c;"></td>
				<c:choose>
					<c:when test="${empty message}">
						<th>총합 : <fmt:formatNumber value="${selectedTotalPrice}" type="number" maxFractionDigits="3"></fmt:formatNumber> 원</th>
					</c:when>
					<c:otherwise>
					<th style="height:60px;">${message}</th>
					</c:otherwise>
				</c:choose>
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
		<input type="button" value="저장" class="submit btn btn-danger login-btn w-30" style="margin-bottom: 10px;" onClick="make_schedule()"/><br>	
	
	<br>
	</div>
</form>
</div>
<%@ include file="../footer.jsp"%>