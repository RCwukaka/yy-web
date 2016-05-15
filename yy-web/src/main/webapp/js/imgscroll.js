/*
var speed=2000; //数字越大速度越慢
var tab=document.getElementById("activity");
var tab1=document.getElementById("demo1");
var tab2=document.getElementById("demo2");
tab2.innerHTML=tab1.innerHTML; 
function Marquee(){
if(tab2.offsetTop-tab.scrollTop<=0)//当滚动至demo1与demo2交界时
tab.scrollTop-=tab1.offsetHeight; //demo跳到最顶端
else{
tab.scrollTop=tab.scrollTop+210;
}
}
var MyMar=setInterval(Marquee,speed);
tab.onmouseover=function() {clearInterval(MyMar);};//鼠标移上时清除定时器达到滚动停止的目的
tab.onmouseout=function() {MyMar=setInterval(Marquee,speed);};//鼠标移开时重设定时器
*/

$(function() {
    var $banner = $('.banner_wrap li'),
        bannerLength = $banner.length,
        len = bannerLength;

    for (var i = 0; i < bannerLength; i++) {
        var img = new Image();
        var src = $banner.eq(i).data('src');

        img.src = src;
        img.index = i;
        img.onload = function(){
            $banner.eq(this.index).find('a').css('background-image','url('+this.src+')');
            len--;
            if (this.index==0) {
                banner({
                    banner : '.banner_wrap li',
                    pointer : '.control_ul li',
                    text : ".slide-info p"
                });
            }
        };
    }

    function banner(obj){
        var banner = $(obj.banner),
        num = banner.length,
        pointer =  $(obj.pointer),
        text = $(obj.text),
        zIndex = 2,
        index =0,
        interval;

        if (banner.length <= 1) return;

        reStart();

        pointer.hover(function(){
            clearInterval(interval);
            if( !$(this).hasClass("active") ) {
                index = $(this).index();
                show();
            }
        }, function(){
            interval = setInterval(function(){
                show();
            }, 4000);

        });

        function reStart(){
            clearInterval(interval);
            show();
            interval = setInterval(function(){
                show();
            }, 4000);
        }

        function show() {
            var _banner = banner.eq(index%num);
            if (!_banner.isTop()) {
                _banner.hide();
            }
            text.html(_banner.attr("title"));
            pointer.eq(index%num).addClass('active').siblings().removeClass('active');
            _banner.stop(true, true).css('z-index', zIndex).fadeIn(800);
            zIndex++;
            index++;
        }
    }
});

$.fn.isTop = function(){
    var maxzIndex = $(this).css('zIndex'),
        find = false;
    $(this).siblings().each(function(){
        if ($(this).css('zIndex') >= maxzIndex) {
            find = true;
            return false;
        }
    });
    return !find;
};//幻灯片轮播效果

$("#job_ul_hot").click(function(){
	$("#job_hot").css("display","block");
	$("#job_new").css("display","none");
	$("#job_ul_hot").css("background-color","#F5F3F3");
	$("#job_ul_new").css("background-color","silver");
});
$("#job_ul_new").click(function(){
	$("#job_hot").css("display","none");
	$("#job_new").css("display","block");
	$("#job_ul_hot").css("background-color","silver");
	$("#job_ul_new").css("background-color","#F5F3F3");
});
/*        */
function a(){
	$("#hide_menu1").css("display","block");
}
function a1(){
	$("#hide_menu1").css("display","none");
}
function b(){
	$("#hide_menu2").css("display","block");
}
function b1(){
	$("#hide_menu2").css("display","none");
}
function c(){
	$("#hide_menu3").css("display","block");
}
function c1(){
	$("#hide_menu3").css("display","none");
}
/*      */
$(document).ready(function(){
	var topbar=document.createElement("div");
	topbar.setAttribute("id","topbar");
	topbar.setAttribute("style", "display:none;position:fixed;left:96%;top:550px;width:40px;height:40px;background:url('../../IMG/iconfont-fanhuidingbu.png') no-repeat;font-size:15px;text-align:center;");
	document.body.appendChild(topbar);
    $("#topbar").click(function(){
    	$('html,body').animate({scrollTop:0},300);
    	});
	window.onscroll=function(){
		var top;
		if (document.documentElement && document.documentElement.scrollTop)
			top = document.documentElement.scrollTop;   
		else if (document.body) 
			top = document.body.scrollTop;
		if(top>0){
			topbar.style.display="block";
		}
            else{
            	topbar.style.display="none";
            }	
	};
	topbar.onmouseover=function(){
		this.innerHTML="返回顶部";
		this.style.background="blue";
		this.style.cursor="pointer";
	};
	topbar.onmouseout=function(){
		this.innerHTML="";
		$('#topbar').css("background","url('../../IMG/iconfont-fanhuidingbu.png')no-repeat");
	};
});
$(function() {  
    $(".imgboxbtm li").each(function(){
    	$(this).on("mouseenter mouseleave",function(e) {  
	        var w = $(this).width();  
	        var h = $(this).height();  
	        var x=(e.pageX-this.offsetLeft-(w/2))*(w>h?(h/w):1);  
	        var y=(e.pageY-this.offsetTop-(h/2))*(h>w?(w/h):1);  
	        var dirNum=Math.round((((Math.atan2(y,x)*(180/Math.PI))+180)/90)+3)%4;  
	        /*  
	            dirNum:0,1,2,3 ---> t r b l  
	            以上代码是网友分享  
	            以下代码是模仿拉勾网首页的一个小效果做的  
	        */  
	        var eventType = e.type;  
	        var aPos=[{left:0,top:-110},{left:250,top:0},{left:0,top:110},{left:-250,top:0}];  
	        if(eventType == 'mouseenter'){  
	            $(this).children(".slipping").css(aPos[dirNum]).stop(true,true).animate({left:0,top:0},200);  
	        }else{  
	        	$(this).children(".slipping").stop(true,true).animate(aPos[dirNum],200);  
	        }  
	    });
    });
});  