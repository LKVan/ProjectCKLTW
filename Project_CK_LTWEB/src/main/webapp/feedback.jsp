<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Phản Hồi</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>


	<div class="container">
		
		<h2 style="text-align: center; margin-top: 30px;">Phản Hồi</h2>
		<div class="alert alert-success text-center" <c:if test="${ sucess ==null}">style="display: none"</c:if>>${sucess}</div>

		<form action="/Project_CK_LTWEB/FeedBackController" class="was-validated"
			method="post">
			<div class="form-group">
				<label for="uname">Họ và tên(*):</label> <input type="text"
					class="form-control" id="fullname" placeholder="Họ và tên"
					name="fullname" required>
				<div class="valid-feedback">Hợp lệ.</div>
				<div class="invalid-feedback">Vui lòng điền trường này</div>
			</div>
			<div class="form-group">
				<label for="pwd">Phone(*):</label> <input type="text"
					class="form-control" id="phone" placeholder="Nhập số điện thoại"
					name="phone" required>
				<div class="valid-feedback">Hợp lệ.</div>
				<div class="invalid-feedback">Vui lòng điền trường này</div>
			</div>
			<div class="form-group">
				<label for="pwd">Tiêu đề:</label> <input type="text"
					class="form-control" id="title" placeholder="Nhập tiêu đề"
					name="title">
			</div>
			<div class="form-group">
				<label for="pwd">Nội dung(*):</label>
				<textarea class="form-control" id="note"
					placeholder="Nhập nội dung phản hồi...." name="note" required
					rows="6"></textarea>
				<div class="valid-feedback">Hợp lệ.</div>
				<div class="invalid-feedback">Vui lòng điền trường này</div>
			</div>

			<button type="submit" class="btn btn-success mb-4 ">Gửi phản
				hồi</button>
		</form>
	</div>

</body>
</html>