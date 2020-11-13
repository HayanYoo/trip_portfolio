<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<!-- 
<div class="container-fluid">
	<div class="jumbotron jumbotron-fluid">
		<h1 class="text-center">랜덤여행을 소개합니다</h1>
		<p class="mt-2 text-center">랜덤여행은 일정 짜기 귀찮은 사람들을 위해 여행일정을 랜덤으로 짜주는
			사이트입니다.</p>
		<p class="mt-5 text-center">
			<a class="btn btn-primary btn-lg" href="#" role="button">일정 짜러 가기</a>
		</p>
	</div>
</div>
 -->



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
		<input id = "rcorners1" type="text" name="area" placeholder="어디로 떠나세요?" /><br>
		<input id = "rcorners" type="date" name="startdate" required aria-required="true" data-placeholder="여행시작" />
		<input id = "rcorners" type="date" name="enddate" required aria-required="true" data-placeholder="여행종료" /><br>
		<input id = "rcorners" type="text" name="adult" placeholder="대인" />
		<input id = "rcorners" type="text" name="kid" placeholder="소인"/> <br>
		<input id = "rcorners" type="text" name="minbudget" placeholder="최소 예산" />
		<input id = "rcorners" type="text" name="maxbudget" placeholder="최대 예산" /><br>
		<input id = "rcorners" type="text" name="minoption" placeholder="최소 여행 옵션 수" />
		<input id = "rcorners" type="text" name="maxoption" placeholder="최대 여행 옵션 수" /><br>
		<input type="button" id = "rcorners2" class="submit"  onclick="addoption()" value="특정옵션추가"/>
		</p>
		<button class="search_btn btn btn-primary text-center" type="submit">검색</button>
		
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
