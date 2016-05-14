<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/system-web/css/bootstrap.min.css">
<script src="/system-web/js/jquery-2.1.4.min.js"></script>
<script src="/system-web/js/bootstrap.min.js"></script>
<title>新闻操作</title>
</head>
<body>
	<ul class="nav nav-tabs" role="tablist">
		<li role="presentation" class="active"><a href="#home"
			aria-controls="home" role="tab" data-toggle="tab">未审查</a></li>
		<li role="presentation"><a href="#profile"
			aria-controls="profile" role="tab" data-toggle="tab">审查中</a></li>
		<li role="presentation"><a href="#profile"
			aria-controls="profile" role="tab" data-toggle="tab">驳回</a></li>
		<li role="presentation"><a href="#messages"
			aria-controls="messages" role="tab" data-toggle="tab">已发布</a></li>
	</ul>
	<div class="content">
		<table class="table table-condensed">
			<thead>
				<tr>
					<th>id</th>
					<th>标题</th>
					<th>作者</th>
					<th>生成时间</th>
					<th>所属公司</th>
					<th>审核</th>
				</tr>
			</thead>
			<s:iterator value="news" id="n">
				<tr>
					<td><s:property value="#n.id" /></td>
					<td><s:property value="#n.title" /></td>
					<td><s:property value="#n.author" /></td>
					<td><s:property value="#n.create_time" /></td>
					<td><s:property value="#n.company" /></td>
					<td><a href=<s:property value="#n.newsURL"/>>审核</a></td>
				</tr>
			</s:iterator>
		</table>
	</div>
	<ul class="pager">
		<li class="previous"><a href="#"><span aria-hidden="true">&larr;</span>上一页</a></li>
		<li class="next"><a href="#">下一页<span aria-hidden="true">&rarr;</span></a></li>
	</ul>
</body>
</html>