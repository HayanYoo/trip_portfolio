<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
	
<link rel="stylesheet" href="css/main2.css">
<link rel="stylesheet" href="css/style.css">

<title>Trip</title>
</head>
<body>
	<nav class=" navbar navbar-expand-lg navbar-light navbar-default">

		<a class="navbar-brand" href="#"><img src="images/logo.png"></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Dropdown </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="#">Action</a> <a
							class="dropdown-item" href="#">Another action</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">Something else here</a>
					</div></li>
				<li class="nav-item"><a class="nav-link disabled disabled_cor"
					href="#" tabindex="-1" aria-disabled="true" style="color: white;">DisabledAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA</a>
				</li>

				
				 <c:choose>
      			 <c:when test="${empty sessionScope.loginUser}">
				<li class="nav-item"><a class="nav-link" href="login_form">로그인&nbsp;&nbsp;&nbsp; </a></li>
				<li class="nav-item"><a class="nav-link" href="contract">회원가입&nbsp;&nbsp;&nbsp;</a></li>
				<li class="nav-item"><a class="nav-link" href="qna_list">고객센터</a></li>
				</c:when>
				<c:otherwise>
				<li class="nav-item"><a class="nav-link"> ${sessionScope.loginUser.name}(${sessionScope.loginUser.id}) </a></li>
				<li class="nav-item"><a class="nav-link" href="cart">장바구니&nbsp;&nbsp;&nbsp;</a></li>
				<li class="nav-item"><a class="nav-link" href="mypage">마이페이지&nbsp;&nbsp;&nbsp;</a></li>
				 <li class="nav-item"><a class="nav-link" href="logout">로그아웃</a></li>
				</c:otherwise>
				</c:choose>
			</ul>

		</div>
	</nav>


	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
		crossorigin="anonymous"></script>

</body>
</html>