<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html dir="ltr" lang="en">

<head>
<meta charset="utf-8">

<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Admin</title>
<!-- Favicon icon -->
<link rel="icon" type="image/png" sizes="16x16"
	href="/Project_CK_LTWEB/admin/plugins/images/favicon.png">

<link href="/Project_CK_LTWEB/themify-icons/themify-icons.css"
	rel="stylesheet">
<link href="/Project_CK_LTWEB/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="/Project_CK_LTWEB/admin/css/style.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="path/to/font-awesome/css/font-awesome.min.css">

</head>

<body>
	<fmt:setLocale value="${sessionScope.langName}" />
	<fmt:setBundle basename="i18n.lang" var="lang" />
	<div id="main-wrapper" data-layout="vertical" data-navbarbg="skin5"
		data-sidebartype="full" data-sidebar-position="absolute"
		data-header-position="absolute" data-boxed-layout="full">
		<!-- ============================================================== -->
		<!-- Topbar header - style you can find in pages.scss -->
		<!-- ============================================================== -->
		<header class="topbar" data-navbarbg="skin5">
			<nav class="navbar top-navbar navbar-expand-md navbar-dark">
				<div class="navbar-header" data-logobg="skin6">
					<!-- ============================================================== -->
					<!-- Logo -->
					<!-- ============================================================== -->
					<div class="navbar-brand">
						<!-- Logo icon -->
						<b class="logo-icon"> <!-- Dark Logo icon --> <img
							src="/Project_CK_LTWEB/admin/plugins/images/logo-icon.png"
							alt="homepage" />
						</b>
						<!--End Logo icon -->
						<!-- Logo text -->
						<span class="logo-text"> <!-- dark Logo text --> <img
							src="/Project_CK_LTWEB/admin/plugins/images/logo-text.png"
							alt="homepage" />
						</span>
					</div>
					<!-- ============================================================== -->
					<!-- End Logo -->
					<!-- ============================================================== -->
					<!-- ============================================================== -->
					<!-- toggle and nav items -->
					<!-- ============================================================== -->
					<a
						class="nav-toggler waves-effect waves-light text-dark d-block d-md-none"
						href="javascript:void(0)"><i class="ti-menu ti-close"></i></a>
				</div>
				<!-- ============================================================== -->
				<!-- End Logo -->
				<!-- ============================================================== -->
				<div class="navbar-collapse collapse" id="navbarSupportedContent"
					data-navbarbg="skin5">

					<!-- ============================================================== -->
					<!-- Right side toggle and nav items -->
					<!-- ============================================================== -->
					<ul class="navbar-nav ms-auto d-flex align-items-center">
						<li>
							<!-- style="margin-left: 30px"><span class="text-white">Chọn
								ngôn ngữ:</span>   <select name="langueName" onchange='change()' id="langue">
									<option  value = "vi_VN"><fmt:message key="select.VietNamese"
											bundle="${lang }"></fmt:message></option>
									<option value="en_US" ><fmt:message
											key="select.English" bundle="${lang }"></fmt:message></option>
								</select> <a href="?lang=en_US">Tieng Anh</a> <a
							href="?lang=vi_VN">Tieng Viet</a> <input type="submit"
							style="display: none" id="changeLangue">-->

							<div class="dropdown" style="z-index: 1000;">
								<button type="button" class="btn btn-primary dropdown-toggle"
									data-toggle="dropdown">
									<fmt:message key="choose.langue" bundle="${lang }"></fmt:message>
									<i class="ti-arrow-down mt-2"></i>
								</button>
								<div class="dropdown-menu">
									<a class="dropdown-item" href="?lang=en_US"><fmt:message
											key="select.English" bundle="${lang }"></fmt:message></a> <a
										class="dropdown-item" href="?lang=vi_VN"><fmt:message
											key="select.VietNamese" bundle="${lang }"></fmt:message></a>
								</div>
							</div>
						</li>
						<li>
							<div class="profile-pic">
								<img src="/Project_CK_LTWEB/admin/plugins/images/users/d2.jpg"
									alt="user-img" width="36" class="img-circle"><span
									class="text-white font-medium">${user.userName}</span>
							</div>
						</li>
						<!-- ============================================================== -->
						<!-- User profile and search -->
						<!-- ============================================================== -->
					</ul>
				</div>
			</nav>
		</header>
		<!-- ============================================================== -->
		<!-- End Topbar header -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Left Sidebar - style you can find in sidebar.scss  -->
		<!-- ============================================================== -->
		<aside class="left-sidebar" data-sidebarbg="skin6">
			<!-- Sidebar scroll-->
			<div class="scroll-sidebar">
				<!-- Sidebar navigation-->
				<nav class="sidebar-nav">
					<ul id="sidebarnav">
						<!-- User Profile-->
						<li class="sidebar-item pt-2"><a
							class="sidebar-link waves-effect waves-dark sidebar-link"
							href="/Project_CK_LTWEB/admin" aria-expanded="false"> <i
								class="ti-info" aria-hidden="true"></i> <span class="hide-menu"><fmt:message
										key="menu.Infor" bundle="${lang }"></fmt:message></span>
						</a></li>

						<li class="sidebar-item pt-2"><a
							class="sidebar-link waves-effect waves-dark sidebar-link"
							href="/Project_CK_LTWEB/manager_product" aria-expanded="false">
								<i class="ti-palette" aria-hidden="true"></i> <span
								class="hide-menu"><fmt:message key="menu.MangerProduct"
										bundle="${lang }"></fmt:message></span>
						</a></li>
						<li class="sidebar-item"><a
							class="sidebar-link waves-effect waves-dark sidebar-link"
							href="/Project_CK_LTWEB/manager_user" aria-expanded="false">
								<i class="ti-user" aria-hidden="true"></i> <span
								class="hide-menu"><fmt:message key="menu.ManagerUser"
										bundle="${lang }"></fmt:message></span>
						</a></li>
						<li class="sidebar-item"><a
							class="sidebar-link  waves-dark sidebar-link"
							aria-expanded="false" data-toggle="collapse"
							href="#collapseExample" role="button" aria-expanded="false"
							aria-controls="collapseExample"> <i
								class="ti-shopping-cart-full" aria-hidden="true"></i> <span
								class="hide-menu"><fmt:message key="menu.ManagerOrder"
										bundle="${lang }"></fmt:message></span>
						</a></li>

						<ul class="collapse" id="collapseExample">
							<li class="sidebar-item" style="margin-left: 5px"><a
								class="sidebar-link waves-effect waves-dark sidebar-link"
								href="/Project_CK_LTWEB/order?action=accept" aria-expanded="false"> <i
									class="ti-control-record" aria-hidden="true"></i> <span
									class="hide-menu"><fmt:message key="order.accept"
											bundle="${lang }"></fmt:message></span>
							</a></li>
							<li class="sidebar-item" style="margin-left: 5px"><a
								class="sidebar-link waves-effect waves-dark sidebar-link"
								href="/Project_CK_LTWEB/order?action=wating" aria-expanded="false"> <i
									class="ti-control-record" aria-hidden="true"></i> <span
									class="hide-menu"><fmt:message key="order.wattingMove"
											bundle="${lang }"></fmt:message></span>
							</a></li>
							<li class="sidebar-item" style="margin-left: 5px"><a
								class="sidebar-link waves-effect waves-dark sidebar-link"
								href="/Project_CK_LTWEB/order?action=move" aria-expanded="false"> <i
									class="ti-control-record" aria-hidden="true"></i> <span
									class="hide-menu"><fmt:message key="order.move"
											bundle="${lang }"></fmt:message></span>
							</a></li>
							<li class="sidebar-item" style="margin-left: 5px"><a
								class="sidebar-link waves-effect waves-dark sidebar-link"
								href="/Project_CK_LTWEB/order?action=finish" aria-expanded="false"> <i
									class="ti-control-record" aria-hidden="true"></i> <span
									class="hide-menu"><fmt:message key="order.finish"
											bundle="${lang }"></fmt:message></span>
							</a></li>
							
							<li class="sidebar-item" style="margin-left: 5px"><a
								class="sidebar-link waves-effect waves-dark sidebar-link"
								href="/Project_CK_LTWEB/order?action=destroy" aria-expanded="false"> <i
									class="ti-control-record" aria-hidden="true"></i> <span
									class="hide-menu"><fmt:message key="order.destroy"
											bundle="${lang }"></fmt:message></span>
							</a></li>
						</ul>


						<li class="sidebar-item"><a
							class="sidebar-link waves-effect waves-dark sidebar-link"
							href="/Project_CK_LTWEB/ManagerFeedback" aria-expanded="false">
								<i class="ti-ruler-pencil" aria-hidden="true"></i> <span
								class="hide-menu"><fmt:message key="menu.ManagerFeedBack"
										bundle="${lang }"></fmt:message></span>
						</a></li>
						<li class="sidebar-item"><a
							class="sidebar-link waves-effect waves-dark sidebar-link"
							href="/Project_CK_LTWEB/admin/map.jsp" aria-expanded="false">
								<i class="ti-map-alt" aria-hidden="true"></i> <span
								class="hide-menu">Google Map</span>
						</a></li>
						<li class="sidebar-item"><a
							class="sidebar-link waves-effect waves-dark sidebar-link"
							href="/Project_CK_LTWEB/404.html" aria-expanded="false"> <i
								class="ti-face-sad" aria-hidden="true"></i> <span
								class="hide-menu">Error 404</span>
						</a></li>
						<li class="text-center p-20 upgrade-btn"><c:set var="logOut"
								scope="session" value="logOut" /><a
							href="/Project_CK_LTWEB/login?logOut=${logOut}"
							class="btn d-grid btn-danger text-white"> <fmt:message
									key="select.logOut" bundle="${lang }"></fmt:message></a></li>
					</ul>

				</nav>
				<!-- End Sidebar navigation -->
			</div>
			<!-- End Sidebar scroll-->
		</aside>
		<!-- ============================================================== -->
		<!-- End Left Sidebar - style you can find in sidebar.scss  -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Page wrapper  -->
		<!-- ============================================================== -->
		<div class="page-wrapper">
			<!-- ============================================================== -->
			<!-- Bread crumb and right sidebar toggle -->
			<!-- ============================================================== -->
			<div class="page-breadcrumb bg-white">
				<div class="row align-items-center">
					<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
						<h4 class="page-title"></h4>
					</div>
					<div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
						<div class="d-md-flex">
							<ol class="breadcrumb ms-auto">
								<li><a href="#" class="fw-normal"></a></li>
							</ol>
							<a href="/Project_CK_LTWEB/login?logOut=${logOut}"
								class="btn btn-danger  d-none d-md-block pull-right ms-3 hidden-xs hidden-sm waves-effect waves-light text-white"><fmt:message
									key="select.logOut" bundle="${lang }"></fmt:message></a>
						</div>
					</div>
				</div>
				<!-- /.col-lg-12 -->
			</div>

		</div>
		<!-- ============================================================== -->
		<!-- End Page wrapper  -->
		<!-- ============================================================== -->
	</div>

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
	<script src="/Project_CK_LTWEB/admin/js/popper.min.js"></script>
	<script src="/Project_CK_LTWEB/admin/js/jquery.slim.min.js"></script>
	<script src="/Project_CK_LTWEB/admin/js/bootstrap.min.js"></script>

	<script>
		function change() {
			var e = document.getElementById('langue');
			//window.location = "/Project_CK_LTWEB/langue"
			//$.ajax({
			//url:"/Project_CK_LTWEB/langue",
			//type:"GET",
			//data:{langue:e.value},
			//});
			$("#changeLangue").click();
		}
	</script>
	
	<script type="text/javascript">
		function  changeIcon() {
			var e = document.getElementById('icon-toggle');
			e.remove
			
		}
	</script>
</body>

</html>