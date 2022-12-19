<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/header.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="themify-icons/themify-icons.css">


<script type="text/javascript" src="js/popper.min.js"></script>
<script type="text/javascript" src="js/jquery.slim.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

<title></title>
</head>
<body>
	<div class="container-fluid">

		<!-- Phan header Address -->
		<div class="container header">
			<div class="row justify-content-between reponse-logo" id="header-web">
				<span class="ti-location-pin media-reponsive">268/19 xã Hoà
					Nghĩa, Huyện Chợ Lách,Tỉnh Bến Tre</span>

				<div class="media-reponsive mr-5 phone">
					<span class="ti-mobile"></span> <label>076 922 0162</label>
				</div>

				<div class=" media-reponsive">
					<a class="ti-facebook  icon" type="button"
						href="https://www.facebook.com/profile.php?id=100008453507894"
						target="_blank"></a> <a class="ti-instagram  icon" type="button"
						href=""></a> <a class="ti-twitter-alt  icon" type="button" href=""></a>
				</div>
			</div>

		</div>
		<!-- End phan header Address -->

		<!-- Logo va Search -->
		<div class="row" id="header-logo">
			<div class="container">
				<nav
					class="navbar navbar-light  shop-header justify-content-around  header-repinsive">
					<a href="HomeController"><img id="logo" class="media-reponsive"
						src="Image/logo.png" class="col-sm-3"></a>
					<h1 class="name-shop">Shop Đồ Ăn Vặt Handmade</h1>
					<form class="form-inline" action="search" method="post">
						<input class="form-control media-reponsive search" type="search"
							placeholder="Tìm kiếm..." aria-label="Search" name="search">
						<button class="ti-search btn btn-success my-2 my-sm-0"
							type="submit"></button>

						<c:if test="${user ==null}">
							<!-- Dang nhap/ Dang ky -->
							<div class="login reponse-login">
								<div class="ti-user  icon_white"></div>
								<a class="login-item item" href="login.jsp"
									style="margin-right: 20px;">Đăng nhập</a>
								<div class="ti-pencil-alt  icon_white"></div>
								<a class="login-item" href="register.jsp">Đăng ký</a>
							</div>
						</c:if>
						<c:if test="${user !=null}">
							<!-- Dang nhap/ Dang ky -->
							<div class="login reponse-out">
								<span class="text-white">Chào ${user.userName }</span>
								<div class="ti-shift-left  icon_white"></div>
								<c:set var="logOut" scope="session" value="logOut" />
								<a class="login-item item" href="login?logOut=${logOut}"
									style="margin-right: 60px;">Đăng Xuất</a>
							</div>
						</c:if>

					</form>
				</nav>

			</div>

			<div class=" cart reponse-cart">
				<c:if test="${user !=null}">
					<form method="POST" action="CartController">
							<button
								class="ti-shopping-cart btn btn-success my-2 my-sm-0 btn-cart"
								name="action" value="usercart"></button> 
								<c:if test="${cart != null}">
								<span class="badge bg-danger">${cart.getLineItemCount()}</span></c:if>
								<c:if test="${cart == null}">
								<span class="badge bg-danger">0</span></c:if>
					</form>
				</c:if>
				<c:if test="${user ==null}">
					<a href="login.jsp">
						<button
							class="ti-shopping-cart btn btn-success my-2 my-sm-0 btn-cart"></button>
						<span class="badge bg-danger">0</span>
					</a>
				</c:if>
			</div>
		</div>
		<!-- Ket thuc phan logo va Search -->



		<!-- Navbar -->
		<nav
			class="navbar navbar-expand-md bg-primary  row navbar-dark navbar-header">
			<!-- Brand -->


			<!-- Toggler/collapsibe Button -->
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#collapsibleNavbar">
				<a class="navbar-brand" href="#">Menu</a> <span
					class="navbar-toggler-icon"></span>
			</button>

			<!-- Navbar links -->
			<div
				class="collapse navbar-collapse justify-content-center margin-right-60"
				id="collapsibleNavbar">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="HomeController">Trang
							chủ</a></li>
					<li class="nav-item"><a class="nav-link" href="FoodController">Đồ
							ăn</a></li>
					<li class="nav-item"><a class="nav-link"
						href="DrinkController">Đồ uống</a></li>
					<li class="nav-item"><a class="nav-link" href="feedback.jsp">Phản
							hồi</a></li>

				</ul>
			</div>
		</nav>
		<!-- Ket thuc navbar -->
	</div>

</body>
</html>