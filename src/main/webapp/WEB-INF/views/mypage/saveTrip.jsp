<%@page import="com.green.biz.schedule.ScheduleVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.green.biz.schedule.RandomVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<div class="nav-center"><br><br>
<%@ include file ="sub_menu.jsp" %>
<form name="frmm"><br>
	<div class="qna-center save-trip-tr">
		<c:forEach items="${scheduleList}" var="schedule">
		<%! int num = 1 ;%>
			<script>
				var totalprice = 0;
			</script>
			<span style="font-size: 20px;">&lt;<%= num %>번&gt;</span>
			<% num ++; %>
		<table width="100%">
			<tr>
				<th width="25%">지역</th>
				<th width="30%">시작일/종료일</th>
				<th>예산</th>
				<th width="20%">옵션 수</th>
			</tr>
			<tr>
				<td height="50px;"  style="font-size: 17px;">${schedule.area}</td>
				<td style="font-size: 17px;">${schedule.startdate} ~ ${schedule.enddate}</td>
				<td style="font-size: 17px;">${schedule.minbudget} ~ ${schedule.maxbudget}</td>
				<td style="font-size: 17px;">${schedule.minoption} ~ ${schedule.maxoption}</td>
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
					<a class="btn btn-default" data-target="#modal<%=i%>" data-toggle="modal"><img class="img-fluid" style="width:250px; height:200px;" src="product_images/${product.image}"/></a></td>
					
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
									
										<span style="font-weight: bold; font-size:13px;">주소 : ${product.address }</span><br><br>
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
					</c:if>	
				</c:forEach>
			</tr>
			<tr>
				<td style="border-top: 1px solid #ff979c; border-bottom: 1px solid #ff979c;"></td>
				<td style="border-top: 1px solid #ff979c; border-bottom: 1px solid #ff979c;"></td>
				<th>총합 : <script>document.write(totalprice.toLocaleString());</script> 원</th>	<!-- 세자리마다 콤마찍기 -->
			</tr>
		</table><br>
		<input type="button" value="삭제" class="submit btn btn-danger login-btn w-30" style="margin-bottom: 10px;" onClick="location.href='delete_schedule?sseq=${schedule.sseq}'"/>
		<br><br><br><br><br>
		
		</c:forEach>
		<% num = 1; %>		
		<input type="button" value="메인으로" class="submit btn btn-secondary login-btn w-30" style="margin-bottom: 10px;" onClick="location.href='index'"/>
		<br><br><br>
	</div>
</form>
</div>
<%@ include file="../footer.jsp"%>