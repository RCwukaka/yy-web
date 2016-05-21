<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<title>公司详情</title>
</head>
<style type="text/css">
.content {
	margin-top: 70px;
}
</style>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<div class="content">
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-2">
						<div class="list-group">
							<a href="#" class="list-group-item disabled">职位操作</a> 
							<a href="${pageContext.request.contextPath}/company/jobPublicView/${companyId}" class="list-group-item" target="iframepage">发布职位</a> 
							<a href="${pageContext.request.contextPath}/company/jobDelView/${companyId}" class="list-group-item" target="iframepage">职位下架</a>
							<a href="#" class="list-group-item disabled">简历操作</a>
							<a href="${pageContext.request.contextPath}/company/resumeChancelView/${companyId}" class="list-group-item" target="iframepage">处理简历</a>
							<a href="#" class="list-group-item disabled">公司设置</a>
							<a href="${pageContext.request.contextPath}/company/changeInfoView/${companyId}" class="list-group-item" target="iframepage">信息设置</a>
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