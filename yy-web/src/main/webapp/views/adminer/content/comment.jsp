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
<title>评论审核</title>
<script type="text/javascript">
$(document).ready(function() {
	$(".del_btn").click(function() {
		var id = $(this).attr("commentid");
		$.get("${pageContext.request.contextPath}/comment/changeStatus?commentId="+id+"&status=0", function(message){
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
          <th>评论id</th>
          <th>评论内容</th>
          <th>状态</th>
          <th style="text-align:center">操作</th>
        </tr>
      </thead>
      <tbody>
      	<c:forEach var="comment" items="${lists}">
	        <tr style="height:30px">
	          <th style="line-height:30px" scope="row">${comment.id}</th>
	          <td style="line-height:30px">${comment.commentcontent}</td>
	          <c:choose> 
		          <c:when test="${comment.status=='0'}">
		          	<td style="line-height:30px">拉黑</td>
		          </c:when>
		           <c:when test="${comment.status=='1'}">
		          	<td style="line-height:30px">已发布</td>
		          </c:when>
	          </c:choose>
	          <td style="text-align:center">
		           <c:choose> 
			          <c:when test="${comment.status=='1'}">
			          	<button type="button"  class="down_btn btn btn-primary cancelbtn" commentid="${comment.id}" >拉黑</button>
			          </c:when>
		          </c:choose>
	          </td>
	        </tr>
        </c:forEach>
      </tbody>
    </table>
</body>
</html>