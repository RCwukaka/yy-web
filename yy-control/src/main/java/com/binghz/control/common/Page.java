package com.binghz.control.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	@RequestMapping("index")
	public String index(){
		return "/custom/index";
	}
}
