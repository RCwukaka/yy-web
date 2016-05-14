<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<div class="tab-pane fade in active" id="base">
	<div class="row">
		<div class="col-md-4">
			<div style="margin: 0 auto; text-align: center">
			<div class="img-circle bho">更换头像</div> <img src=<s:property value="imgSrc" /> width="100px"
				height="100px" id="userimg" class="img-circle" style="margin-bottom:10px;"><br>
			<button type="button" class="btn btn-info btn-xs" id="saveImg"
				autocomplete="off" data-loading-text="Saving...">上传头像</button>
		</div>
	</div>
	<div class="col-md-8 ">
		<form class="form-horizontal">
			<div class="form-group">
				<label class="col-sm-2 control-label" for="nickname">昵称</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="nickname"
						placeholder="" value="<s:property value="user.nickname"/>">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="email">邮箱</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="email"
						placeholder="" value=<s:property value="user.email"/>>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="phone">电话</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="phone"
						placeholder="" value=<s:property value="user.phone"/>>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="position">职业</label>
					<div class="col-sm-6">
						<select class="form-control" id="position">
							<option value='IT'>IT</option>
							<option value='finance'>金融</option>
							<option value="design">设计</option>
							<option value="civil">文职</option>
							<option value="operating">运营</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="company">才能</label>
					<div class="col-sm-6">
						<h4>
							<span class="label label-success">java</span>
							<span class="label label-danger">这里不会写，来个大神帮帮忙</span>
						</h4>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="introduce">个人简介</label>
					<div class="col-sm-10">
						<textarea class="form-control" rows="4" id="introduce"
							placeholder="" ><s:property value="user.introduce"/></textarea>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-4 col-md-offset-2 ">
						<button type="button" class="btn btn-warning " id="saveInfo"
							autocomplete="off" data-loading-text="Saving...">保存</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>