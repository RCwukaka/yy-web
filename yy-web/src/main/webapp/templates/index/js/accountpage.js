$(function() {
	$('a[data-toggle="tab"]').click(
		function() {
			var token = $("#token").text();
			window.location.href = "/system-web/account/" + token + "/"
					+ $(this).attr('href').split("#")[1];
	});
})