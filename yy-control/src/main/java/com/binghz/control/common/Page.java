package com.binghz.control.common;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.binghz.yy.consts.common.CommonConstant;

@Controller
public class Page {
	
	//登陆
	@RequestMapping("loginPage")
	public String loginPage(){
		return "/custom/login";
	}
	
	//注册
	@RequestMapping("registerPage")
	public String registerPage(){
		return "/custom/register";
	}
	
	//首页
	@ResponseBody
	@RequestMapping("index")
	public ModelAndView heh() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("ctx",CommonConstant.CSDN_MIRRO_LOCATION+"/news/index?v="+new Date().getTime());
		mv.setViewName("/custom/index");
		return mv;
	}
}
