<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/basepage.css">
<script src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<title>广告位</title>
</head>
<body>
<div id="carousel-example-generic" class="carousel slide"
	data-ride="carousel">
	<ol class="carousel-indicators">
		<li data-target="#carousel-example-generic" data-slide-to="0"
			class="active"></li>
		<li data-target="#carousel-example-generic" data-slide-to="1"></li>
		<li data-target="#carousel-example-generic" data-slide-to="2"></li>
	</ol>

	<div class="carousel-inner" role="listbox">
		<div class="item active">
			<img src="${pageContext.request.contextPath}/img/1.jpg">
			<div class="carousel-caption">
				<h3>棒球</h3>
				<p>棒球运动是一种以棒打球为主要特点，集体性、对抗性很强的球类运动项目，在美国、日本尤为盛行。</p>
			</div>
		</div>
		<div class="item">
			<img src="${pageContext.request.contextPath}/img/2.jpg">
			<div class="carousel-caption">
				<h3>冲浪</h3>
				<p>冲浪是以海浪为动力，利用自身的高超技巧和平衡能力，搏击海浪的一项运动。运动员站立在冲浪板上，或利用腹板、跪板、充气的橡皮垫、划艇、皮艇等驾驭海浪的一项水上运动。</p>
			</div>
		</div>
		<div class="item">
			<img src="${pageContext.request.contextPath}/img/3.jpg">
			<div class="carousel-caption">
				<h3>自行车</h3>
				<p>以自行车为工具比赛骑行速度的体育运动。1896年第一届奥林匹克运动会上被列为正式比赛项目。环法赛为最著名的世界自行车锦标赛。</p>
			</div>
		</div>
	</div>
	<a class="left carousel-control" href="#carousel-example-generic"
		role="button" data-slide="prev"> <span
		class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
		<span class="sr-only">Previous</span>
	</a> <a class="right carousel-control"
		href="#carousel-example-generic" role="button" data-slide="next">
		<span class="glyphicon glyphicon-chevron-right"
		aria-hidden="true"></span> <span class="sr-only">Next</span>
	</a>
</div>
<div class="row" style="margin-top: 20px">
	<div class="col-md-3 col-xs-3 col-sm-3">
		<img src="${pageContext.request.contextPath}/img/3.png">
	</div>
	<div class="col-md-3 col-xs-3 col-sm-3">
		<img src="${pageContext.request.contextPath}/img/3.png">
	</div>
	<div class="col-md-3 col-xs-3 col-sm-3">
		<img src="${pageContext.request.contextPath}/img/3.png">
	</div>
	<div class="col-md-3 col-xs-3 col-sm-3">
		<img src="${pageContext.request.contextPath}/img/3.png">
	</div>
</div>
</body>
</html>