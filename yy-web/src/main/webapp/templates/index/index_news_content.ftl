<#list newsList as list>
	<blockquote>
		<div class="media">
			<div class="media-left">
				<a href="#"> <img class="media-object img-thumbnail"
					src="${list.imgSrc}">
				</a>
			</div>
			<div class="media-body">
				<a href="${list.newsurl}" class='newsname'>${list.title}</a>
				<small><img src="/yy-web/img/test.png" width="25px"
					height="25px" class="img-circle"> fsa 时间:${list.update_date}</small>
				${list.briefcontent}
			</div>
		</div>
	</blockquote>
</#list>