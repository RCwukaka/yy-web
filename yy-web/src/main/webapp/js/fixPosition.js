var newsLength=0;//新闻框的数量 每个新闻框的高度163px;
var otop = 590;// news_navbar距离顶部距离
var cn_height;// 520加上贴片广告框的高度
var de = document.documentElement.clientHeight; // 初始打开浏览器时的js定位news_navbar的高度
var uptop ;//body页面高度
$.extend({
	navflo : function(dv, uptop, otop,load) {
		var ie6 = document.all;
		var st = Math.max(document.body.scrollTop
				|| document.documentElement.scrollTop);
		var p = uptop - st;// 判断是否到达content底部的数值 >0没到达，<0到达
		if (p < 0) {
			var h =$('#news_navbar').height();
			var h_con = $('#news').height();
			if(h<h_con){
				dv.css({
					'position' : 'fixed',
					top : p + 70
				});
			}else{
				dv.css({
					top : otop - st
				});
			}
			load.show();
		} else {
			load.hide();
			if (st >= otop - 70) {
				if (ie6) {
					dv.css({
						'position' : 'absolute',
						top : st
					});
				} else {
					dv.css({
						top : 70
					});
				}
			} else {
				dv.css({
					top : otop - st
				});
			}
		}
	},
	qryOrderCallBack:function(responseMsg){
		var datalist = responseMsg.dataMap.newsBriefList;
		var result = "";
		var length = datalist.length;
		for(var i=0;i<length;i++) {
			result += "<li><div class='newsImage'><img src='../../IMG/test.png'></div><div class='newsFont'><a href="+datalist[i].newsURL+" class='newsname'>";
			result += datalist[i].title;
			result += "</a><br><p style='opacity:0.4;'>作者 :";
			result += datalist[i].author;
			result += " 更新时间：";
			result += datalist[i].create_time+"</p><br><p style='color: #666666'>";
			result += datalist[i].briefContent +"</p></div></li>";
		}
		$("#newsList").append(result);
		return length;
	},
	fixSizeBug:function(){
		var h =$('#news_navbar').height();
		var h_con = $('#news').height();
		if(h>h_con){
			$('#content').height(h+520);
		}
	},
	showNews:function(page,pageSize,offset){
		var dataPage = {"page":page,"pageSize":pageSize,"offset":offset};
		$.ajax({  
	        type: "POST",  
	        url: "/RSMS/NewsOperation/newsBrief",  
	        data: JSON.stringify(dataPage),  
	        datatype: "json",  
	        contentType: "application/json",  
	        success: function(jsonResult) {  
	        	newsLength += $.qryOrderCallBack(jsonResult); 
	        	$('#content').height(newsLength*163+553);
	        	$.fixSizeBug();
	        	cn_height=newsLength*163+553;
	        	uptop = cn_height + 90 - de;
	        	$.navflo($('#news_navbar'), uptop, otop,$("#loadmore"));
	        }
	    });  
	}
});
$(function() {
	var dv = $('#news_navbar');
	var load = $("#loadmore");
	var page=1;
	var pageSize =9;
	dv.height(de - 90);
	dv.css({
		top : otop
	});
	$.fixSizeBug();
	load.click(function(){
		page++;
		$.showNews(page,pageSize,newsLength);
	});
	load.hide();
	$(window).resize(function() {
		de = document.documentElement.clientHeight;
		h = de - 90;
		dv.css({
			'height' : h
		});
		uptop = cn_height + 90 - de;
		$.navflo(dv, uptop, otop,load);
		$.fixSizeBug();
	});
	$(window).scroll(function(){
		$.navflo(dv, uptop, otop,load);
	});
	load.show();
	$("#nn_navbar_classify").click(function(){   //news_navbar里的div隐藏显现
		$("#classify").css("display","block"); 
		$("#report").css("display","none"); 
	});
	$("#nn_navbar_report").click(function(){
		$("#classify").css("display","none");
		$("#report").css("display","block");
	});
	$(".nn_navbar ul>li").click(function(){
		if($(this).attr("background-color")!="#fff"){
			$(".nn_navbar ul>li").css("background-color","#eaeaea");
			$(this).css("background-color", "#fff");
		}
	});
});