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
<title>职位操作</title>
<script type="text/javascript">
$(document).ready(function() {
	$(".del_btn").click(function() {
		var id = $(this).attr("jobid");
		$.get("${pageContext.request.contextPath}/job/delJob/"+id, function(message){
			if (message.code == 0) {
				alert(message.result);
				top.frames['iframepage'].location.reload();
			}else{
				alert(message.result);
			}
		  });
	});
	$(".down_btn").click(function() {
		var id = $(this).attr("jobid");
		$.get("${pageContext.request.contextPath}/job/downJob/"+id, function(message){
			if (message.code == 0) {
				alert(message.result);
				top.frames['iframepage'].location.reload();
			}else{
				alert(message.result);
			}
		  });
	});
	$(".up_btn").click(function() {
		var id = $(this).attr("jobid");
		$.get("${pageContext.request.contextPath}/job/upJob/"+id, function(message){
			if (message.code == 0) {
				alert(message.result);
				top.frames['iframepage'].location.reload();
			}else{
				alert(message.result);
			}
		  });
	});
});
</script>
</head>
<body>
<table class="table table-hover col-md-12">
      <thead>
        <tr>
          <th>职位Id</th>
          <th>职位名称</th>
          <th>工作地点</th>
          <th>职位要求</th>
          <th>职位状态</th>
          <th style="text-align:center">操作</th>
        </tr>
      </thead>
      <tbody>
      	<c:forEach var="job" items="${map.jobList}">
	        <tr style="height:30px">
	          <th style="line-height:30px" scope="row">${job.id}</th>
	          <td style="line-height:30px">${job.jobName}</td>
	          <td style="line-height:30px">${job.jobPosition}</td>
	          <td style="line-height:30px">${job.jobRequire}</td>
	          <c:choose> 
		          <c:when test="${job.vaild=='1'}">
		          	<td style="line-height:30px">上架中</td>
		          </c:when>
		           <c:when test="${job.vaild=='0'}">
		          	<td style="line-height:30px">已下架</td>
		          </c:when>
	          </c:choose>
	          <td style="text-align:center">
		           <c:choose> 
			          <c:when test="${job.vaild=='1'}">
			          	<button type="button"  class="down_btn btn btn-primary" jobid="${job.id}">下架</button>
			          </c:when>
			           <c:when test="${job.vaild=='0'}">
			          	<button type="button"  class="up_btn btn btn-primary" jobid="${job.id}">上架</button>
			          </c:when>
		          </c:choose>
		          <button type="button"  class="del_btn btn btn-primary" jobid="${job.id}">删除</button>
	          </td>
	        </tr>
        </c:forEach>
      </tbody>
    </table>
</body>
</html>