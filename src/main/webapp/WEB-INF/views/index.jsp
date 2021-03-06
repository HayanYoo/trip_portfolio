<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<div id="carouselExampleIndicators" class="carousel slide"
	data-ride="carousel">
	<ol class="carousel-indicators">
		<li data-target="#carouselExampleIndicators" data-slide-to="0"
			class="active"></li>
		<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
		<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
	</ol>
	<div class="carousel-inner">
		<div class="carousel-item active">
			<img class="d-block w-100" src="images/lee.jpg" alt="First slide">
		</div>
		<div class="carousel-item">
			<img class="d-block w-100" src="images/seoultower.jpg" alt="Second slide">
		</div>
		<div class="carousel-item">
			<img class="d-block w-100" src="images/sk.jpg" alt="Third slide">
		</div>
	</div>
	<a class="carousel-control-prev" href="#carouselExampleIndicators"
		role="button" data-slide="prev"> <span
		class="carousel-control-prev-icon" aria-hidden="true"></span> <span
		class="sr-only">Previous</span>
	</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
		role="button" data-slide="next"> <span
		class="carousel-control-next-icon" aria-hidden="true"></span> <span
		class="sr-only">Next</span>
	</a>
</div>

<form name="formm" method="get">
	<div class="box text-center">
	<div class="box1 col-md-3">
		<p>
			고객님,<br>어떤 여행을 꿈꾸시나요?
		</p>
	</div>
	
	<div class="select col-md-6">
		<p>
		<input id = "rcorners1" type="text" name="area" placeholder="어디로 떠나세요?"  value="서울"/><br>
		<input id = "rcorners" type="date" name="startdate" required aria-required="true" data-placeholder="여행시작"  value="2020-11-01"/>
		<input id = "rcorners" type="date" name="enddate" required aria-required="true" data-placeholder="여행종료"  value="2020-11-02"/><br>
		<input id = "rcorners" type="text" name="adult" placeholder="대인"  value="2"/>
		<input id = "rcorners" type="text" name="kid" placeholder="소인"  value="2"/> <br>
		<input id = "rcorners" type="text" name="minbudget" placeholder="최소 예산"  value="50000"/>
		<input id = "rcorners" type="text" name="maxbudget" placeholder="최대 예산"  value="100000"/><br>
		<input id = "rcorners" type="text" name="minoption" placeholder="최소 여행 옵션 수"  value="2" />
		<input id = "rcorners" type="text" name="maxoption" placeholder="최대 여행 옵션 수"  value="5" /><br>
		<input type="button" id = "rcorners2" class="submit"  onclick="addoption()" value="특정옵션추가"/>
		</p>
		<input type="button"  class="search_btn btn btn-primary text-center"onclick="make_trip()" value="검색">
		
	</div>
	</div>
</form>


<h4 class="popular text-center">Popular</h4>

	
<div class="container features">
    <div class="row" style="height: 100px;">
    <c:forEach items="${bestProductList}" var="productVO">
        <div class="col-lg-4 col-md-4 col-sm-12 row-lg-4">
            <a href="product_detail?pseq=${productVO.pseq}">
            <img src="product_images/${productVO.image}" class="img-fluid features-img" >
            <h3 class="feature-title text-center">${productVO.name}</h3>
            <p class="text-center">~${productVO.aprice}원</p>
        	</a> 
        </div>  
    </c:forEach>      
    </div>
</div>
	
<br><br>

<%@ include file="footer.jsp"%>
