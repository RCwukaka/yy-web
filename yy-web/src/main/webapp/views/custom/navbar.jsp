<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand">冰胡子资讯</a>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav" id="header">
				<li><a href="/system-web/index">资讯<span class="sr-only">(current)</span></a></li>
				<li><a href="/system-web/news">投稿</a></li>
				<li class="dropdown"><a href="/system-web/news" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">融资<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li class="hidden-sm hidden-md"><a href="/system-web/finance">我是投资人</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="/system-web/finance">寻求投资</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">招聘<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li class="hidden-sm hidden-md"><a href="/system-web/job">寻求职位</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">发布职位</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">活动<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li class="hidden-sm hidden-md"><a href="/system-web/activity">活动回顾</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="/system-web/activity">参加活动</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="/system-web/activity">举办活动</a></li>
					</ul></li>
			</ul>
			<s:if test="%{isLogin==false}">
				<ul class="nav navbar-nav navbar-right hidden-sm">
					<li><a href="/system-web/login">登陆/注册</a></li>
				</ul>
			</s:if>
			<s:elseif test="%{isAive==false}">
					<script type="text/javascript">
						alert("登陆失效，请重新登陆！");
					</script>
					</s:elseif>
				<s:else>
				<script type="text/javascript">
				<!-- 用户登陆后的处理-->
				$(function(){
					$(document).click(function(){
						$.get("/system-web/common/event", function(result){});
					})
				})
				</script>
				<ul class="nav navbar-nav navbar-right hidden-sm">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						style="padding-top: 8px; padding-bottom: 8px"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false"><img src=<s:property value="imgSrc" /> 
							class="img-circle" width="34x" height="34px" id="userOnlineImg"></a>
						<ul class="dropdown-menu">
							<li class="hidden-sm hidden-md"><a href='/system-web/account/<s:property value="token" />/base' data-click="info">基本信息</a></li>
							<li role="separator" class="divider"></li>
							<li><a href='/system-web/account/<s:property value="token" />/resume' data-click="resume" class="req">我的简历</a></li>
							<li role="separator" class="divider" ></li>
							<li><a href='/system-web/account/<s:property value="token" />/article' data-click="article" class="req">我的文章</a></li>
							<li role="separator" class="divider"></li>
							<li><a href='/system-web/account/<s:property value="token" />/company' data-click="company" class="req">关注的公司</a></li>
							<li role="separator" class="divider"></li>
							<li><a href='/system-web/account/<s:property value="token" />/collects' data-click="collects" class="req">收藏的文章</a></li>
							<li role="separator" class="divider"></li>
							<li><a href='/system-web/loginOut?csrfToken=<s:property value="token" />' data-click="loginout" id="req">退出</a></li>
						</ul></li>
				</ul>
			</s:else>
		</div>
	</div>
</nav>