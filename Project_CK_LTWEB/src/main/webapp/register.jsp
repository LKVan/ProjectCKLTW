<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/register.css">
<link rel="stylesheet" type="text/css"
	href="themify-icons/themify-icons.css">


<title>Đăng ký</title>
</head>
<body>
	<%
	String userName = request.getParameter("userName");
	String password = request.getParameter("password");
	String rePassword = request.getParameter("rePassword");
	String fullName = request.getParameter("fullName");
	String phone = request.getParameter("phone");
	String addressDetail = request.getParameter("addressDetail");
	String email = request.getParameter("email");

	if (userName == null)
		userName = "";
	if (password == null)
		password = "";
	if (rePassword == null)
		rePassword = "";
	if (fullName == null)
		fullName = "";
	if (phone == null)
		phone = "";
	if (addressDetail == null)
		addressDetail = "";
	if(email == null)
		email = "";
	%>


	<section class="vh-100 bg-image"
		style="background-image: url('Image/img4.webp');">
		<div class="mask d-flex align-items-center h-100 gradient-custom-3">
			<div class="container h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-12 col-md-9 col-lg-7 col-xl-6">
						<div class="card" style="border-radius: 15px;">
							<a href="/Project_CK_LTWEB/HomeController" class="p-3"><i
								class="ti-angle-left"></i>Quay về</a>
							<div class="card-body p-5">
								<h2 class="text-uppercase text-center mb-5">Đăng kí tài
									khoản</h2>

								<form action="register" method="post">

									<div class="form-outline ">
										<label class="form-label" for="form3Example1cg">Tài
											khoản(*):</label> <input type="text" 
											class="form-control " required name="userName"
											value="<%=userName%>" />
									</div>
									<p style="color: red;">${message.get("userError")}</p>

									<div class="form-outline mt-4">
										<label class="form-label" for="form3Example4cg">Mật
											khẩu(*):</label> <input type="password" 
											class="form-control " required name="password"
											value="<%=password%>" />

									</div>
									<p style="color: red;">${message.get("password")}</p>

									<div class="form-outline mt-4">
										<label class="form-label" for="form3Example4cdg">Nhập
											lại mật khẩu(*):</label> <input type="password" 
											class="form-control" required name="rePassword"
											value="<%=rePassword%>" />

									</div>
									<p style="color: red;">${message.get("passwordError")}</p>

									<div class="form-outline mb-4">
										<label class="form-label" for="form3Example4cdg">Họ và
											tên(*):</label> <input type="text" 
											class="form-control" required name="fullName"
											value="<%=fullName%>" />

									</div>

									<div class="form-outline mb-4">
										<label class="form-label" for="form3Example3cg">SĐT(*):</label>
										<input type="text"  class="form-control"
											required name="phone" value="<%=phone%>" />

									</div>
									
									<div class="form-outline mb-4">
										<label class="form-label" for="form3Example3cg">Email(*):</label>
										<input type="email"  class="form-control"
											required name="email" value="<%=email%>" />

									</div>


									<!-- <div class="form-outline mb-4">
										 <label class="form-label" for="form3Example3cg">Địa
											chỉ(*):</label> <input type="text" id="form3Example3cg"
											class="form-control" required />-->

									<div class="form-group">
										<label for="sel1">Tỉnh/Thành Phố:</label> <select
											class="form-control" id="city" name="province"
											required="required">
											<option value="" selected>Chọn tỉnh thành</option>
										</select>
									</div>

									<div class="form-group">
										<label>Quận/Huyện:</label> <select class="form-control"
											id="district" name="district" required="required">
											<option value="" selected>Chọn quận huyện</option>
										</select>
									</div>

									<div class="form-group">
										<label>Phường/Xã:</label> <select class="form-control"
											id="ward" name="ward" required="required">
											<option>Chọn Phường/Xã</option>
											<option value="" selected>Chọn phường xã</option>
										</select>
									</div>

									<label class="form-label" for="form3Example4cdg">Địa
										chỉ chi tiết:</label>
									<textarea rows=2 id="form3Example4cdg" class="form-control"
										name="addressDetail" /><%=addressDetail%></textarea>




									<div class="d-flex justify-content-center py-2">
										<button type="submit"
											class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Đăng
											ký</button>
									</div>

									<p class="text-center text-muted mt-3 mb-0">
										Bạn có có tài khoản? <a href="login.jsp"
											class="fw-bold text-body"><u>Đăng nhập tại đây</u></a>
									</p>

								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<script type="text/javascript" src="js/popper.min.js"></script>
	<script type="text/javascript" src="js/axios.min.js"></script>
	<script type="text/javascript" src="js/jquery.slim.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/jquery.js"></script>

	<script>
	var citis = document.getElementById("city");
var districts = document.getElementById("district");
var wards = document.getElementById("ward");
var Parameter = {
  url: "data/data.json", 
  method: "GET", 
  responseType: "application/json", 
};
var promise = axios(Parameter);
promise.then(function (result) {
  renderCity(result.data);
});

function renderCity(data) {
  for (const x of data) {
    citis.options[citis.options.length] = new Option(x.Name, x.Id);
  }
  citis.onchange = function () {
    district.length = 1;
    ward.length = 1;
    if(this.value != ""){
      const result = data.filter(n => n.Id === this.value);

      for (const k of result[0].Districts) {
        district.options[district.options.length] = new Option(k.Name, k.Id);
      }
    }
  };
  district.onchange = function () {
    ward.length = 1;
    const dataCity = data.filter((n) => n.Id === citis.value);
    if (this.value != "") {
      const dataWards = dataCity[0].Districts.filter(n => n.Id === this.value)[0].Wards;

      for (const w of dataWards) {
        wards.options[wards.options.length] = new Option(w.Name, w.Id);
      }
    }
  };
}
	</script>


</body>
</html>