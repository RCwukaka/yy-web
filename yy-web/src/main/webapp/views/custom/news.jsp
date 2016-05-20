<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/wangEditor-1.3.12.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/wangEditor-1.3.12.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/news.css" type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/basepage.css">
<title>新闻</title>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="content">
		<div class="row">
			<div class="col-md-9">
				<h2>${title}</h2>
				<p style="display: none" id="newsId">${id}</p>
				<div>
					<p style='display: inline-block;'>作者:${nickname}</p>
					<p style='display: inline-block; margin-left: 20px;'>更新时间:${date}</p>
				</div>
				<c:import url="${ctx}" charEncoding="UTF-8"></c:import>
				<textarea id='commentContent' style='height: 200px; width: 100%;'></textarea>
				<button class="btn btn-warning" style="margin-top: 10px" id="send">发表评论</button>
			</div>
			<div class="col-md-3">
				<div id="article_side">
					<div class="row">
						<div class="col-md-6">
							<img class="img-circle" width="60px" height="60px"
								style="display: block; margin: 0 auto;" src="${imgSrc}">
						</div>
						<div class="col-md-6">
							<p>作者:${nickname}</p>
							<p>简介:${introduce}</p>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">文章数:${articlenum}</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<c:import url="/html/common/foot.html" charEncoding="UTF-8"></c:import>
	<script type="text/javascript">
		$(function() {
			$('#commentContent')
					.wangEditor(
							{
								'menuConfig' : [
										[ 'bold', 'underline', 'italic' ],
										[ 'blockquote', 'fontFamily', 'list',
												'justify' ],
										[ 'createLink', 'unLink', 'insertTable' ],
										[ 'undo', 'redo' ] ]
							});
		});
	</script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>