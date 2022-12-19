<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>

<style type="text/css">
.table {
	
}

;
tbody {
	
}

;
tr {
	
}

;
td, .table {
	
}

;
tfoot {
	
}

;
tr {
	
}

;
td {
	vertical-align: middle;
}

@media screen and (max-width: 600px) {
	table#cart tbody td .form-control {
		width: 20%;
		display: inline !important;
	}
	.actions .btn {
		width: 36%;
		margin: 1.5em 0;
	}
	.actions .btn-info {
		float: left;
	}
	.actions .btn-danger {
		float: right;
	}
	table#cart thead {
		display: none;
	}
	table#cart tbody td {
		display: block;
		padding: .6rem;
		min-width: 320px;
	}
	table#cart tbody tr td:first-child {
		background: #333;
		color: #fff;
	}
	table#cart tbody td:before {
		content: attr(data-th);
		font-weight: bold;
		display: inline-block;
		width: 8rem;
	}
	table#cart tfoot td {
		display: block;
	}
	table#cart tfoot td .btn {
		display: block;
	}
}
</style>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/bootstrap.min.js"></script>


</head>
<body>
	<h2 class="text-center">Đơn đã mua</h2>
	<div class="container">
		<div>
			<a href="cart.jsp" class="btn btn-info" align="right"><i
				class="fa fa-angle-left"></i> Giỏ hàng</a>
		</div>
		<table id="cart" class="table table-hover table-condensed">
			<thead>
				<tr>
					<th style="width: 50%">Tên sản phẩm</th>
					<th style="width: 10%">Giá</th>
					<th style="width: 8%">Số lượng</th>
					<th style="width: 10%">Trình trạng</th>
				</tr>
			</thead>
			<jsp:useBean id="cart" scope="session" class="model.Cart" />
			<c:forEach var="order" items="${listOrder}" varStatus="counter">
				<form method="POST" action="CartController">
					<tbody>
						<tr>
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-10">
										<h4 class="nomargin">${order.productName}</h4>
									</div>
								</div>
							</td>
							<td data-th="Price">${order.productPrice} VNĐ.</td>
							<td data-th="Quantity"><input
								class="form-control text-center" name="quan" value="${order.quanlity}"
								type="number" readonly="readonly">
								</td>
							<c:if test="${order.status == 1 }">
								<td><span class="badge badge-danger">Đang chờ xác nhận</span></td>
							</c:if>
							<c:if test="${order.status == 2 }">
								<td><span class="badge badge-warning">Đang chờ vận chuyển</span></td>
							</c:if>
							<c:if test="${order.status == 3 }">
								<td><span class="badge badge-info">Đang vận chuyển</span></td>
							</c:if>
							<c:if test="${order.status == 4 }">
								<td><span class="badge badge-success">Đã giao</span></td>
							</c:if>
							
						</tr>
				</form>
			</c:forEach>
			<td><a href="HomeController" class="btn btn-warning"><i
					class="fa fa-angle-left"></i> Tiếp tục mua hàng</a></td>
			<td colspan="2" class="hidden-xs"></td>

			</tfoot>
		</table>
	</div>
	<script src="js/jquery-1.11.1.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>