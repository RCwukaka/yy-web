package com.binghz.control.user;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.binghz.control.common.BaseControl;
import com.binghz.service.job.JobResumeService;
import com.binghz.service.news.NewsService;
import com.binghz.service.resume.ResumeService;
import com.binghz.service.user.UserService;
import com.binghz.yy.entity.common.resume.ResumeEntity;
import com.binghz.yy.entity.common.user.UserEntity;
import com.binghz.yy.session.entity.SessionEntity;
import com.binghz.yy.session.service.SessionService;

@Controller
@RequestMapping("account")
public class UserAccountControl extends BaseControl{
	
	@Autowired
	private SessionService sessionService;
	@Autowired
	private UserService userService;
	@Autowired
	private NewsService newsService;
	@Autowired
	private JobResumeService jobResumeService;
	@Autowired
	private ResumeService resumeService;
	
	@ResponseBody
	@RequestMapping("info/{token}")
	public ModelAndView info(@PathVariable(value="token")String token) {
		ModelAndView mv =new ModelAndView();
		SessionEntity sessionEntity = sessionService.findByToken(token);
		if(sessionEntity==null){
			mv.setViewName("/custom/index");
		}
		mv.addObject("isLogin", isLogin(token));
		mv.addObject("isAlive", isAlive(token));
		mv.addObject("imgSrc", sessionEntity.getImgSrc());
		mv.addObject("token",token);
		mv.setViewName("/custom/account");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("base/{token}")
	public ModelAndView base(@PathVariable(value="token")String token) {
		ModelAndView mv =new ModelAndView();
		SessionEntity sessionEntity = sessionService.findByToken(token);
		if(sessionEntity==null){
			mv.setViewName("/custom/index");
		}
		UserEntity userEntity = userService.findByUserName(sessionEntity.getUsername());
		mv.addObject("imgSrc",userEntity.getImgSrc());
		mv.addObject("nickname",userEntity.getNickname());
		mv.addObject("username",userEntity.getUserName());
		mv.addObject("phone",userEntity.getPhone()==null?"":userEntity.getPhone());
		mv.addObject("introduce",userEntity.getIntroduce()==null?"":userEntity.getIntroduce());
		mv.addObject("token",token);
		mv.setViewName("/custom/account/base");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("deliverHistory/{token}")
	public ModelAndView deliverHistory(@PathVariable(value="token")String token) {
		ModelAndView mv =new ModelAndView();
		SessionEntity sessionEntity = sessionService.findByToken(token);
		UserEntity userEntity = userService.findByUserName(sessionEntity.getUsername());
		List<Map<String, Object>> maps = jobResumeService.deliverHistory(userEntity.getId());
		mv.addObject("lists",maps);
		mv.addObject("token",token);
		mv.setViewName("/custom/account/deliverHistory");
		return mv;
	}
	@ResponseBody
	@RequestMapping("article/{token}")
	public ModelAndView article(@PathVariable(value="token")String token) {
		ModelAndView mv =new ModelAndView();
		SessionEntity sessionEntity = sessionService.findByToken(token);
		UserEntity userEntity = userService.findByUserName(sessionEntity.getUsername());
		List<Map<String,Object>> lists = newsService.findNewsByAuthor(userEntity.getId());
		mv.addObject("lists",lists);
		mv.addObject("token",token);
		mv.setViewName("/custom/account/article");
		return mv;
	}
	@ResponseBody
	@RequestMapping("resume/{token}")
	public ModelAndView resume(@PathVariable(value="token")String token) {
		ModelAndView mv =new ModelAndView();
		SessionEntity sessionEntity = sessionService.findByToken(token);
		UserEntity userEntity = userService.findByUserName(sessionEntity.getUsername());
		ResumeEntity resumeEntity = resumeService.findByUserId(userEntity.getId());
		mv.setViewName("/custom/account/resume");
		if(resumeEntity==null){
			resumeEntity = resumeService.save(new ResumeEntity());
			mv.addObject("phone","");
			mv.addObject("introduce","");
			mv.addObject("skills","");
			mv.addObject("expectSalary","");
			mv.addObject("position","");
			mv.addObject("resumeurl","");
			mv.addObject("token","");
			mv.addObject("id",resumeEntity.getId());
			return mv;
		}
		mv.addObject("id",resumeEntity.getId());
		mv.addObject("phone",resumeEntity.getPhone());
		mv.addObject("introduce",resumeEntity.getIntroduce());
		mv.addObject("skills",resumeEntity.getSkills());
		mv.addObject("expectSalary",resumeEntity.getExpectSalary());
		mv.addObject("position",resumeEntity.getPosition());
		mv.addObject("resumeurl",resumeEntity.getResumeUrl());
		mv.addObject("token",token);
		return mv;
	}
}
