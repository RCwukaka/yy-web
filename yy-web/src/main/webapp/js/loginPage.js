function changeValidateCode(obj) {
	var timenow = new Date().getTime();
	obj.src = "/RSMS/Sercurity/SecurityCodeImageAction?d=" + timenow;
}
$(document).ready(function() {
	$("#btnLogin").click(function() {
		var username = $("#username").val();
		var password = $("#password").val();
		var chk=document.getElementById('rememberPas');
		var value=chk.checked;
		var obj = {"username":username,"password":password,"rememberPas":value};
		$.ajax({
			type : "post",
			url : "/RSMS/UserInform/login",
			data :JSON.stringify(obj),
			contentType : "application/json;charset=utf-8",
			dataType : "json",
			success : function(message){
				alert(message.dataMap.info);
				if(message.dataMap.status ==200){
				}
			}
		});
	});
});

