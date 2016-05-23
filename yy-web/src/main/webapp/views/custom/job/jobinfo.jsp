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
<title>工作信息</title>
<script type="text/javascript">
$(function(){
	$(".sendJob").click(function(){
		var jobid = $(this).attr("jobid");
		var resumeid= ${resumeId};
		if(resumeid==""){
			alert("请先登录");
		}else{
			$.ajax({
				type : "post",
				url : "${pageContext.request.contextPath}/jobresume/save/${token}",
				data : {
					"jobId" : jobid,
					"resumeId" : resumeid
				},
				dataType : "json",
				success : function(message) {
						alert(message.result);
					}
			});
		}
	})
})
</script>
</head>
<body>
<c:forEach var="list" items ="${lists}">
	<blockquote>
		<div class="media">
			<div class="media-body">
				<a href="">${list.jobname}(${list.companyname})</a>
				<small>薪水:${list.salary} 发布时间:${list.jobdate}</small>
			</div>
			<div class="media-right">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target=".bs-example-modal-lg${list.id}">查看</button>
			</div>
		</div>
		<div class="modal fade bs-example-modal-lg${list.id}" tabindex="-1"
			role="dialog" aria-labelledby="myLargeModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<h4>职位名称</h4>
						<small>${list.jobname}</small>
						<h4>工作地点</h4>
						<small>${list.jobposition}</small>
						<h4>薪水福利</h4>
						<small>${list.salary}</small>
						<h4>技能要求</h4>
						<small>${list.jobrequire}</small>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary sendJob" jobid="${list.id}">投递</button>
					</div>
				</div>
			</div>
		</div>
	</blockquote>
</c:forEach>
</body>
</html>