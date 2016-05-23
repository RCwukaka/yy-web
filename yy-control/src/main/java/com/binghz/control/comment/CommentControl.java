package com.binghz.control.comment;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.binghz.service.comment.CommentService;
import com.binghz.service.user.UserService;
import com.binghz.yy.consts.common.HttpState;
import com.binghz.yy.entity.common.comment.CommentEntity;
import com.binghz.yy.entity.common.user.UserEntity;
import com.binghz.yy.utils.JsonMessage;

@Controller
@RequestMapping("comment")
public class CommentControl {
	
	@Autowired
	private CommentService commentService;
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping("publish")
	public JsonMessage publish(String commentContent,String newsId,String userId){
		JsonMessage result = new JsonMessage();
		CommentEntity commentEntity = new CommentEntity();
		commentEntity.setCommentContent(commentContent);
		commentEntity.setNewsId(NumberUtils.toLong(newsId));
		commentEntity.setStatus(1);
		commentEntity.setUpdateDate(new Date());
		commentEntity.setUserId(NumberUtils.toLong(userId));
		commentEntity.setCreateDate(new Date());
		UserEntity userEntity =  userService.findOne(NumberUtils.toLong(userId));
		commentService.save(commentEntity);
		Map<String,String> map = new HashMap<String,String>();
		map.put("nickname", userEntity.getNickname());
		map.put("create_date", new Date().toString());
		map.put("commentcontent", commentContent);
		result.fill(HttpState.HTTP_CHANNEL_SUCCESS,
				HttpState.HTTP_CHANNEL_SUCCESS_STR,map);
		return result;
	}
	
	@ResponseBody
	@RequestMapping("changeStatus")
	public JsonMessage publish(String commentId,String status){
		JsonMessage result = new JsonMessage();
		CommentEntity commentEntity = commentService.findOne(NumberUtils.toLong(commentId));
		commentEntity.setStatus(NumberUtils.toInt(status));
		commentService.save(commentEntity);
		result.fill(HttpState.HTTP_CHANNEL_SUCCESS,
				HttpState.HTTP_CHANNEL_SUCCESS_STR);
		return result;
	}
}
