<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fun"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/basepage.css">
<script src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<div class="tab-pane fade in active">
<c:choose>
<c:when test="${fun:length(lists) <= 0}">
     <div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h1>没有记录</h1>
				<p>您还没有投递职位，赶快寻找心仪的工作</p>
				<p>
					<a class="btn btn-primary btn-lg" href="" onclick="window.parent.location.href='${pageContext.request.contextPath}/job/index/${token}'" role="button">招聘首页</a>
				</p>
			</div>
		</div>
	</div>
</c:when>
<c:otherwise>
 <div class="row">
<div class="col-md-12">
<table class="table table-hover">
  <thead>
        <tr>
          <th>投递时间</th>
          <th>投递职位</th>
          <th>投递公司</th>
          <th>简历状态</th>
        </tr>
      </thead>
      <tbody>
      	<c:forEach var="resume" items="${lists}">
	        <tr style="height:30px">
	          <th style="line-height:30px" scope="row">${resume.create_date}</th>
	          <th style="line-height:30px" scope="row">${resume.jobname}</th>
	          <td style="line-height:30px">${resume.companyname}</td>
	          <c:choose>
					<c:when test="${resume.state=='0'}">
	        			<td style="line-height:30px">未查看</td>
        		    </c:when>
        		    <c:when test="${resume.state=='1'}">
	        			<td style="line-height:30px">通知面试</td>
        		    </c:when>
        		    <c:otherwise>
        		    	<td style="line-height:30px">已拒绝</td>
        		    </c:otherwise>
       		  </c:choose>
	        </tr>
        </c:forEach>
      </tbody>
    </table>
    </div>
    </div>
</c:otherwise>
</c:choose>
</div>