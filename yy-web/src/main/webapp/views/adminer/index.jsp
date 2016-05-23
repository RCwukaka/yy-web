<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<title>管理员首页</title>
<style type="text/css">
.content {
	margin-top: 70px;
}
</style>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="content">
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-2">
						<div class="list-group">
							<a href="#" class="list-group-item disabled">常用操作</a> 
							<a href="${pageContext.request.contextPath}/admin/news" class="list-group-item" target="iframepage">新闻管理</a> 
							<a href="${pageContext.request.contextPath}/admin/page" class="list-group-item" target="iframepage">网页管理</a> 
							<a href="${pageContext.request.contextPath}/admin/comment" class="list-group-item" target="iframepage">评论管理</a>
							<a href="${pageContext.request.contextPath}/admin/visitNum" class="list-group-item" target="iframepage">访客统计</a>
						</div>
					</div>
				<div class="col-sm-10">
					<iframe name="iframepage" id="iframepage" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" onLoad="iFrameHeight()" width="100%"></iframe>
				</div>
			</div>
		</div>
	</div>
	
<script type="text/javascript" language="javascript">   
function iFrameHeight() {   
	var ifm= document.getElementById("iframepage");   
	var subWeb = document.frames ? document.frames["iframepage"].document : ifm.contentDocument;   
	if(ifm != null && subWeb != null) {
	   ifm.height = subWeb.body.scrollHeight;
	   ifm.width = subWeb.body.scrollWidth;
	}   
}   
</script>
</body>
</html>