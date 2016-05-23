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
<title>简历处理</title>
<script type="text/javascript">
$(function(){
	$(".sendFace").click(function(){
		var jobid = $(this).attr("jobid");
		var resumeid=$(this).attr("resumeid");
		$.ajax({
			type : "post",
			url : "${pageContext.request.contextPath}/jobresume/updateState",
			data : {
				"jobId" : jobid,
				"resumeId" : resumeid,
				"state":1
			},
			dataType : "json",
			success : function(message) {
					alert(message.result);
				}
		});
	})
		$(".sendJob").click(function(){
			var jobid = $(this).attr("jobid");
			var resumeid=$(this).attr("resumeid");
		$.ajax({
			type : "post",
			url : "${pageContext.request.contextPath}/jobresume/updateState",
			data : {
				"jobId" : jobid,
				"resumeId" : resumeid,
				"state":2
			},
			dataType : "json",
			success : function(message) {
					alert(message.result);
				}
		});
	})
})
</script>
</head>
<body>
<table class="table table-hover col-md-12">
      <thead>
        <tr>
          <th>简历ID</th>
          <th>期望薪水</th>
          <th>电话</th>
          <th>应聘职位</th>
          <th>附件简历</th>
          <th>状态</th>
          <th style="text-align:center">操作</th>
        </tr>
      </thead>
      <tbody>
      	<c:forEach var="resume" items="${lists}" varStatus="state">
	        <tr style="height:30px">
	          <th style="line-height:30px" scope="row">${resume.id}</th>
	          <td style="line-height:30px">${resume.expect_salary}</td>
	          <td style="line-height:30px">${resume.phone}</td>
	          <td style="line-height:30px">${resume.jobname}</td>
	          <c:choose> 
		          <c:when test="${resume.resumeurl==''}">
	          		<td style="line-height:30px">无附件</td>
	          		</c:when>
	          		<c:otherwise>
	          		<td style="line-height:30px"><a href="" onclick="window.open(${resume.resumeurl})">下载简历</a></td>
	          		</c:otherwise>
         		</c:choose>
	          <c:choose> 
		          <c:when test="${resume.state=='0'}">
		          	<td style="line-height:30px">未查看</td>
		          </c:when>
		           <c:when test="${resume.state=='1'}">
		          	<td style="line-height:30px">通知面试</td>
		          </c:when>
		          <c:when test="${resume.state=='2'}">
		          	<td style="line-height:30px">已拒绝</td>
		          </c:when>
	          </c:choose>
	          <td style="text-align:center">
		           <c:choose> 
			          <c:when test="${resume.state=='0'}">
			          	<button type="button"  class="down_btn btn btn-primary" data-toggle="modal"
					data-target=".bs-example-modal-lg${state.index}">查看</button>
						<div class="modal fade bs-example-modal-lg${state.index}" tabindex="-1"
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
											<h4>个人介绍</h4>
											<small>${resume.introduce}</small>
											<h4>居住地点</h4>
											<small>${resume.position}</small>
											<h4>技能介绍</h4>
											<small>${resume.skills}</small>
											<h4>期望薪资</h4>
											<small>${resume.expect_salary}</small>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default sendFace" jobid="${resume.jobid}"resumeid="${resume.id}">通知面试</button>
											<button type="button" class="btn btn-primary sendJob" jobid="${resume.jobid}"resumeid="${resume.id}">拒绝</button>
										</div>
									</div>
								</div>
							</div>
			          </c:when>
		          </c:choose>
	          </td>
	        </tr>
        </c:forEach>
      </tbody>
    </table>
</body>
</html>