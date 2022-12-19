<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Edit</title>
<link rel="canonical"
	href="https://www.wrappixel.com/templates/ample-admin-lite/" />
<!-- Favicon icon -->
<!-- Favicon icon -->
<link rel="icon" type="image/png" sizes="16x16"
	href="/Project_CK_LTWEB/admin/plugins/images/favicon.png">
<!-- Custom CSS -->
<link href="/Project_CK_LTWEB/admin/css/style.min.css" rel="stylesheet">
</head>

<body>
	<jsp:include page="adminHeader.jsp"></jsp:include>
	
	<fmt:setLocale value="${sessionScope.langName}" />
	<fmt:setBundle basename="i18n.lang" var="lang" />
	
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

				<div class="col-md-12">
					<div class="card">
						<div class="card-body">
							<form class="form-horizontal form-material"
								action="manager_product" method="post"
								enctype="multipart/form-data">
								<div class="form-group mb-4">
									<label class="col-md-12 p-0"><fmt:message key="product.id"
										bundle="${lang }"></fmt:message></label>
									<div class="col-md-12 border-bottom p-0">
										<input type="text" placeholder="Johnathan Doe"
											class="form-control p-0 border-0" readonly
											value="${product.id }" name="productId">
									</div>
								</div>

								<div class="form-group mb-4">
									<label class="col-md-12 p-0"><fmt:message key="product.name"
										bundle="${lang }"></fmt:message></label>
									<div class="col-md-12 border-bottom p-0">
										<input type="text" placeholder="Johnathan Doe"
											class="form-control p-0 border-0" value="${product.name }"
											name="productName" required="required">
									</div>
								</div>
								<div class="form-group mb-4">
									<label class="col-md-12 p-0"><fmt:message key="product.img"
										bundle="${lang }"></fmt:message></label>
									<div class="col-md-12 border-bottom p-0">
										<img src="${product.image}" style="width: 80px; height: 80px;" id = "picture"name ="picture">
										<input type="hidden" value="${product.image}"
											name="productImage"> <input type="file"
											class="btn btn-info" name="uploadImage"
											placeholder="Chọn hình ảnh" id = "uploadImage" accept = "image/*">
										<p class="mt-1 text-danger">${imageError}</p>
									</div>
								</div>

								<div class="form-group mb-4">
									<label class="col-md-12 p-0"><fmt:message key="product.detail"
										bundle="${lang }"></fmt:message></label>
									<div class="col-md-12 border-bottom p-0">
										<textarea rows="5" class="form-control p-0 border-0"
											name="productDes" required="required">${product.descreption}</textarea>
									</div>
								</div>

								<div class="form-group mb-4">
									<label for="example-email" class="col-md-12 p-0"><fmt:message key="product.price"
										bundle="${lang }"></fmt:message></label>
									<div class="col-md-12 border-bottom p-0">
										<input type="number" 
											class="form-control p-0 border-0" 
											value="${product.price}" name="productPrice" required="required">
									</div>
								</div>
								<div class="form-group mb-4">
									<label class="col-sm-12"><fmt:message key="product.kind"
										bundle="${lang }"></fmt:message></label>

									<div class="col-sm-12 border-bottom">
										<select name="productKind"
											class="form-select shadow-none p-0 border-0 form-control-line">
											<c:forEach var="cate" items="${listCate}">
												<option value="${cate.id}"
													<c:if test ="${product.catId == cate.id }">selected</c:if>>${cate.name}</option>

											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group mb-4">
									<div class="col-sm-12">
										<button class="btn btn-success" name="update" type="submit"><fmt:message key="select.update"
										bundle="${lang }"></fmt:message></button>
										<a class="btn btn-primary"
											href="/Project_CK_LTWEB/manager_product"><fmt:message key="select.cancel"
										bundle="${lang }"></fmt:message></a>
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

	<jsp:include page="adminFooter.html"></jsp:include>

	<script src="/Project_CK_LTWEB/admin/js/jquery.min.js"></script>
	<!-- Bootstrap tether Core JavaScript -->
	<script src="/Project_CK_LTWEB/admin/js/bootstrap.bundle.min.js"></script>
	<script src="/Project_CK_LTWEB/admin/js/app-style-switcher.js"></script>
	<!--Wave Effects -->
	<script src="/Project_CK_LTWEB/admin/js/waves.js"></script>
	<!--Menu sidebar -->
	<script src="/Project_CK_LTWEB/admin/js/sidebarmenu.js"></script>
	<!--Custom JavaScript -->
	<script src="/Project_CK_LTWEB/admin/js/custom.js"></script>

	<script>

  uploadImage.onchange = evt => {

            const [file] = uploadImage.files

            if (file) {

                picture.src = URL.createObjectURL(file);

                // $("#preview").removeClass("hidden");

            }

        }

    </script>
</body>

</html>

