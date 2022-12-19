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
<title>Detail Feedback</title>
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
		<fmt:setLocale value="${sessionScope.langName}" />
		<fmt:setBundle basename="i18n.lang" var="lang" />
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
							<h3 class="text-center">
								<fmt:message key="feedback.detail" bundle="${lang }"></fmt:message>
							</h3>
							<div class="form-group mb-4">
								<div class="col-sm-12" align="right">
									<a class="btn btn-primary"
										href="/Project_CK_LTWEB/ManagerFeedback"><b><fmt:message
												key="select.cancel" bundle="${lang }"></fmt:message></b></a>
								</div>
							</div>

							<div class="form-group mb-4">
								<label class="col-md-12 p-0"><b><fmt:message
											key="feedback.id" bundle="${lang }"></fmt:message></b></label>
								<div class="col-md-12 border-bottom p-0">
									<input type="text" class="form-control p-3 border-0" readonly
										value="${feed.id}">
								</div>
							</div>

							<div class="form-group mb-4">
								<label class="col-md-12 p-0"><b><fmt:message
											key="feedback.fullName" bundle="${lang }"></fmt:message></b></label>
								<div class="col-md-12 border-bottom p-0">
									<input type="text" placeholder="Johnathan Doe"
										class="form-control p-3 border-0" value="${feed.fullName}"
										name="userFullname" readonly>
								</div>
							</div>
							<div class="form-group mb-4">
								<label class="col-md-12 p-0"><b><fmt:message
											key="feedback.phone" bundle="${lang }"></fmt:message></b></label>
								<div class="col-md-12 border-bottom p-0">
									<input type="text" class="form-control p-3 border-0"
										value="${feed.phone}" name="userPhone" readonly>
								</div>
							</div>

							<div class="form-group mb-4">
								<label class="col-md-12 p-0"><b><fmt:message
											key="feedback.title" bundle="${lang }"></fmt:message></b></label>
								<div class="col-md-12 border-bottom p-0">
									<input type="text" class="form-control p-3 border-0"
										value="${feed.title}" name="userPhone" readonly>
								</div>
							</div>

							<div class="form-group mb-4">
								<label class="col-md-12 p-0"><b><fmt:message
											key="feedback.descreption" bundle="${lang }"></fmt:message></b></label>
								<div class="col-md-12 border-bottom p-0">
									<textarea rows="5" class="form-control p-3 border-0"
										name="userAddress" readonly>${feed.descreption}</textarea>
								</div>
							</div>



						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Column -->
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
</body>

</html>