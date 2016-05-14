<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/system-web/css/bootstrap.min.css">
<link rel="stylesheet" href="/system-web/css/basepage.css">
<script src="/system-web/js/jquery-2.1.4.min.js"></script>
<title>首页</title>
</head> 
<script>
$(function() {  
    $('#myTabs a').click(function(e) {  
        e.preventDefault();  
        $(this).tab('show');  
    });  
});  
</script>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="content">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<div class="alert alert-warning" role="alert">前端重新做，求nodejs小伙伴</div>
					<!-- 首页image滚动html -->
					<jsp:include page="/html/index/index_news_image.html" ></jsp:include>
					<!-- 结束 -->
				</div>
			</div>
			<div class="row" style="margin-top: 20px">
				<div class="col-md-3">
					<!-- 首页导航框html -->
					<jsp:include page="/html/index/index_news_navbar.html"></jsp:include>
					<!-- 结束 -->
				</div>
				<div class="col-md-9">
					<!-- 首页内容html -->
					<jsp:include page="/html/index/index_news_content.html"></jsp:include>
					<!-- 结束 -->
				</div>
			</div>
		</div>
	</div>
	<!-- 页面脚部html -->
	<jsp:include page="/html/common/foot.html"></jsp:include>
	<!-- 结束 -->
	<script src="/system-web/js/bootstrap.min.js"></script>
</body>
</html>