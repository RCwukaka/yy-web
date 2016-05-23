<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/basepage.css">
<script src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
<script>
$(document).ready(function() {
	$("#btnLogin").click(function() {
		var username = $("#username").val();
		var password = $("#password1")
				.val();
		var obj = {
			"companyName" : username,
			"password" : password
		};
		$.ajax({
			type : "post",
			url : "${pageContext.request.contextPath}/company/login",
			data : obj,
			dataType : "json",
			success : function(
					message) {
				if (message.code != 0) {
					alert(message.result);
				} else {
					window.location.href = "${pageContext.request.contextPath}/admin/index";
				}
			}
		});
	});
});
</script>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="content">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<div id="showTab">
						<div class="form-group">
							<label for="exampleInputEmail1">帐号</label> <input type="text"
								class="form-control" id="username" placeholder="Email">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">密码</label> <input
								type="password" class="form-control" id="password1"
								placeholder="Password">
						</div>
						<button id="btnLogin" class="btn btn-primary">登录</button>
					</div>
				</div>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
	<c:import url="/html/common/foot.html" charEncoding="UTF-8"></c:import>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>