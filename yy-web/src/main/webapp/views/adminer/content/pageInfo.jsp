<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<title>网页信息管理</title>
</head>
<body>
<script type="text/javascript">
$(function(){
	$(".publishbtn").click(function(){
		$.get("${pageContext.request.contextPath}/news/createIndexNews",function(message){
			alert(message.result);
		})
	})
})
</script>
<button type="button"  class="down_btn btn btn-primary publishbtn">新闻首页静态页面生成</button>
</body>
</html>