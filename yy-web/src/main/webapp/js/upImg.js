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