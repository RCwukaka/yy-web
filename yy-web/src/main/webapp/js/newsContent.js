var newsId =0;
var userName = "test";
$.extend({
	showComment:function(comment){
    	var commentLength = comment.length;
    	var commentList = $("#commentList");
    	var result = "";
    	for(var i=0;i<commentLength;i++) {
    		result+="<li><div class='commentUsers'></div><div style='display:inline-block; width:732px;'><div style='line-height: 16px;'>";
    		result+=comment[i].nickname+"   时间:"+comment[i].create_time;
    		result+="</div><div class='commentContent'>"+comment[i].content;
    		result+="</div><div style='text-align: right;'><a href='#'>回复</a></div></div></li>";
    	}
    	commentList.append(result);
	}
});
$(document).ready(function(){
	var url = location.href;
	var parastr = url.split("_")[1]; //漏洞
	var data={'news_id':parastr};
	$.ajax({  
        type: "POST",  
        url: "/RSMS/NewsOperation/newsDetailInfo",  
        data: JSON.stringify(data),  
        datatype: "json",  
        contentType: "application/json",  
        success: function(jsonResult) { 
        	var data = jsonResult.dataMap;
        	newsId = data.id;
        	var inner_article = $("#inner_article");
        	var article_author = $("#article_author");
        	var article_content = $("#article_content");
        	article_author.append("<p style='display: inline-block;'>作者:"+data.author+"</p>");
        	article_author.append("<p style='display: inline-block;margin-left: 20px;'>更新时间:"+data.create_time+"</p>");
        	inner_article.prepend("<h2>"+data.title+"</h2>");
        	article_content.append(data.content);
        	$.showComment(data.comment);
        }
    });
	$("#sendComment").click(function(){
		var commentContent = $("#commentContent").val();
		var comment ={"commentContent":commentContent,"userName":userName,"newsId":newsId};
		$.ajax({  
	        type: "POST",  
	        url: "/RSMS/Comment/commentPublish",  
	        data: JSON.stringify(comment),  
	        datatype: "json",  
	        contentType: "application/json",  
	        success:function(data){
	        	$.showComment(data.dataMap.comment);
	        	$(".wangEditor-textarea").html("<p><br></p>"); 
        	}
        });
	});
});