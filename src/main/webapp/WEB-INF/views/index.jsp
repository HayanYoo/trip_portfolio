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
			<img class="d-block w-100" src="images/pg11.jpg" alt="First slide">
		</div>
		<div class="carousel-item">
			<img class="d-block w-100" src="images/horse.jpg" alt="Second slide">
		</div>
		<div class="carousel-item">
			<img class="d-block w-100" src="images/playaqa.jpg" alt="Third slide">
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
<div class="box text-center">
<div class="box1 col-md-3">
	<p>
		고객님,<br>어떤 여행을 꿈꾸시나요?
	</p>
</div>
<div class="select col-md-6">
	<p>
	<input id = "rcorners1" type="text" placeholder="어디로 떠나세요?"><br>
	<input id = "rcorners" type="date" required aria-required="true" data-placeholder="여행시작">
	<input id = "rcorners" type="date" required aria-required="true" data-placeholder="여행종료"><br>
	<input id = "rcorners" type="text" placeholder="대인">
	<input id = "rcorners" type="text" placeholder="소인"><br>
	<input id = "rcorners" type="text" placeholder="최소 예산">
	<input id = "rcorners" type="text" placeholder="최대 예산"><br>
	<input id = "rcorners" type="text" placeholder="최소 여행 옵션 수">
	<input id = "rcorners" type="text" placeholder="최대 여행 옵션 수"><br><br>
		<a id = "rcorners2" href="#" role="button">특정옵션추가</a>
	</p>
	<button class="search_btn btn btn-primary text-center" type="submit">검색</button>
	
</div>
</div>



<h3 class="popular text-center">인기 장소</h3>

<div class="row">
	<div class="col-md-4">
		<h4>코딩 부스터의 특징</h4>
		<p>코딩부스터는 다른사이트와 차원이 다른 깔끔한 구성을 보여줍니다. 모든 페이지가 사용자가 접근하고 읽기 쉽도록
			구성되어 있습니다.</p>
		<p>
			<a class="btn btn-default" href="#">자세히 알아보기</a>
		</p>
	</div>
	<div class="col-md-4">
		<h4>코딩 부스터의 특징</h4>
		<p>코딩부스터는 다른사이트와 차원이 다른 깔끔한 구성을 보여줍니다. 모든 페이지가 사용자가 접근하고 읽기 쉽도록
			구성되어 있습니다.</p>
		<p>
			<a class="btn btn-default" href="#">자세히 알아보기</a>
		</p>
	</div>
	<div class="col-md-4">
		<h4>코딩 부스터의 특징</h4>
		<p>코딩부스터는 다른사이트와 차원이 다른 깔끔한 구성을 보여줍니다. 모든 페이지가 사용자가 접근하고 읽기 쉽도록
			구성되어 있습니다.</p>
		<p>
			<a class="btn btn-default" href="#">자세히 알아보기</a>
		</p>
	</div>
</div>
<br><br>

<%@ include file="footer.jsp"%>
