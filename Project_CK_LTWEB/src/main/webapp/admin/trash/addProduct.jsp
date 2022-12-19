<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>AddProduct</title>
</head>

<body>
	<!--<jsp:include page="adminHeader.jsp"></jsp:include>-->
	<div class="preloader">
		<div class="lds-ripple">
			<div class="lds-pos"></div>
			<div class="lds-pos"></div>
		</div>
	</div>
	<!-- ============================================================== -->
	<!-- Main wrapper - style you can find in pages.scss -->
	<!-- ============================================================== -->
	<div id="main-wrapper" data-layout="vertical" data-navbarbg="skin5"
		data-sidebartype="full" data-sidebar-position="absolute"
		data-header-position="absolute" data-boxed-layout="full">
		<!-- ============================================================== -->
		<!-- Topbar header - style you can find in pages.scss -->
		<!-- ============================================================== -->

		<div class="page-wrapper">
			<!-- ============================================================== -->
			<!-- ============================================================== -->
			<!-- Container fluid  -->
			<!-- ============================================================== -->
			<div class="container-fluid">

				<div class="col-lg-8 col-xlg-9 col-md-12">
					<div class="card">
						<div class="card-body">
							<form class="form-horizontal form-material"
								action="manager_product" method="post"
								enctype="multipart/form-data">

								<div class="form-group mb-4">
									<label class="col-md-12 p-0">Tên Sản phẩm</label>
									<div class="col-md-12 border-bottom p-0">
										<input type="text" placeholder="Nhập tên sản phẩm"
											class="form-control p-0 border-0" name="productName">
									</div>
								</div>
								<div class="form-group mb-4">
									<label class="col-md-12 p-0">Hình ảnh</label>
									<img alt="" id = "picture"name ="picture" style="width: 80px; height: 80px;">
									<div class="col-md-12 border-bottom p-0">
										<input type="hidden" name="productImage"> <input
											type="file" class="btn btn-info" name="uploadImage"
											placeholder="Chọn hình ảnh" accept = "image/*" id ="uploadImage">
										<p class="mt-1 text-danger">${imageError}</p>
									</div>
								</div>

								<div class="form-group mb-4">
									<label class="col-md-12 p-0">Mô tả</label>
									<div class="col-md-12 border-bottom p-0">
										<textarea rows="5" class="form-control p-0 border-0"
											name="productDes"></textarea>
									</div>
								</div>

								<div class="form-group mb-4">
									<label for="example-email" class="col-md-12 p-0">Giá</label>
									<div class="col-md-12 border-bottom p-0">
										<input type="number" 
											class="form-control p-0 border-0" 
											name="productPrice">
									</div>
								</div>
								<div class="form-group mb-4">
									<label class="col-sm-12">Loại sản phẩm</label>

									<div class="col-sm-12 border-bottom">
										<select name="productKind"
											class="form-select shadow-none p-0 border-0 form-control-line">
											<c:forEach var="cate" items="${listCate}">
												<option value="${cate.id}">${cate.name}</option>

											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group mb-4">
									<div class="col-sm-12">
										<button class="btn btn-success" name="add" type="submit" value ="Thêm">Thêm</button>
										<a class="btn btn-primary"
											href="/Project_CK_LTWEB/manager_product">Quay về</a>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
				<!-- Column -->
			</div>
		</div>
	</div>

	<!-- <jsp:include page="adminFooter.html"></jsp:include>-->

</body>

  <script>

  uploadImage.onchange = evt => {

            const [file] = uploadImage.files

            if (file) {

                picture.src = URL.createObjectURL(file);

                // $("#preview").removeClass("hidden");

            }

        }

    </script>

</html>

