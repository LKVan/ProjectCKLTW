<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>Shop Item - Start Bootstrap Template</title>
<link rel="stylesheet" type="text/css"
	href="themify-icons/themify-icons.css">
<link href="css/styles.css" rel="stylesheet" />
<link href="css/detail.css" rel="stylesheet" />
<link href="css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>

	<div class="container d-flex">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="HomeController">Trang
					chủ</a></li>
			<li class="breadcrumb-item active" aria-current="page">Chi tiết
				sản phẩm ${product.name}</li>
		</ol>

		<div class=" cart">
			<button
				class="ti-shopping-cart btn btn-success my-2 my-sm-0 btn-cart"></button>
			<span class="badge bg-danger">0</span>
		</div>
	</div>


	<section class="">
		<form method="POST" action="CartController">
			<div class="container px-4 px-lg-5 my-5">
				<div class="row gx-4 gx-lg-5 align-items-center">
					<div class="col-md-6">
						<img class="card-img-top mb-5 mb-md-0" src="${product.image}"
							alt="..." />
					</div>


					<div class="col-md-6">
						<div class="small mb-1" >SKU: ${product.id}</div>
						<input type=  "hidden" name = "proId" value ="${product.id}">
						<h1 class="display-5 fw-bolder">${product.name}</h1>
						<div class="fs-5 mb-5">
							<span>Giá: ${product.formatPrice()} VNĐ.</span>
						</div>
						<p class="lead">${product.getDescreption()}</p>
						<div class="d-flex">
							<input class="form-control text-center me-3" name="inputQuantity"
								type="number" value="1" style="max-width: 3rem" />
							<button class="btn btn-outline-dark flex-shrink-0" type="submit">
								<!-- <a href="CartController?proId=${product.id}"> -->
								<i class="ti-shopping-cart me-1"></i> Add to Cart
								<!--  </a>-->
							</button>
						</div>
					</div>

				</div>
			</div>
		</form>
	</section>
	<!-- Related items section-->

	<!-- Footer-->
	<footer class="py-3 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Sản phẩm đi đôi với chất
				lượng</p>
		</div>
	</footer>
	<!-- Bootstrap core JS-->
	<script src="js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>
</html>