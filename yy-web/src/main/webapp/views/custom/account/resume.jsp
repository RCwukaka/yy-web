<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/basepage.css">
<script src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/uploadpreview.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/ajaxfileupload.js"></script>
<script type="text/javascript">
$(function(){
	$("#saveResume").click(function(){
		var phone=$("#phone").val();
		var introduce=$("#introduce").val();
		var skills=$("#skills").val();
		var expectSalary=$("#expectSalary").val();
		var position=$("#position").val();
		var id=${id};
		data={
			"phone":phone,
			"introduce":introduce,
			"skills":skills,
			"expectSalary":expectSalary,
			"position":position,
			"id":id
		};
		$.ajaxFileUpload({  
	        url:'${pageContext.request.contextPath}/resume/save/${token}',  
	        secureuri:false,  
	        fileElementId:'resume',//file标签的id  
	        dataType: 'json',//返回数据的类型  
	        data:data,//一同上传的数据  
	        success: function (data, status) {  
	            alert("success");
	        },  
	        error: function (data, status, e) {  
	            alert(e);  
	        }  
	    });  
	})
})
</script>
<br>
<div class="row">
	<div class="col-md-12">
		<form class="form-horizontal">
			<div class="form-group">
				<label class="col-sm-2 control-label" for="phone">电话</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="phone"
						placeholder="" value="${phone}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="expectSalary">期望薪资</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="email" placeholder=""
						value="${expectSalary}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="position">居住地点</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="position" placeholder=""
						value="${position}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="introduce">个人简介</label>
				<div class="col-sm-8">
					<textarea class="form-control" rows="4" id="introduce"
						placeholder="">${introduce}</textarea>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="skills">技能简介</label>
				<div class="col-sm-8">
					<textarea class="form-control" rows="4" id="skills"
						placeholder="">${skills}</textarea>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label"></label>
				<c:choose>
					<c:when test="${resumeurl==''}">
						<div class="col-sm-8">
							<input name="resume" type="file" id="resume" />
						</div>
						<div class="col-sm-4">
							<button type="button" class="btn btn-info" id="saveResume"
							autocomplete="off" data-loading-text="Saving...">上传简历</button>
							</div>
					</c:when>
					<c:otherwise>
						<div class="col-sm-8">
							<a href="${resumeurl}">附件简历</a>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="form-group">
				<div class="col-sm-4 col-md-offset-2 ">
					<button type="button" class="btn btn-info" id="saveResume"
							autocomplete="off" data-loading-text="Saving...">上传简历</button>
				</div>
			</div>
		</form>
	</div>
</div>