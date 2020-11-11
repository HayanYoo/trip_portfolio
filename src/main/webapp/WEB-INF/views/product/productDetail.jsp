<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../header.jsp" %>
<%@ include file ="sub_menu.jsp" %>


<br>
<div class="detail-center">
	<div class="row">	
		<div class="col-6">
			<img src="product_images/${product.image}"  class='img-fluid' >
		</div>
		<div class="col-5 row-lg-4">
			<h5 class="parea" >${product.parea}</h5>
			<h3>[${product.name}]</h3>
			<p><span style="color : #ff4a52;">성인 ${product.aprice}, 아동  ${product.kprice }</span></p>
			<p class="address">${product.address}</p>
			<br><br>
		
			<p>${product.des}</p><br>
			 <input type="submit" value="담기" class="submit btn btn-danger login-btn" style="margin-right: 5px;">
			 <input type="button" value="취소" class="btn btn-secondary" onclick="location.href='product_list'">
			
		</div>
	</div>
</div>




<br><br>
<%@ include file = "../footer.jsp"%>