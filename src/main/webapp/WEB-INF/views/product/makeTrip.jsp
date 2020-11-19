<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

${condition }
=================================================================================<br>
<c:forEach items="${makeTrip }" var="product">
	${product.pseq }, ${product.name}, ${product.aprice}, ${product.kprice }<br>
</c:forEach>

${selectedTotalPrice }<br>


<%@ include file="../footer.jsp"%>