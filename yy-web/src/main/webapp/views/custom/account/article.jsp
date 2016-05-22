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
				<p>您还没有发表文章，点击下面按钮发表文章</p>
				<p>
					<a class="btn btn-primary btn-lg" href="" onclick="window.parent.location.href='${pageContext.request.contextPath}/new/newsCreateView/${token}'" role="button">创建文章</a>
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
          <th>文章标题</th>
          <th>创建时间</th>
          <th>发表状态</th>
          <th style="text-align:center">操作</th>
        </tr>
      </thead>
      <tbody>
      	<c:forEach var="article" items="${lists}">
	        <tr style="height:30px">
	          <th style="line-height:30px" scope="row">${article.title}</th>
	          <td style="line-height:30px">${article.create_date}</td>
	          <c:choose>
					<c:when test="${article.status=='0'}">
	        			<td style="line-height:30px">未审查</td>
        		    </c:when>
        		    <c:when test="${article.status=='1'}">
	        			<td style="line-height:30px">被驳回</td>
        		    </c:when>
        		    <c:otherwise>
        		    	<td style="line-height:30px">已发布</td>
        		    </c:otherwise>
       		  </c:choose>
	          <td style="text-align:center">
		          <button type="button"  class="del_btn btn btn-primary" jobid="${article.id}">删除</button>
	          </td>
	        </tr>
        </c:forEach>
      </tbody>
    </table>
    </div>
    </div>
</c:otherwise>
</c:choose>
</div>