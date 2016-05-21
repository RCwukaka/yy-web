$(function(){
	 $(".userinfo").click(function(){
		  $(".userinfo").each(function(){
			  $(this).parent().removeClass("active");
		  });
		  $(this).parent().addClass("active");
	  })
	$("#img").uploadPreview({
		Img : "userimg"
	});
	$(".bho").click(function() {
		$("#img").click();
	});
	$("#saveImg").click(function() {
		var formData = new FormData($('form')[0]);
		$(this).button('loading');
		var imgsrc = $("#userimg").attr("src");
		$.ajaxFileUpload({
			url : '${pageContext.request.contextPath}/userInform/userImg',
			type : 'post',
			data : {
				"csrfToken" : '/>'
			},
			secureuri : false,
			fileElementId : 'img',
			dataType : 'application/json',
			success : function(data, status) {
				$("#userOnlineImg").attr("src", imgsrc);
				$("#saveImg").button('reset');
			},
			error : function(data, status, e) {
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
})