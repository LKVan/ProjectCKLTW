<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/main.css">
<title>Trang Chủ</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<!-- Phan body -->
	<div class="container body">
		<div class="row container-fluid" style="margin-left: 9px;">
			<div class="col-sm-3 slider">
				<b>SẢN PHẨM BÁN CHẠY</b>
				<c:forEach var="product" items="${listProductNew}">
					<div class="row item-icon is-table-row">
						<div class="col-3">
							<a href="product?proId=${product.id }"><img
								src="${product.image}" class="img-icon"></a>
						</div>
						<div class="col-9">
							<div class="row">
								<a href="product?proId=${product.id }"><b
									class="item-banner">${product.name}</b></a><span
									class="badge badge-item badge-danger"> HOT</span>
							</div>
							<div class="row">Giá: ${product.formatPrice()} VNĐ</div>
						</div>
					</div>
				</c:forEach>
			</div>

			<div class="col-sm-6 caroisel-row">
				<div id="demo" class="carousel slide" data-ride="carousel">


					<ul class="carousel-indicators">
						<li data-target="#demo" data-slide-to="0" class="active"></li>
						<li data-target="#demo" data-slide-to="1"></li>
						<li data-target="#demo" data-slide-to="2"></li>
					</ul>


					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="Image/carousel.png" alt="Los Angeles">
						</div>
						<div class="carousel-item">
							<img src="Image/carousel2.png" alt="Chicago">
						</div>
						<div class="carousel-item">
							<img src="Image/carousel3.png" alt="New York">
						</div>
					</div>


					<a class="carousel-control-prev" href="#demo" data-slide="prev">
						<span class="carousel-control-prev-icon"></span>
					</a> <a class="carousel-control-next" href="#demo" data-slide="next">
						<span class="carousel-control-next-icon"></span>
					</a>

				</div>
			</div>

			<div class="col-sm-3 slider">
				<b>SẢN PHẨM MỚI</b>
				<c:forEach var="product" items="${listProductNew}">
					<div class="row item-icon is-table-row">
						<div class="col-3">
							<img src="${product.image}" class="img-icon">
						</div>
						<div class="col-9">
							<div class="row">
								<a href="product?proId=${product.id }"><b
									class="item-banner"> ${product.name}</b></a><span
									class="badge badge-item badge-warning">NEW</span>
							</div>
							<div class="row">Giá: ${product.formatPrice()} VNĐ</div>
						</div>
					</div>
				</c:forEach>
			</div>


		</div>

		<div class="body">
			<h3 style="text-align: center;">
				<b><%=request.getAttribute("maintitle")%></b>
			</h3>
			<div class="row mr-top-20 justify-content-center">
				<c:forEach var="product" items="${listProduct}">
					<div class="row">
						<form method="POST" action="CartController">
							<div class="col-md-4 col-sm-2 product">
								<div class="card  is-table-row" style="width: 14.5rem;">
									<a href="product?proId=${product.id }"><input type="hidden"
										name="proId" value="${product.id}"><input
										type="hidden" name="inputQuantity" value="1"> <img
										src="${product.getImage() }" class="card-img-top" alt="..."></a>
									<div class="card-body">
										<a href="product?proId=${product.id }"><h5
												class=" card-title show_txt ">
												<b>${product.getName()}</b>
											</h5></a>
										<p class="card-text show_txt">${product.getDescreption()}</p>
										<b>Giá: ${product.formatPrice()} VNĐ.</b>
										<button style="margin-top: 4px;" type="submit"
											class="btn btn-outline-success">
											<i class="ti-shopping-cart icon-black"></i> Thêm vào giỏ
										</button>
									</div>
								</div>
							</div>
						</form>
					</div>
				</c:forEach>
			</div>

		</div>

	</div>
	<!-- End Body -->



	<script type="text/javascript" src="js/jquery.matchHeight-min.js"></script>
	<script>
		$(function() {
			$('.box').matchHeight(false);
		});
	</script>
	<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>