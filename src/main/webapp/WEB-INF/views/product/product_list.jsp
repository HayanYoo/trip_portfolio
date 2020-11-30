<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="now" class="java.util.Date" />
<%@ include file ="../header.jsp" %>
<hr>
<div class="nav-center">
<br>
<%@ include file ="sub_menu.jsp" %>


<div class="product-center">
<h3>Activity</h3><br><br>
<form name="frm" method="post">
<table>
  <tr>
  <td width="600" style="text-align : right; border-right: 1px solid gray;">
     <input type="text" name="key" placeholder="검색어를 입력해주세요" size="40" value="${key}">
     <input class="btn" type="button" name="btn_search" value="검색" onClick="go_search()"></td>
  <td><input class="btn" type="button" name="btn_total" value="전체보기 " onClick="go_total()">
  </td>
  </tr>
</table>
<br>
</form>
</div>

<div class="panel-center" >
	<div class="panel panel-primary">
		<div class="panel-heading">
			<br><br>
		</div>
		<c:choose>
		    <c:when test="${productListSize<=0}">  
		    <p>
		        등록된 상품이 없습니다.
		    </p>    
		    </c:when>
			<c:otherwise>	
	 		<c:forEach items="${productList}" var="product">
		 		<a href="product_detail${pageMaker.makeQuery(pageMaker.cri.pageNum)}&pseq=${product.pseq}">
					<div class="panel-body">
						<div class="media" style="box-shadow: 0px 0px 7px 1px #cacccb; ">
							<div class="media-left" style="width: 200px; height: 180px;">
								<img class="media-object img-fluid" src="product_images/${product.image}" alt="${product.name}" >
							</div>
							<div class="media-body" style="text-align: left; padding-left: 40px;" >
								<h5 class="media-heading"><br><br><br>[${product.name}]&nbsp;	
								  	
								</h5>				
							</div>
							<div class="media-right" style="width: 233px;">
							 	<c:choose>
									<c:when test="${product.aprice == 0}">
										<p>무료</p>
									</c:when>
									<c:otherwise>
										<p>${product.aprice}원</p>
									</c:otherwise>
								</c:choose>
							</div>
						</div>					
					</div>
				</a>
				<br>
			</c:forEach>
			</c:otherwise>	
		</c:choose>
		
	</div>
	<%@ include file="page_area.jsp" %> 
</div>
<br>
</div>
<%@ include file ="../footer.jsp" %>