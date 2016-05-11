package com.binghz.control.user;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.binghz.service.user.UserService;
import com.binghz.yy.consts.common.HttpState;
import com.binghz.yy.entity.user.UserEntity;
import com.binghz.yy.utils.EncodeUtils;
import com.binghz.yy.utils.JsonMessage;
import com.binghz.yy.utils.JsonUtils;
import com.binghz.yy.utils.StringUtils;


@Controller
@RequestMapping("info" )
public class UserControl {
	
	@Autowired
	private UserService userService;

	@ModelAttribute
	public void initPath(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		model.addAttribute("code", Integer.valueOf(HttpState.HTTP_CHANNEL_SUCCESS));
		String host = request.getHeader("host");
		if (host.equals("localhost:8080")) {
			model.addAttribute("code", Integer.valueOf(HttpState.HTTP_CHANNEL_NORMAL));
		} else {
			model.addAttribute("code", Integer.valueOf(HttpState.HTTP_ABNORMAL));
		}
	}

	@RequestMapping("userLogin" )
	public ModelAndView loginIn(String userName, String password, int vaild) {
		ModelAndView mv = new ModelAndView();
		UserEntity user = this.userService.findByUserName(userName);
		if (StringUtils.equals(user.getPassword(), EncodeUtils.base64Md5(password))) {
			mv.addObject("user", user);
			mv.setViewName("/views/custom/welcome");
		} else {
			mv.addObject("state", "账号密码错误");
			mv.setViewName("/views/custom/login");
		}
		return mv;
	}

	@RequestMapping( "userLoginOut" )
	public String loginOut() {
		
		return "asda";
	}

	@RequestMapping(value = { "userRegister" }, method = { RequestMethod.GET })
	public String register(String userName, String password, String sex, String nickname, int year,
			String userrealname) {
		UserEntity user = new UserEntity();
		JsonMessage jsonUtil = new JsonMessage();
		password = password.trim();
		if (StringUtils.isBlank(password)) {
			return "";
		}
		user.setUserName(userName);
		user.setValid(1);
		user.setUserSex("M");
		user.setCreateDate(new Date());
		user.setNickname(nickname);
		user.setPassword(EncodeUtils.base64Md5(password));
		if (StringUtils.isNotBlank(userrealname)) {
			user.setUserRealName("张三");
		} else {
			user.setUserRealName(userrealname);
		}
		user.setUpdateDate(new Date());
		user.setUserYear(year);
		return JsonUtils.objectToString(this.userService.save(user));
	}
}
