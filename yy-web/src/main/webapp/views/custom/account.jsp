<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/basepage.css">
<script src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<title>个人主页</title>
</head>
<style>
.thumbnails li {
	list-style: none;
}
</style>
<script type="text/javascript">
	$(function() {
		 $(".userinfo").click(function(){
			  $(".userinfo").each(function(){
				  $(this).parent().removeClass("active");
			  });
			  $(this).parent().addClass("active");
		  })
		$("#position").val('<s:property value="user.position"/>');
		$('#saveInfo').on('click', function() {
			$(this).button('loading');
			var email = $("#email").val();
			var nickname = $("#nickname").val();
			var phone = $("#phone").val();
			var position = $("#position").val();
			var introduce = $("#introduce").val();
			$.ajax({
				type : "post",
				url : "${pageContext.request.contextPath}/userInform/userInfo",
				data : {
					"csrfToken" : '',
					"email" : email,
					"nickname" : nickname,
					"phone" : phone,
					"position" : position,
					"ability" : "java",
					"introduce" : introduce
				},
				dataType : "json",
				success : function(message) {
					$('#saveInfo').button('reset');
				}
			});
		});
		$("#base").trigger("click");
	})
</script>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="content">
		<div class="row">
			<div class="col-md-10 col-md-offset-1">
				<ul class="nav nav-tabs">
						<li class="active"><a class="userinfo" href="${pageContext.request.contextPath}/account/base/${token}"  target="iframepage" id="base">基本信息</a></li>
						<script>
							$(function(){
								document.getElementById("base").click();
							})
						</script>
  						<li><a class="userinfo" href="${pageContext.request.contextPath}/account/resume/${token}"  target="iframepage" id="resume">我的简历</a></li>
						<li><a class="userinfo" href="${pageContext.request.contextPath}/account/article/${token}"  target="iframepage" id="article">我的文章</a></li>
				</ul>
					<div class="ee" style="padding-right:30px">
						<div>
							<iframe name="iframepage" id="iframepage" frameborder="0"
								scrolling="no" marginheight="0" marginwidth="0"
								onLoad="iFrameHeight()" width="100%"></iframe>
						</div>
					</div>
			</div>
		</div>
	</div>
	<c:import url="/html/common/foot.html" charEncoding="UTF-8"></c:import>
	<script type="text/javascript" language="javascript">
		function iFrameHeight() {
			var ifm = document.getElementById("iframepage");
			var subWeb = document.frames ? document.frames["iframepage"].document
					: ifm.contentDocument;
			if (ifm != null && subWeb != null) {
				ifm.height = subWeb.body.scrollHeight;
				ifm.width = subWeb.body.scrollWidth;
			}
		}
	</script>
</body>
</html>