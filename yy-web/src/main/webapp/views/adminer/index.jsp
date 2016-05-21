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
							<a href="/system-web/admin/news" class="list-group-item" target="iframepage">新闻管理</a> 
							<a href="/system-web/activity" class="list-group-item" target="iframepage">网页管理</a> 
							<a href="#" class="list-group-item" target="iframepage">留言管理</a> 
							<a href="#" class="list-group-item" target="iframepage">评论管理</a>
							<a href="content/visit.jsp" class="list-group-item" target="iframepage">访客统计</a>
							<a href="#" class="list-group-item" target="iframepage">用户管理</a>
							<a href="#" class="list-group-item" target="iframepage">公司注册审核</a>
							<a href="#" class="list-group-item disabled">系统设置</a>
							<a href="#" class="list-group-item" target="iframepage">系统日志</a>
							<a href="#" class="list-group-item" target="iframepage">数据备份</a>
							<a href="#" class="list-group-item" target="iframepage">系统参数</a>
							<a href="#" class="list-group-item" target="iframepage">权限管理</a>
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