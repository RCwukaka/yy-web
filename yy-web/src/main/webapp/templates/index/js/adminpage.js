//管理界面各模块的显隐
var admin = 0;
function a(id) {
	{
		if (admin)
			admin.style.display = 'none';
		admin = document.getElementById(id);
		admin.style.display = 'block';
	}
}
 
// 从后台得到新闻输出到表格
$(document).ready(function() {
	$("#newstable").children('tbody').empty();
	$.ajax({
		url : "/system-web/admin/newsCheck",
		type : "POST",
		data : JSON.stringify({
			"page" : "1",
			"pageSize" : "5",
			"offset" : "0",
			"status" : "3"
		}),
		dataType : "json",
		contentType : "application/json",
		success : function(jsonResult) {
			var datalist = jsonResult.dataMap.newsBriefList;
			var tbody = "";
			var length = datalist.length;
			for (var i = 0; i < length; i++) {
				var tr = "<tr><td><input type='checkbox'></td>";
				tr += "<td>" + datalist[i].id + "</td>";
				tr += "<td>" + datalist[i].title + "</td>";
				tr += "<td>" + datalist[i].author + "</td>";
				tr += "<td>" + datalist[i].briefContent + "</td>";
				tr += "<td>" + datalist[i].create_time + "</td>";
				tr += "<td></td><td></td><td></td></tr>";
				tbody += tr;
			}
			$("#newstable").children('tbody').append(tbody);
			document.getElementById("list-page").innerHTML = length + "条1/1页";
		}
	});
});
// 新闻审核
var news_id = $("#newsid").text();
alert(news_id);
function publish() {
	$.ajax({
		type : "POST",
		url : "/system-web/admin/newsOperation",
		data : JSON.stringify({
			"newsId" : news_id,
			"newsState" : 3
		}),
		datatype : "json",
		contentType : "application/json",
		success : function(jsonResult) {
			alert("发布成功");
		}
	});
}

$(function() {
	$('#newsContent').wangEditor(
			{
				'menuConfig' : [
						[ 'bold', 'underline', 'italic', 'foreColor',
								'backgroundColor' ],
						[ 'blockquote', 'fontFamily', 'list', 'justify' ],
						[ 'createLink', 'unLink', 'insertTable' ],
						[ 'insertLocation' ], [ 'undo', 'redo' ] ]
			});
});