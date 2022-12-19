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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>


</head>
<body>
	<h2 class="text-center">Giỏ Hàng</h2>
	<div class="container">
		<div>
			<a href="/Project_CK_LTWEB/orderUser" class="btn btn-info" align="right"><i
				class="fa fa-angle-left"></i> Đơn đã mua</a>
		</div>
		<table id="cart" class="table table-hover table-condensed">
			<thead>
				<tr>
					<th style="width: 50%">Tên sản phẩm</th>
					<th style="width: 10%">Giá</th>
					<th style="width: 8%">Số lượng</th>
					<th style="width: 22%" class="text-center">Thành tiền</th>
					<th style="width: 10%"></th>
				</tr>
			</thead>
			<jsp:useBean id="cart" scope="session" class="model.Cart" />
			<c:forEach var="cartItem" items="${cart.list}" varStatus="counter">
				<form method="POST" action="CartController">
					<tbody>
						<tr>
							<td data-th="Product">
								<div class="row">
									<input type='hidden' name='stt'
										value='<c:out value="${counter.count}"/>'>
									<div class="col-sm-2 hidden-xs">
										<img src="${cartItem.image}" class="img-responsive"
											width="100">
									</div>
									<input type="hidden" name="cart_pro_id" value="${cartItem.id}" />
									<div class="col-sm-10">
										<h4 class="nomargin">${cartItem.name}</h4>
										<p>${cartItem.description }</p>
									</div>
								</div>
							</td>
							<td data-th="Price">${cartItem.formatPrice()}VNĐ.</td>
							<input type="hidden" name="price" value="${cartItem.price}" />
							<td data-th="Quantity"><input
								class="form-control text-center" name="quan" value="${cartItem.quantity}"
								type="number">
								<button class="btn btn-success btn-block" name="action"
									value="update">
									<i class="fa fa-trash-o">Cập nhật</i>
								</button>
								</td>
							<td data-th="Subtotal" class="text-center">${cartItem.formatTotal()}
								VNĐ.đ</td>
							<td class="actions" data-th="">
								<button class="btn btn-info btn-sm" name="action" value="oder"
									onclick="oder()">
									<i class="fa fa-edit">Đặt hàng</i>
								</button> <script type="text/javascript">
									function oder() {
										alert("Đặt hàng thành công");
									}
								</script>

								<button class="btn btn-danger btn-sm" name="action"
									value="delete">
									<i class="fa fa-trash-o">Xóa</i>
								</button>
							</td>
							<td></td>
						</tr>
				</form>
			</c:forEach>
			<td><a href="HomeController" class="btn btn-warning"><i
					class="fa fa-angle-left"></i> Tiếp tục mua hàng</a></td>
			<td colspan="2" class="hidden-xs"></td>
			<td class="hidden-xs text-center"><strong>TỔNG:
					${cart.formatTotal()} VNĐ.</strong></td>

			</tfoot>
		</table>
	</div>
	<script src="js/jquery-1.11.1.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>