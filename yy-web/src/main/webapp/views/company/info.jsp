<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<title>公司信息</title>
<script type="text/javascript">
$(document).ready(function() {
	$("#send").click(function() {
		var stage = $("#stage").val();
		var companylocation = $("#companylocation").val();
		var companyemployernumber = $("#companyemployernumber").val();
		var companyintroduce = $("#companyintroduce").val();
		var companyId = ${companyId};
		var obj = {
			"companyId":companyId,
			"companyintroduce":companyintroduce,
			"companyemployernumber":companyemployernumber,
			"companylocation":companylocation,
			"stage":stage
		};
		$.ajax({
			type : "post",
			url : "${pageContext.request.contextPath}/company/changeInfo",
			data : obj,
			dataType : "json",
			success : function(message) {
				if(message.code!=0){
					alert(message.result);
				}
			}
		});
	})
});
</script>
</head>
<body>
<div class="content">
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-10">
					<h5>公司名称:${companyname}</h5>
					<div class="form-group">
						<label for="jobName" class="col-sm-2 control-label">公司阶段</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="stage"
								placeholder="${stage}">
						</div>
					</div>
					<br/>
					<br/>
					<div class="form-group">
						<label for="jobName" class="col-sm-2 control-label">公司介绍</label>
						<div class="col-sm-10">
							<textarea class="form-control" rows="3" id="companyintroduce" placeholder="公司介绍">${companyintroduce}</textarea>
						</div>
					</div>
					<br/>
					<br/>
					<div class="form-group">
						<label for="jobPosition" class="col-sm-2 control-label">公司地点</label>
						<div class="col-sm-10">
							<textarea class="form-control" rows="3" id="companylocation" placeholder="公司地点">${companylocation}</textarea>
						</div>
					</div>
					<br/>
					<br/>
					<div class="form-group">
						<label for="jobPosition" class="col-sm-2 control-label">公司电话</label>
						<div class="col-sm-10">
							<textarea class="form-control" rows="3" id="companylocation" placeholder="公司电话">${companyemployernumber}</textarea>
						</div>
					</div>
					<br/>
					<br/>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10" style="margin-top:10px">
							<button id="send" class="btn btn-warning">修改</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>
</body>
</html>