<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html dir="ltr" lang="en">

<head>
<meta charset="utf-8">

<title>Manager Product</title>
<link rel="icon" type="image/png" sizes="16x16"
	href="/Project_CK_LTWEB/admin/Image/favicon.png">
<!-- Custom CSS -->
<link href="/Project_CK_LTWEB/admin/css/style.min.css" rel="stylesheet">
<link href="/Project_CK_LTWEB/admin/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/Project_CK_LTWEB/admin/css/jquery.dataTables.min.css"
	rel="stylesheet">

<link rel="stylesheet" type="text/css"
	href="/Project_CK_LTWEB/themify-icons/themify-icons.css">
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
		<div class="page-wrapper">

			<!-- Container fluid  -->
			<!-- ============================================================== -->
			<div class="container-fluid">
				<div class="alert alert-success"
					<c:if test="${ message.size() == 0}">style="display: none"</c:if>>
					<b>${message["success"]}</b>
				</div>
				<!-- ============================================================== -->
				<!-- Start Page Content -->
				<!-- ============================================================== -->
				<div class="row">
					<div class="col-sm-12">
						<div class="white-box">
							<c:if test="${access != null }">
								<div class="alert alert-success">
									<fmt:message key="message.subccess" bundle="${lang }"></fmt:message>
								</div>
							</c:if>

							<h3 class="box-title text-uppercase text-center">
								<fmt:message key="menu.MangerProduct" bundle="${lang }"></fmt:message>
							</h3>
							<a href="/Project_CK_LTWEB/manager_product?action=add"
								class="btn btn-success text-white mt-2 mb-2"
								style="text-align: end; margin-right: 20px;"><fmt:message
									key="product.add" bundle="${lang }"></fmt:message></a>
							<div class="table-responsive">
								<table class="table text-nowrap" id="myTable">
									<thead>
										<tr>
											<th class="border-top-0"><fmt:message key="product.id"
													bundle="${lang }"></fmt:message></th>
											<th class="border-top-0"><fmt:message key="product.name"
													bundle="${lang }"></fmt:message></th>
											<th class="border-top-0"><fmt:message key="product.img"
													bundle="${lang }"></fmt:message></th>
											<th class="border-top-0"><fmt:message
													key="product.price" bundle="${lang }"></fmt:message></th>
											<th class="border-top-0"><fmt:message key="product.kind"
													bundle="${lang }"></fmt:message></th>
											<th class="border-top-0"><fmt:message
													key="product.function" bundle="${lang }"></fmt:message></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="product" items="${listProduct }">
											<tr>
												<td>${product.id }</td>
												<td>${product.name }</td>
												<td><img src="${product.image}"
													style="width: 80px; height: 80px;"></td>
												<td>${product.formatPrice() }VND</td>
												<td><c:if test="${product.catId == 1 }">Đồ ăn vặt</c:if>
													<c:if test="${product.catId == 2 }">Đồ ăn</c:if> <c:if
														test="${product.catId == 3 }">Nước Uống</c:if></td>
												<td><a
													href="/Project_CK_LTWEB/manager_product?action=edit&proId=${product.id }"
													class="btn btn-primary"><i class="ti-pencil-alt"></i></a> <a
													href="/Project_CK_LTWEB/manager_product?action=trash&proId=${product.id }"
													class="btn btn-danger text-white"><i class="ti-trash"></i></a>
												</td>

											</tr>

										</c:forEach>

									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- ============================================================== -->
		<!-- End Page wrapper  -->
		<!-- ============================================================== -->
	</div>
	<jsp:include page="adminFooter.html"></jsp:include>
	<!-- ============================================================== -->
	<!-- End Wrapper -->
	<!-- ============================================================== -->
	<!-- ============================================================== -->
	<!-- All Jquery -->
	<!-- ============================================================== -->
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
	<script src="/Project_CK_LTWEB/admin/js/jquery.dataTables.min.js"></script>
	<script>
		$(document).ready(function() {
			$('#myTable').DataTable();
		});
	</script>



</body>

</html>