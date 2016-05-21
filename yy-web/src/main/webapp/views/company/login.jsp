<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/basepage.css">
<script src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
<script>
	$(document).ready(function() {
		$("#btnRegister").click(function() {
			var username = $("#rgUsername").val();
			var password = $("#rgPassword").val();
			var obj = {
				"companyName" : username,
				"password" : password
			};
			$.ajax({
				type : "post",
				url : "${pageContext.request.contextPath}/company/register",
				data : obj,
				dataType : "json",
				success : function(message) {
					if(message.code!=0){
						alert(message.result);
					}else{
						window.location.href = "${pageContext.request.contextPath}/company/index/"+message.map.companyId;
					}
				}
			});
		})
		$("#btnLogin").click(function() {
			var username = $("#username").val();
			var password = $("#password1").val();
			var obj = {
				"companyName" : username,
				"password" : password
			};
			$.ajax({
				type : "post",
				url : "${pageContext.request.contextPath}/company/login",
				data : obj,
				dataType : "json",
				success : function(message) {
					if(message.code!=0){
						alert(message.result);
					}else{
						window.location.href = "${pageContext.request.contextPath}/company/index/"+message.map.companyId;
					}
				}
			});
		});
	});
</script>
</head>
<body>
	<jsp:include page="../custom/navbar.jsp"></jsp:include>
	<div class="content">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-4">
				</div>
				<div class="col-md-4">
					<div id="showTab">
						<ul class="nav nav-tabs" role="tablist" id="myTabs">
							<li class="active"><a href="#login" aria-controls="home" data-toggle="tab">登录</a></li>
							<li><a href="#register" aria-controls="register" data-toggle="tab">注册</a></li>
						</ul>
						<div class="tab-content">
							<div role="tabpanel" class="tab-pane active" id="login">
								  <div class="form-group">
								    <label for="exampleInputEmail1">帐号</label>
								    <input type="text" class="form-control" id="username" placeholder="Email">
								  </div>
								  <div class="form-group">
								    <label for="exampleInputPassword1">密码</label>
								    <input type="password" class="form-control" id="password1" placeholder="Password">
								  </div>
								  <button id="btnLogin" class="btn btn-primary">登录</button>
							</div>
							
						    <div role="tabpanel" class="tab-pane" id="register">
								  <div class="form-group">
								    <label for="exampleInputEmail2">公司名称</label>
								    <input type="text" class="form-control" id="rgUsername" placeholder="Email">
								  </div>
								  <div class="form-group">
								    <label for="exampleInputPassword1">密码</label>
								    <input type="password" class="form-control" id="rgPassword" placeholder="Password">
								  </div>
								  <div class="form-group">
								    <label for="exampleInputPassword1">确认密码</label>
								    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
								  </div>
								  <button id="btnRegister" class="btn btn-warning">注册</button>
							</div>
					  </div>
					</div>
				</div>
				<div class="col-md-4">
				</div>
			</div>
		</div>
	</div>
	<c:import url="/html/common/foot.html" charEncoding="UTF-8"></c:import>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>