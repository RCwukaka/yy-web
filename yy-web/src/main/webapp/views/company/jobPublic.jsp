<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<title>职位发布</title>
</head>
<script type="text/javascript">
	$(document).ready(function() {
	$("#send").click(function() {
		var jobName = $("#jobName").val();
		var jobPosition = $("#jobPosition").val();
		var jobRequire = $("#jobRequire").val();
		var salary = $("#salary").val();
		var data = {
			"jobName" : jobName,
			"jobPosition" : jobPosition,
			"jobRequire" : jobRequire,
			"salary":salary
		};
		$.ajax({
			type : "post",
			url : "${pageContext.request.contextPath}/job/save/${companyId}",
			data : data,
			dataType : "json",
			success : function(
					message) {
				if (message.code == 0) {
					alert(message.result);
				}
			}
		});
	});
});
</script>
<body>
	<div class="content">
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-10">
					<div class="form-group">
						<label for="jobName" class="col-sm-2 control-label">职位名称</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="jobName"
								placeholder="职位名称">
						</div>
					</div>
					<br /> <br />
					<div class="form-group">
						<label for="jobPosition" class="col-sm-2 control-label">工作地点</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="jobPosition"
								placeholder="职位名称">
						</div>
					</div>
					<br /> <br />
					<div class="form-group">
						<label for="jobPosition" class="col-sm-2 control-label">薪水</label>
						<div class="col-sm-10">
							<select class="form-control" id="salary">
								<option value="1">1000-2000</option>
								<option value="2">2000-4000</option>
								<option value="3">4000-6000</option>
								<option value="4">6000-8000</option>
								<option value="5">8000-</option>
							</select>
						</div>
					</div>
					<br /> <br />
					<div class="form-group">
						<label for="jobRequire" class="col-sm-2 control-label">职位要求</label>
						<div class="col-sm-10">
							<textarea class="form-control" rows="3" id="jobRequire"
								placeholder="职位要求"></textarea>
						</div>
					</div>
					<br /> <br />
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10" style="margin-top: 10px">
							<button id="send" class="btn btn-warning">发布</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>