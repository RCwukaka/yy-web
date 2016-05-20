<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/wangEditor-1.3.12.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/wangEditor-1.3.12.css"
	type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/basepage.css">
<title>新闻操作</title>
<script type="text/javascript">
	$(document).ready(function() {
		$("#send").click(function() {
			var newsContent = $("#newsContent").val();
			var title = $("#title").val();
			var briefContent = $("#briefContent").val();
			var data = {
				"title" : title,
				"briefContent" : briefContent,
				"content" : newsContent
			};
			$.ajax({
				type : "post",
				url : "${pageContext.request.contextPath}/news/save/${token}",
				data : data,
				dataType : "json",
				success : function(message) {
					if (message.code == 0) {
						alert(message.result);
					}
				}
			});
		});
	});
</script>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="content">
		<div class="alert alert-warning" role="alert">请参考页面左侧规范进行新闻编写</div>
		<div class="row">
			<div class="col-md-4">
				文章规范
			</div>
			<div class="col-md-8">
				<input type="text" class="form-control" id="title" placeholder="新闻标题20字以内"><br>
				<textarea class="form-control" rows="3" id="briefContent" placeholder="100字文章概要"></textarea>
				<br>
				<textarea id='newsContent'
					style='height: 500px; max-height: 800px; width: 100%;'></textarea>
				<button class="btn btn-warning" id="send">提交</button>
				<br>
			</div>
		</div>
	</div>
	<c:import url="/html/common/foot.html" charEncoding="UTF-8"></c:import>
	<script type="text/javascript">
		$(function() {
			$('#newsContent')
					.wangEditor(
							{
								'menuConfig' : [
										[ 'bold', 'underline', 'italic',
												'strikethrough' ],
										[ 'blockquote', 'list', 'justify' ],
										[ 'insertTable' ],
										[ 'insertImage', 'insertVideo',
												'insertLocation' ],
										[ 'undo', 'redo' ] ]
							});
		});
	</script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>