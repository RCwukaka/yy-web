<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<title>新闻操作</title>
<script type="text/javascript">
$(function(){
	$(".publishbtn").click(function(){
		var id = $(this).attr("newsid");
		$.ajax({
			type : "post",
			url : "${pageContext.request.contextPath}/admin/newsPublish",
			data : {
				"id":id,
				"status":1
			},
			dataType : "json",
			success : function(message) {
				if(message.code!=0){
					alert(message.result);
				}else{
					top.frames['iframepage'].location.reload();
				}
			}
		});
	})
	$(".cancelbtn").click(function(){
		var id = $(this).attr("newsid");
		$.ajax({
			type : "post",
			url : "${pageContext.request.contextPath}/admin/newsPublish",
			data : {
				"id":id,
				"status":2
			},
			dataType : "json",
			success : function(message) {
				if(message.code!=0){
					alert(message.result);
				}else{
					top.frames['iframepage'].location.reload();
				}
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
          <th>新闻id</th>
          <th>新闻标题</th>
          <th>链接</th>
          <th>状态</th>
          <th style="text-align:center">操作</th>
        </tr>
      </thead>
      <tbody>
      	<c:forEach var="news" items="${lists}">
	        <tr style="height:30px">
	          <th style="line-height:30px" scope="row">${news.id}</th>
	          <td style="line-height:30px">${news.title}</td>
	          <td style="line-height:30px"><a href="${pageContext.request.contextPath}/news/info/${news.id}" target="_blank">链接</a></td>
	          <c:choose> 
		          <c:when test="${news.status=='0'}">
		          	<td style="line-height:30px">审查中</td>
		          </c:when>
		           <c:when test="${news.status=='1'}">
		          	<td style="line-height:30px">已发布</td>
		          </c:when>
		           <c:when test="${news.status=='2'}">
		          	<td style="line-height:30px">已驳回</td>
		          </c:when>
	          </c:choose>
	          <td style="text-align:center">
		           <c:choose> 
			          <c:when test="${news.status=='0'}">
			          	<button type="button"  class="down_btn btn btn-primary publishbtn" newsid="${news.id}" >发布</button>
			          	<button type="button"  class="down_btn btn btn-primary cancelbtn" newsid="${news.id}" >驳回</button>
			          </c:when>
		          </c:choose>
	          </td>
	        </tr>
        </c:forEach>
      </tbody>
    </table>
</body>
</html>