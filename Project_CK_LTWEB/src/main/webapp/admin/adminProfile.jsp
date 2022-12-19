<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html dir="ltr" lang="en">

<head>
<meta charset="utf-8">

<title>Profile</title>

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

	<%
	java.time.LocalDate local = java.time.LocalDate.now();
	int day = local.getDayOfMonth();
	int month = local.getMonthValue();
	int year = local.getYear();
	%>
	<jsp:include page="adminHeader.jsp"></jsp:include>
	<!-- ============================================================== -->
	<fmt:setLocale value="${sessionScope.langName}" />
	<fmt:setBundle basename="i18n.lang" var="lang" />
	<!-- ============================================================== -->
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
				<!-- ============================================================== -->
				<!-- Start Page Content -->
				<!-- ============================================================== -->
				<!-- Row -->
				<div class="row">
					<!-- Column -->
					<div class="col-lg-4 col-xlg-3 col-md-12">
						<div class="white-box">
							<div class="user-bg">
								<img width="100%" alt="user" src="plugins/images/large/img1.jpg">
								<div class="overlay-box">
									<div class="user-content">
										<a href="javascript:void(0)"><img
											src="plugins/images/users/genu.jpg"
											class="thumb-lg img-circle" alt="img"></a>
										<h4 class="text-white mt-2">${user.fullName}</h4>
									</div>
								</div>
							</div>
							<div class="user-btm-box mt-5 d-md-flex text-center">
								<div class="col-md-4 col-sm-4">
									<h1><%=day%>
										/
									</h1>
								</div>
								<div class="col-md-4 col-sm-4 text-center"
									style="margin-left: -15px;">
									<h1><%=month%>
										/
									</h1>
								</div>
								<div class="col-md-4 col-sm-4 text-center"
									style="margin-left: -15px;">
									<h1><%=year%></h1>
								</div>
							</div>
						</div>
					</div>
					<!-- Column -->
					<!-- Column -->
					<div class="col-lg-8 col-xlg-9 col-md-12">
						<div class="card">
							<div class="card-body">
								<form class="form-horizontal form-material">
									<div class="form-group mb-4">
										<label class="col-md-12 p-0"><b><fmt:message
													key="user.fullName" bundle="${lang }"></fmt:message> </b></label>
										<div class="col-md-12 border-bottom p-0">
											<input type="text" placeholder="Johnathan Doe"
												class="form-control p-0 border-0" value="${user.fullName }"
												name="fullName" readonly>
										</div>
									</div>
									<div class="form-group mb-4">
										<label for="example-email" class="col-md-12 p-0"><b><fmt:message
													key="user.userName" bundle="${lang }"></fmt:message> </b></label>
										<div class="col-md-12 border-bottom p-0">
											<input class="form-control p-0 border-0" name="userName"
												value="${user.userName}" readonly>
										</div>
									</div>
									<div class="form-group mb-4">
										<label class="col-md-12 p-0"><b><fmt:message
													key="user.password" bundle="${lang }"></fmt:message></b></label>
										<div class="col-md-12 border-bottom p-0">
											<input type="password" value="${user.password}"
												class="form-control p-0 border-0" readonly>
										</div>
									</div>
									<div class="form-group mb-4">
										<label class="col-md-12 p-0"><b><fmt:message
													key="user.phone" bundle="${lang }"></fmt:message></b></label>
										<div class="col-md-12 border-bottom p-0">
											<input type="text" placeholder="123 456 7890"
												class="form-control p-0 border-0" name="phone"
												value="${ user.numberPhone}" readonly>
										</div>
									</div>
									<div class="form-group mb-4">
										<label class="col-md-12 p-0"><b>Email</b></label>
										<div class="col-md-12 border-bottom p-0">
											<input type="email" value="${user.email}"
												class="form-control p-0 border-0" readonly>
										</div>
									</div>
									<div class="form-group mb-4">
										<label class="col-md-12 p-0"><b><fmt:message
													key="user.address" bundle="${lang }"></fmt:message></b></label>
										<div class="col-md-12 border-bottom p-0">
											<textarea rows="5" class="form-control p-0 border-0" readonly>${user.address}</textarea>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
					<!-- Column -->
				</div>
				<!-- Row -->
			</div>
		</div>
		<!-- ============================================================== -->
		<!-- End Page wrapper  -->
		<!-- ============================================================== -->
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
	<script src="/Project_CK_LTWEB/admin/js/jquery.dataTables.min.js"></script>
</body>

</html>