<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../header.jsp" %>


<form name="frmm">
<br><br><br>
<div class="detail-center">
	<div class="row">	
		<div class="col-6">
			<input type="hidden" name="pseq" value="${product.pseq}"/>	
			
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
			<input type="hidden" name ="pageNum" value="${criteria.pageNum}"/>
			<input type="hidden" name ="numPerPage" value="${criteria.numPerPage}"/>
	
			<input type="hidden" name="area" value="${condition.area}"/>
			<input type="hidden" name="startdate" value="${condition.startdate}"/>
			<input type="hidden" name="enddate" value="${condition.enddate}"/>
			<input type="hidden" name="adult" value="${condition.adult}"/>
			<input type="hidden" name="kid" value="${condition.kid}"/>
			<input type="hidden" name="minbudget" value="${condition.minbudget}"/>
			<input type="hidden" name="maxbudget" value="${condition.maxbudget}"/>
			<input type="hidden" name="minoption" value="${condition.minoption}"/>
			<input type="hidden" name="maxoption" value="${condition.maxoption}"/>
			
			<input type="submit" value="담기" class="submit btn btn-danger login-btn" style="margin-right: 5px;" onClick="insert_product()">
			<input type="button" value="취소" class="btn btn-secondary" onClick="go_list()">
			
		</div>
	</div>
</div>


</form>



<br><br>
<%@ include file = "../footer.jsp"%>