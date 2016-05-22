<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/basepage.css">
<script src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<title>招聘</title>
</head>
<body>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="content">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-4">
					<div class="panel-group" id="accordion" role="tablist"
						aria-multiselectable="true">
						<div class="panel panel-default">
							<div class="panel-heading" role="tab" id="headingOne">
								<h4 class="panel-title">
									<a role="button" data-toggle="collapse"
										data-parent="#accordion" href="#collapseOne"
										aria-expanded="true" aria-controls="collapseOne"> IT后端开发</a>
								</h4>
							</div>
							<div id="collapseOne" class="panel-collapse collapse in"
								role="tabpanel" aria-labelledby="headingOne">
								<div class="panel-body">
									<ul class="target">
										<li class="success"><a class="position">JAVA</a></li>
										<li><a class="position">PHP</a></li>
										<li><a class="position">C</a></li>
										<li><a class="position">C++</a></li>
										<li class="success"><a class="position">Android</a></li>
										<li><a class="position">IOS</a></li>
										<li><a class="position">测试</a></li>
										<li class="success"><a class="position">nodejs</a></li>
										<li><a class="position">架构师</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading" role="tab" id="headingTwo">
								<h4 class="panel-title">
									<a class="collapsed" role="button" data-toggle="collapse"
										data-parent="#accordion" href="#collapseTwo"
										aria-expanded="false" aria-controls="collapseTwo"> IT前端开发</a>
								</h4>
							</div>
							<div id="collapseTwo" class="panel-collapse collapse"
								role="tabpanel" aria-labelledby="headingTwo">
								<div class="panel-body">
									<ul class="target">
										<li class="success"><a class="position">WEB前端</a></li>
										<li><a class="position">FLASH</a></li>
										<li><a class="position">H5</a></li>
										<li><a class="position">Javascript</a></li>
										<li class="success"><a class="position">U3D</a></li>
										<li><a class="position">COCOS2D-X</a></li>
										<li><a class="position">其他</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading" role="tab" id="headingThree">
								<h4 class="panel-title">
									<a class="collapsed" role="button" data-toggle="collapse"
										data-parent="#accordion" href="#collapseThree"
										aria-expanded="false" aria-controls="collapseThree">硬件类</a>
								</h4>
							</div>
							<div id="collapseThree" class="panel-collapse collapse"
								role="tabpanel" aria-labelledby="headingThree">
								<div class="panel-body">
									<ul class="target">
										<li class="success"><a class="position">自动化</a></li>
										<li><a class="position">单片机</a></li>
										<li><a class="position">单片机</a></li>
										<li class="success"><a class="position">电路设计</a></li>
										<li><a class="position">驱动开发</a></li>
										<li><a class="position">材料工程师</a></li>
										<li class="success"><a class="position">精益工程师</a></li>
										<li><a class="position"> 射频工程师</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading" role="tab" id="headingSix">
								<h4 class="panel-title">
									<a class="collapsed" role="button" data-toggle="collapse"
										data-parent="#accordion" href="#collapseSix"
										aria-expanded="false" aria-controls="collapseSix">运营类</a>
								</h4>
							</div>
							<div id="collapseSix" class="panel-collapse collapse"
								role="tabpanel" aria-labelledby="headingSix">
								<div class="panel-body">
									<ul class="target">
										<li class="success"><a class="position">内容运营</a></li>
										<li><a class="position">产品运营</a></li>
										<li><a class="position">数据运营</a></li>
										<li><a class="position">用户运营</a></li>
										<li class="success"><a class="position">活动运营</a></li>
										<li><a class="position">商家运营</a></li>
										<li><a class="position">品类运营</a></li>
										<li class="success"><a class="position">游戏运营</a></li>
										<li><a class="position">网络推广</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>

				</div>
				<div class="col-md-8">
					<div class="input-group margin-b">
						<input type="text" class="form-control bg-success"
							placeholder="请输入职位名称" id="jobInfo"> <span
							class="input-group-btn">
							<button class="btn btn-success" type="button" id="searchjob">搜索职位</button>
						</span>
					</div>
					<a style="display:none"  target="iframepage" id="job"></a>
					<a class="userinfo" href="${pageContext.request.contextPath}/views/custom/job/advice.jsp" style="display:none"  target="iframepage" id="base"></a>
					<script type="text/javascript" language="javascript" charset='gb2312'>
							$(function(){
								document.getElementById("base").click();
								$("#searchjob").click(function(){
									var jobInfo = $("#jobInfo").val();
									$("#job").attr("href","${pageContext.request.contextPath}/job/findJob/"+encodeURI(jobInfo)+"/${token}");
									document.getElementById("job").click();
								})
								$(".position").click(function(){
									var jobInfo = $(this).html();
									$(this).attr("href","${pageContext.request.contextPath}/job/findJob/"+encodeURI(jobInfo)+"/${token}");
									$(this).attr("target","iframepage");
									document.getElementById("job").click();
								})
							})
						</script>
						<div style="padding-right:15px">
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