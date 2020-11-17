<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<ul class="pagination">
	
		<c:if test="${pageMaker.prev}">
			<li class="paginate_button previous">
				<a href="product_list${pageMaker.makeQuery(pageMaker.startPage-1)}">[이전]</a>
			</li>
		</c:if>
		
		<!-- [1][2][3]... 표시 부분 -->
		<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="index">
			<c:choose>
				<c:when test="${pageMaker.cri.pageNum == index}">
					<a href="product_list${pageMaker.makeQuery(index)}" >[${index}]</a>
				</c:when>
				<c:otherwise>
					<a href="product_list${pageMaker.makeQuery(index)}" style="color:black;">[${index}]</a>
				</c:otherwise>
			</c:choose>
			
		</c:forEach>
	
		<c:if test="${pageMaker.next}">
			<li class="paginate_button next">
				<a href="product_list${pageMaker.makeQuery(pageMaker.endPage+1)}">[다음]</a>
			</li>
		</c:if>
		
	</ul>

</div>