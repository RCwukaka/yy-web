package com.binghz.control.admin;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.binghz.service.admin.AdminService;
import com.binghz.service.comment.CommentService;
import com.binghz.service.news.NewsService;
import com.binghz.yy.consts.common.HttpState;
import com.binghz.yy.entity.common.admin.AdminEntity;
import com.binghz.yy.utils.EncodeUtils;
import com.binghz.yy.utils.JsonMessage;
import com.binghz.yy.utils.StringUtils;

@Controller
@RequestMapping("admin")
public class AdminControl {
	
	@Autowired
	private AdminService adminService;
	@Autowired
	private NewsService newsService;
	@Autowired
	private CommentService commentService;
	
	@ResponseBody
	@RequestMapping("login")
	public JsonMessage login(String adminName, String password) {
		JsonMessage result = new JsonMessage();
		if (adminName == null || password == null
				|| StringUtils.isBlank(adminName)
				|| StringUtils.isBlank(password)) {
			return result.fill(HttpState.HTTP_PARAME_NORMAL,
					HttpState.HTTP_PARAME_NORMAL_STR); // 参数错误
		}
		AdminEntity adminEntity = adminService
				.findByAdminName(adminName);
		if (StringUtils.equals(adminEntity.getPassword(),
				EncodeUtils.base64Md5(password))) {
			return result.fill(HttpState.HTTP_CHANNEL_SUCCESS,
					HttpState.HTTP_CHANNEL_SUCCESS_STR);
		} else {
			return result.fill(HttpState.HTTP_USERNAMEPASSWD_ERROR,
					HttpState.HTTP_USERNAMEPASSWD_ERROR_STR);
		}
	}
	
	@ResponseBody
	@RequestMapping("loginView")
	public ModelAndView loginView() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/adminer/login");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/adminer/index");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("news")
	public ModelAndView news() {
		ModelAndView mv = new ModelAndView();
		List<Map<String,Object>> map = newsService.findAll();
		mv.addObject("lists",map);
		mv.setViewName("/adminer/content/news");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("page")
	public ModelAndView page() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/adminer/content/pageInfo");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("newsPublish")
	public JsonMessage newsPublish(String id,String status) {
		JsonMessage result = new JsonMessage();
		newsService.updateStatus(NumberUtils.toLong(id), NumberUtils.toInt(status));
		return result.fill(HttpState.HTTP_CHANNEL_SUCCESS,
				HttpState.HTTP_CHANNEL_SUCCESS_STR);
	}
	
	@ResponseBody
	@RequestMapping("comment")
	public ModelAndView comment(){
		ModelAndView mv = new ModelAndView();
		List<Map<String,Object>> list = commentService.findAll();
		mv.addObject("lists",list);
		mv.setViewName("/adminer/content/comment");
		return mv;
	}
}
