<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/system-web/css/bootstrap.min.css">
<link rel="stylesheet" href="/system-web/css/basepage.css">
<script src="/system-web/js/jquery-2.1.4.min.js"></script>
<script src="/system-web/js/bootstrap.min.js"></script>
<script src="/system-web/js/uploadPreview.js"></script>
<script type="text/javascript" src="/system-web/js/ajaxfileupload.js"></script>
<title>个人主页</title>
</head>
<style>
.thumbnails li {
	list-style: none;
}

.bho {
	width: 100px;
	position:absolute;
	height: 100px;
	background: #000;
	filter: alpha(opacity : 50);
	opacity: 0.5;
	-moz-opacity: 0.5;
	overflow:hidden;
	left:50%;
	margin-left:-50px;
	transition:opacity 0.2s ease-in-out;
	-moz-transition:-moz-opacity 0.2s ease-in-out;
	-webkit-transition: opacity 0.2s ease-in-out;
	-o-transition: opacity 0.2s ease-in-out;
	text-align:center;
	line-height:100px;
	color:#FFF;
	vertical-align:middle;
}
.bho:hover{
	filter: alpha(opacity : 10);
	opacity: 0.1;
	background: #000;
	font-color:#000;
	-moz-opacity: 0.1;
	cursor:pointer;
}
</style>
<script type="text/javascript">
	$(function() {
		$("#img").uploadPreview({ Img: "userimg"});
		$(".bho").click(function() {
			$("#img").click();
		});
		$("#saveImg").click(function(){
			var formData = new FormData($('form')[0]);
			$(this).button('loading');
			var imgsrc = $("#userimg").attr("src");
			$.ajaxFileUpload({
	            url: '/system-web/userInform/userImg', 
	            type: 'post',
	            data:{"csrfToken":'<s:property value="token" />'},
	            secureuri: false, 
	            fileElementId: 'img', 
	            dataType: 'application/json',
	            success: function(data, status){  
	            	$("#userOnlineImg").attr("src",imgsrc);
	            	$("#saveImg").button('reset');
	            },
	            error: function(data, status, e){ 
	                alert(data.message);
	            	$("#saveImg").button('reset');
	            }
	        });
		});
		$(':file').change(function() {
			var file = this.files[0];
			var fileType = "image/jpeg|image/jpg|image/png";
			var imgType = fileType.split("|");
			var i;
			for (i = 0; i < imgType.length; i++) {
				if (imgType[i] == file.type) {
					return;
				} else {
					return;
				}
			}
		});
		$("#position").val('<s:property value="user.position"/>');
		$('#saveInfo').on('click', function() {
			$(this).button('loading');
			var email = $("#email").val();
			var nickname = $("#nickname").val();
			var phone = $("#phone").val();
			var position = $("#position").val();
			var introduce = $("#introduce").val();
			$.ajax({
				type : "post",
				url : "/system-web/userInform/userInfo",
				data : JSON.stringify({"csrfToken":'<s:property value="token" />',"email":email,"nickname":nickname,"phone":phone,"position":position,"ability":"java","introduce":introduce}),
				contentType : "application/json;charset=utf-8",
				dataType : "json",
				success : function(message) {
					$('#saveInfo').button('reset');
				}
			});
		});
	})
</script>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="content">
		<div style="display: none">
			<input name="img" type="file" id="img"/>
		</div>
		<div class="row">
			<div class="col-md-10 col-md-offset-1">
				<div id="showTab">
					<ul class="nav nav-tabs" role="tablist" id="myTabs">
						<script src="/system-web/js/accountpage.js"></script>
						<div style="display: none" id="token"><s:property value="token" /></div>
						<s:if test='page eq "base"'>
							<li class="active"><a href="#base" data-toggle="tab">基本信息</a></li>
						</s:if>
						<s:else>
							<li><a href="#base" data-toggle="tab">基本信息</a></li>
						</s:else>
						<s:if test='page eq "resume"'>
							<li class="active"><a href="#resume" data-toggle="tab">我的简历</a></li>
						</s:if>
						<s:else>
							<li><a href="#resume" data-toggle="tab">我的简历</a></li>
						</s:else>
						<s:if test='page eq "article"'>
							<li class="active"><a href="#article" data-toggle="tab">我的文章</a></li>
						</s:if>
						<s:else>
							<li><a href="#article" data-toggle="tab">我的文章</a></li>
						</s:else>
						<s:if test='page eq "company"'>
							<li class="active"><a href="#company" data-toggle="tab">关注的公司</a></li>
						</s:if>
						<s:else>
							<li><a href="#company" data-toggle="tab">关注的公司</a></li>
						</s:else>
						<s:if test='page eq "collects"'>
							<li class="active"><a href="#collects" data-toggle="tab">收藏的文章</a></li>
						</s:if>
						<s:else>
							<li><a href="#collects" data-toggle="tab">收藏的文章</a></li>
						</s:else>
					</ul>
					<div class="tab-content">
						<s:if test='page eq "base"'>
							<jsp:include page="account/base.jsp"></jsp:include>
						</s:if>
						<s:elseif test='page eq "resume"'>
							<jsp:include page="account/resume.jsp"></jsp:include>
						</s:elseif>
						<s:elseif test='page eq "article"'>
							<jsp:include page="account/article.jsp"></jsp:include>
						</s:elseif>
						<s:elseif test='page eq "company"'>
							<jsp:include page="account/company.jsp"></jsp:include>
						</s:elseif>
						<s:elseif test='page eq "collects"'>
							<jsp:include page="account/collects.jsp"></jsp:include>
						</s:elseif>
						<s:else>
							<jsp:include page="account/base.jsp"></jsp:include>
						</s:else>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/html/common/foot.html"></jsp:include>
</body>
</html>