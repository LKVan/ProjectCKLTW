<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html dir="ltr" lang="en">

<head>
<meta charset="utf-8">

<title>Manager User</title>

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
				<div class="row">
					<div class="col-sm-12">
						<div class="white-box">
							<c:if test="${access != null }">
								<div class="alert alert-success">
									<fmt:message key="message.subccess" bundle="${lang }"></fmt:message>
								</div>
							</c:if>
							<h3 class="box-title text-uppercase text-center mb-3"><fmt:message key="menu.ManagerUser"
										bundle="${lang }"></fmt:message></h3>
							<div class="table-responsive">
								<table class="table text-nowrap" id="myTable">
									<thead>
										<tr>
											<th class="border-top-0"><fmt:message key="user.id"
										bundle="${lang }"></fmt:message></th>
											<th class="border-top-0"><fmt:message key="user.fullName"
										bundle="${lang }"></fmt:message></th>
											<th class="border-top-0"><fmt:message key="user.phone"
										bundle="${lang }"></fmt:message></th>
											<th class="border-top-0"><fmt:message key="user.userName"
										bundle="${lang }"></fmt:message></th>
											<th class="border-top-0"><fmt:message key="user.password"
										bundle="${lang }"></fmt:message></th>
											<th class="border-top-0"><fmt:message key="user.role"
										bundle="${lang }"></fmt:message></th>
											<th class="border-top-0"><fmt:message key="user.function"
										bundle="${lang }"></fmt:message></th>

										</tr>
									</thead>
									<tbody>
										<c:forEach var="eUser" items="${listUser}">
											<tr>
												<td>${eUser.id}</td>
												<td>${eUser.fullName }</td>
												<td>${eUser.numberPhone }</td>
												<td>${eUser.userName }</td>
												<td>${eUser.password }</td>
												<td>${eUser.rolId == 1 ? "Admin":"User" }</td>
												<td><a
													href="/Project_CK_LTWEB/manager_user?action=edit&eUserId=${eUser.id}"
													class="btn btn-primary"><i class="ti-pencil-alt"></i></a>
													<a
													href="/Project_CK_LTWEB/manager_user?action=detail&eUserId=${eUser.id }"
													class="btn btn-info text-white"><i class="ti-eye"></i></a>
													 <a
													href="/Project_CK_LTWEB/manager_user?action=trash&eUserId=${eUser.id}"
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
	<script type="text/javascript">
		$(document).ready(function() {
			$('#myTable').DataTable();
		});
	</script>
</body>

</html>