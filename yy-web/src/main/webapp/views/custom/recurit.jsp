<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/system-web/css/bootstrap.min.css">
<link rel="stylesheet" href="/system-web/css/basepage.css">
<script src="/system-web/js/jquery-2.1.4.min.js"></script>
<script src="/system-web/js/bootstrap.min.js"></script>
<title>招聘</title>
</head>
<body>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="content">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-4">
					<div class="panel-group" id="accordion" role="tablist"
						aria-multiselectable="true">
						<div class="panel panel-default">
							<div class="panel-heading" role="tab" id="headingOne">
								<h4 class="panel-title">
									<a role="button" data-toggle="collapse"
										data-parent="#accordion" href="#collapseOne"
										aria-expanded="true" aria-controls="collapseOne"> IT后端开发</a>
								</h4>
							</div>
							<div id="collapseOne" class="panel-collapse collapse in"
								role="tabpanel" aria-labelledby="headingOne">
								<div class="panel-body">
									<ul class="target">
										<li class="success"><a href="#">JAVA</a></li>
										<li><a href="#">PHP</a></li>
										<li><a href="#">C</a></li>
										<li><a href="#">C++</a></li>
										<li class="success"><a href="#">Android</a></li>
										<li><a href="#">IOS</a></li>
										<li><a href="#">测试</a></li>
										<li class="success"><a href="#">nodejs</a></li>
										<li><a href="#">架构师</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading" role="tab" id="headingTwo">
								<h4 class="panel-title">
									<a class="collapsed" role="button" data-toggle="collapse"
										data-parent="#accordion" href="#collapseTwo"
										aria-expanded="false" aria-controls="collapseTwo"> IT前端开发</a>
								</h4>
							</div>
							<div id="collapseTwo" class="panel-collapse collapse"
								role="tabpanel" aria-labelledby="headingTwo">
								<div class="panel-body"></div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading" role="tab" id="headingThree">
								<h4 class="panel-title">
									<a class="collapsed" role="button" data-toggle="collapse"
										data-parent="#accordion" href="#collapseThree"
										aria-expanded="false" aria-controls="collapseThree">硬件类</a>
								</h4>
							</div>
							<div id="collapseThree" class="panel-collapse collapse"
								role="tabpanel" aria-labelledby="headingThree">
								<div class="panel-body"></div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading" role="tab" id="headingFour">
								<h4 class="panel-title">
									<a class="collapsed" role="button" data-toggle="collapse"
										data-parent="#accordion" href="#collapseFour"
										aria-expanded="false" aria-controls="collapseFour">产品类</a>
								</h4>
							</div>
							<div id="collapseFour" class="panel-collapse collapse"
								role="tabpanel" aria-labelledby="headingFour">
								<div class="panel-body"></div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading " role="tab" id="headingFive ">
								<h4 class="panel-title">
									<a class="collapsed" role="button" data-toggle="collapse"
										data-parent="#accordion" href="#collapseFive"
										aria-expanded="false" aria-controls="collapseFive">设计类</a>
								</h4>
							</div>
							<div id="collapseFive" class="panel-collapse collapse "
								role="tabpanel" aria-labelledby="headingFive">
								<div class="panel-body"></div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading" role="tab" id="headingSix">
								<h4 class="panel-title">
									<a class="collapsed" role="button" data-toggle="collapse"
										data-parent="#accordion" href="#collapseSix"
										aria-expanded="false" aria-controls="collapseSix">运营类</a>
								</h4>
							</div>
							<div id="collapseSix" class="panel-collapse collapse"
								role="tabpanel" aria-labelledby="headingSix">
								<div class="panel-body"></div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading" role="tab" id="headingSeven">
								<h4 class="panel-title">
									<a class="collapsed" role="button" data-toggle="collapse"
										data-parent="#accordion" href="#collapseSeven"
										aria-expanded="false" aria-controls="collapseSeven">市场营销类</a>
								</h4>
							</div>
							<div id="collapseSeven" class="panel-collapse collapse"
								role="tabpanel" aria-labelledby="headingSeven">
								<div class="panel-body"></div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading" role="tab" id="headingEight">
								<h4 class="panel-title">
									<a class="collapsed" role="button" data-toggle="collapse"
										data-parent="#accordion" href="#collapseEight"
										aria-expanded="false" aria-controls="collapseEight">金融类</a>
								</h4>
							</div>
							<div id="collapseEight" class="panel-collapse collapse"
								role="tabpanel" aria-labelledby="headingEight">
								<div class="panel-body"></div>
							</div>
						</div>
					</div>

				</div>
				<div class="col-md-8">
					<div class="input-group margin-b">
						<input type="text" class="form-control bg-success"
							placeholder="Search for..."> <span
							class="input-group-btn">
							<button class="btn btn-success" type="button">搜索职位</button>
						</span>
					</div>
					<div id="carousel-example-generic" class="carousel slide"
						data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#carousel-example-generic" data-slide-to="0"
								class="active"></li>
							<li data-target="#carousel-example-generic" data-slide-to="1"></li>
							<li data-target="#carousel-example-generic" data-slide-to="2"></li>
						</ol>

						<div class="carousel-inner" role="listbox">
							<div class="item active">
								<img src="/system-web/img/1.jpg">
								<div class="carousel-caption">
									<h3>棒球</h3>
									<p>棒球运动是一种以棒打球为主要特点，集体性、对抗性很强的球类运动项目，在美国、日本尤为盛行。</p>
								</div>
							</div>
							<div class="item">
								<img src="/system-web/img/2.jpg">
								<div class="carousel-caption">
									<h3>冲浪</h3>
									<p>冲浪是以海浪为动力，利用自身的高超技巧和平衡能力，搏击海浪的一项运动。运动员站立在冲浪板上，或利用腹板、跪板、充气的橡皮垫、划艇、皮艇等驾驭海浪的一项水上运动。</p>
								</div>
							</div>
							<div class="item">
								<img src="/system-web/img/3.jpg">
								<div class="carousel-caption">
									<h3>自行车</h3>
									<p>以自行车为工具比赛骑行速度的体育运动。1896年第一届奥林匹克运动会上被列为正式比赛项目。环法赛为最著名的世界自行车锦标赛。</p>
								</div>
							</div>
						</div>
						<a class="left carousel-control" href="#carousel-example-generic"
							role="button" data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
							<span class="sr-only">Previous</span>
						</a> <a class="right carousel-control"
							href="#carousel-example-generic" role="button" data-slide="next">
							<span class="glyphicon glyphicon-chevron-right"
							aria-hidden="true"></span> <span class="sr-only">Next</span>
						</a>
					</div>
					<div class="row" style="margin-top: 20px">
						<div class="col-md-3">
							<img src="/system-web/img/3.png">
						</div>
						<div class="col-md-3">
							<img src="/system-web/img/3.png">
						</div>
						<div class="col-md-3">
							<img src="/system-web/img/3.png">
						</div>
						<div class="col-md-3">
							<img src="/system-web/img/3.png">
						</div>
					</div>
					<ul class="nav nav-tabs " style="margin-top: 20px">
						<li class="active"><a href="#" class="text-success">最新职位</a></li>
						<li><a href="#" class="text-success">推荐职位</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<footer class="footer ">
	<div class="container">
		<div class="col-sm-9 col-lg-9">
			<div class="row about">
				<div class="col-xs-3">
					<h4>注意事项</h4>
					<ul class="list-unstyled">
						<li><a href="#">关于我们</a></li>
						<li><a href="#">加入我们</a></li>
						<li><a href="#">商务合作</a></li>
						<li><a href="#">联系我们</a></li>
					</ul>
				</div>
				<div class="col-xs-3">
					<h4>网站介绍</h4>
					<ul class="list-unstyled">
						<li><a href="#">投稿须知</a></li>
						<li><a href="#">加入我们</a></li>
						<li><a href="#">商务合作</a></li>
						<li><a href="#">寻求报道</a></li>
					</ul>
				</div>
				<div class="col-xs-3">
					<h4>联系我们</h4>
					<ul class="list-unstyled">
						<li><a href="#">官方热线：123431253</a></li>
						<li><a href="#">客服qq：1213134144</a></li>
						<li><a href="#">微信公众号：asfsanf</a></li>
					</ul>
				</div>
				<div class="col-xs-3">
					<h4>意见与建议</h4>
					<ul class="list-unstyled">
						<li><a href="#">意见与建议</a></li>
						<li><a href="#">email联系</a></li>
						<li><a href="#">网站信箱：123@163.com</a></li>
						<li><a href="#">版权建议：123@123.com</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="col-sm-3 col-lg-3">
			<h4>合作伙伴</h4>
			<img src="/system-web/img/aliyun.jpg"> <img src="/system-web/img/upyun.jpg">
		</div>
		<hr>
		<div class="row footer-bottom">
			<ul class="list-inline text-center">
				<li><a href="#">© 2013-2015 杭州冰胡子科技有限公司版权所有</a></li>
				<li><a href="#">工信部备案：京ICP备1234252号-1</a></li>
			</ul>
		</div>
	</div>
	</footer>
</body>
</html>