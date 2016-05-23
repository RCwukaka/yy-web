<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/basepage.css">
<script src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/uploadpreview.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/ajaxfileupload.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/upImg.js"></script>
<script type="text/javascript">
$(function(){
	$("#saveImg").click(function() {
		var formData = new FormData($('form')[0]);
		$(this).button('loading');
		var imgsrc = $("#userimg").attr("src");
		var timenow = new Date().getTime();
		$.ajaxFileUpload({
			url : '${pageContext.request.contextPath}/account/userImg/${token}',
			type : 'post',
			secureuri : false,
			fileElementId : 'img',
			dataType : 'application/json',
			success : function(data, status) {
				$("#userOnlineImg", window.parent.document).attr("src", imgsrc+"?d="+timenow);
				$("#saveImg").button('reset');
			},
			error : function(data, status, e) {
				alert(data.message);
				$("#saveImg").button('reset');
			}
		});
	});
	$("#saveInfo").click(function() {
		$(this).button('loading');
		$.ajax({
			type : "post",
			url : "${pageContext.request.contextPath}/account/save/${token}",
			data : {
				"nickname" : $("#nickname").val(),
				"phone" : $("#phone").val(),
				"introduce" : $("#introduce").val()
			},
			dataType : "json",
			success : function(message) {
				$('#saveInfo').button('reset');
			}
		});
	});
})
</script>
<style>
.bho {
	width: 100px;
	position: absolute;
	height: 100px;
	background: #000;
	filter: alpha(opacity : 50);
	opacity: 0.5;
	-moz-opacity: 0.5;
	overflow: hidden;
	left: 50%;
	margin-left: -50px;
	transition: opacity 0.2s ease-in-out;
	-moz-transition: -moz-opacity 0.2s ease-in-out;
	-webkit-transition: opacity 0.2s ease-in-out;
	-o-transition: opacity 0.2s ease-in-out;
	text-align: center;
	line-height: 100px;
	color: #FFF;
	vertical-align: middle;
}

.bho:hover {
	filter: alpha(opacity : 10);
	opacity: 0.1;
	background: #000;
	font-color: #000;
	-moz-opacity: 0.1;
	cursor: pointer;
}
</style>
<div class="tab-pane ">
<div style="display: none">
	<input name="img" type="file" id="img" />
</div>
<div class="row">
	<div class="col-md-4">
		<div style="margin: 0 auto; text-align: center">
			<div class="img-circle bho">更换头像</div> <img src="${imgSrc}" width="100px"
				height="100px" id="userimg" class="img-circle" style="margin-bottom:10px;"><br>
			<button type="button" class="btn btn-info btn-xs" id="saveImg"
				autocomplete="off" data-loading-text="Saving...">上传头像</button>
		</div>
	</div>
	<div class="col-md-8 ">
	<form class="form-horizontal">
		<div class="form-group">
			<label class="col-sm-2 control-label" for="nickname">昵称</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="nickname"
					placeholder="" value="${username}">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="phone">电话</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="phone"
					placeholder="" value="${phone}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="introduce">个人简介</label>
				<div class="col-sm-8">
					<textarea class="form-control" rows="4" id="introduce"
						placeholder="" >${introduce}</textarea>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-4 col-md-offset-2 ">
					<button type="button" class="btn btn-warning " id="saveInfo"
						autocomplete="off" data-loading-text="Saving...">保存</button>
				</div>
			</div>
		</form>
	</div>
</div>
</div>