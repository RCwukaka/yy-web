<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/basepage.css">
<script src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
<title>注册</title>
<script type="text/javascript">
	function changeValidateCode(obj) {
		var timenow = new Date().getTime();
		obj.src = "${pageContext.request.contextPath}/sercurity/securityCodeImage?d=" + timenow;
	}
	$.extend({
		sendRegister : function(json) {
			$.ajax({
				type : "post",
				url : "${pageContext.request.contextPath}/register",
				data : json,
				contentType : "application/json;charset=utf-8",
				dataType : "json",
				success : function(message) {
					
				}
			});
		}
	});
	$(function() {
		$('#btnRegister').on('click', function() {
			var username = $("#username").val();
			var password = $("#password").val();
			var nickname = $("#nickname").val();
			var securityCode = $("#securityCode").val();
			var confirmpassword = $("#confirmpassword").val();
			var matchval = "？*has-error";
			var obj = {
				"username" : username,
				"password" : password,
				"nickname" : nickname,
				"securityCode" : securityCode
			};
			$.sendRegister(obj);
			if (!matchval.test($("input").attr('class'))) {
				if (securityCode != "") {
					if (confirmpassword == password) {
						$(this).button("loading");
						$.sendRegister(obj);
					} else {
						alert("两次输入密码不一致");
					}
				}else{
					alert("请输入验证码！");
				}
			} else {
				alert("输入有错误");
			}
		});
		var patt1 = new RegExp("^(?!_)(?!.*?_$)[a-zA-Z_]+$");//只含有汉字、字母、下划线不能以下划线开头和结尾
		var patt2 = new RegExp("^(?!_)(?!.*?_$)[a-zA-Z_\u4e00-\u9fa5]+$");//只含有汉字、字母、下划线不能以下划线开头和结尾
		$("#username").bind("input onpropertychange onchange", function() {
			if ($(this).val().length < 8) {
				$(this).parent().parent().addClass("has-error");
			} else {
				if (patt1.test($(this).val())) {
					$(this).parent().parent().removeClass("has-error");
				}
			}
		});
		$("#nickname").bind("input onpropertychange onchange", function() {
			if ($(this).val().length < 1) {
				$(this).parent().parent().addClass("has-error");
			} else {
				if (patt2.test($(this).val())) {
					$(this).parent().parent().removeClass("has-error");
				}
			}
		});
		$("#password").bind("input onpropertychange onchange", function() {
			if ($(this).val().length < 6) {
				$(this).parent().parent().addClass("has-error");
			} else {
				$(this).parent().parent().removeClass("has-error");
			}
		});
		$("#confirmpassword").bind("input onpropertychange onchange",
				function() {
					if ($(this).val() != $("#password").val()) {
						$(this).parent().parent().addClass("has-error");
					} else {
						$(this).parent().parent().removeClass("has-error");
					}
				});
	});
</script>
<style type="text/css">
.sign {
	width: 100%;
	height: 20%;
	background-color: #5bc0de;
	height: 20%;
	text-align: left;
	font-size: 30px;
	line-height: 88px;
	color: #fff;
}
</style>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="content">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<div class="alert alert-success" role="alert">
						欢迎注册！以下视频为我们产品宣传视频</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-7">
					<div
						style="width: 100%; height: 100%; background-color: black; color: #fff">
						<video src="" width="100%" height="100%" controls autoplay loop>
						<source type=video/mp4 /> Your browser does not support the video
						tag. </video>
					</div>
				</div>
				<div class="col-md-5">
					<form class="form-horizontal"
						style="width: 80%; margin-left: auto; margin-right: auto"
						method="post">
						<div class="form-group has-feedback">
							<div class="col-sm-10 col-sm-offset-1">
								<span id="helpBlock" class="help-block">只含有字母,下划线不能以下划线开头和结尾,长度8位以上</span>
								<input type="text" class="form-control " id="username"
									name="username" aria-describedby="helpBlock" placeholder="账号"
									autofocus>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-10 col-sm-offset-1">
								<span id="helpBlock" class="help-block">只含有字母,汉字,下划线不能以下划线开头和结尾</span>
								<input type="text" class="form-control" id="nickname"
									placeholder="昵称">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-10 col-sm-offset-1">
								<span id="helpBlock" class="help-block">长度6位以上</span> <input
									type="password" class="form-control" id="password"
									placeholder="密码">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-10 col-sm-offset-1">
								<input type="password" class="form-control" id="confirmpassword"
									placeholder="重复密码">
							</div>
						</div>
						${result}
						<div class="form-group">
							<div class="row col-sm-offset-1">
								<div class="col-md-6">
									<input type="text" id="securityCode" class="form-control"
										placeholder="验证码">
								</div>
								<div class="col-md-4" style="padding-left: 0">
									<img alt="验证码"
										src="${pageContext.request.contextPath}/sercurity/securityCodeImage"
										style="vertical-align: middle; width: 100%; height: 100%"
										onclick="changeValidateCode(this)"><br />
								</div>
							</div>
						</div>
					</form>
					<div style="width: 80%; margin-left: auto; margin-right: auto">
						<div class="col-sm-11 col-sm-offset-1">
							<button type="button" class="btn btn-success btn-lg"
								id="btnRegister"
								style="width: 100%; margin-left: -12px; margin-right: -12px"
								data-loading-text="Saving..." autocomplete="off">注册</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<c:import url="/html/common/foot.html" charEncoding="UTF-8"></c:import>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>