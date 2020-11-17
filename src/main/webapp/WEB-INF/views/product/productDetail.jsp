<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../header.jsp" %>
<%@ include file ="sub_menu.jsp" %>

<form name="frmm">
<br>
<div class="detail-center">
	<div class="row">	
		<div class="col-6">
			<img src="product_images/${product.image}"  class='img-fluid' >
		</div>
		<div class="col-5 row-lg-4">
			<span class="parea">${product.parea}</span>
			<h4>[${product.name}]</h4>
			<c:choose>
				<c:when test="${product.aprice == 0 && product.kprice ==0}">
					<p><span class="price" style="color : #ff4a52;">무료</span></p>
				</c:when>
				<c:otherwise>
					<p><span class="price" style="color : #ff4a52;">성인 ${product.aprice}, 아동  ${product.kprice }</span></p>
				</c:otherwise>
				
			</c:choose>
			<p class="address">${product.address}</p>
			<br><br><br><br>
		
			<p>${product.des}</p><br>
			<input type="hidden" name = pageNum value="${criteria.pageNum}"/>
			<input type="hidden" name = numPerPage value="${criteria.numPerPage}"/>
			<input type="submit" value="담기" class="submit btn btn-danger login-btn" style="margin-right: 5px;">
			<input type="button" value="취소" class="btn btn-secondary" onClick="go_list()">
			
		</div>
	</div>
</div>
</form>



<br><br>
<%@ include file = "../footer.jsp"%>