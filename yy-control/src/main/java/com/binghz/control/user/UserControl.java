package com.binghz.control.user;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.binghz.service.user.UserService;
import com.binghz.yy.consts.common.CommonConstant;
import com.binghz.yy.consts.common.HttpState;
import com.binghz.yy.consts.user.UserConstant;
import com.binghz.yy.entity.common.user.UserEntity;
import com.binghz.yy.session.entity.SessionEntity;
import com.binghz.yy.session.service.SessionService;
import com.binghz.yy.utils.EncodeUtils;
import com.binghz.yy.utils.JsonMessage;
import com.binghz.yy.utils.JsonUtils;
import com.binghz.yy.utils.StringUtils;

@Controller
@RequestMapping("info")
public class UserControl {

	@Autowired
	private UserService userService;
	@Autowired
	private SessionService sessionService;

	@ModelAttribute
	public void initPath(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		model.addAttribute("code",
				Integer.valueOf(HttpState.HTTP_CHANNEL_SUCCESS));
		String host = request.getHeader("host");

	}

	@ResponseBody
	@RequestMapping("login")
	public ModelAndView loginIn(HttpServletRequest request, String username, String password) {
		ModelAndView mv = new ModelAndView();
		JsonMessage result = new JsonMessage();
		if (username == null || password == null 
				|| StringUtils.isBlank(username)
				|| StringUtils.isBlank(password)) {
			mv.setViewName("/custom/login");
			return mv;
		}
		UserEntity user = userService.findByUserName(username);
		if (StringUtils.equals(user.getPassword(),
				EncodeUtils.base64Md5(password))) {
			mv.setViewName("/custom/index");
			SessionEntity session = sessionService.addSession(request,user);
			Map<String ,Object> map = new HashMap<String ,Object>();
			map.put("isLogin",true);
			map.put("isAlive",true);
			map.put("userInfo", JsonUtils.objectToString(session));
			mv.addObject("map",map);
			mv.addObject(result.fill(HttpState.HTTP_CHANNEL_SUCCESS,
					HttpState.HTTP_CHANNEL_SUCCESS_STR));
			return mv;
		} else {
			mv.addObject(result.fill(HttpState.HTTP_USERNAMEPASSWD_ERROR,
					HttpState.HTTP_USERNAMEPASSWD_ERROR_STR));
			mv.setViewName("/custom/login");
			return mv;
		}
	}

	@RequestMapping("loginOut")
	public String loginOut() {
		
		return "/custom/index";
	}

	@ResponseBody
	@RequestMapping(value = { "register" }, method = { RequestMethod.GET })
	public ModelAndView register(HttpServletRequest request, String username,
			String password, String nickname) {
		ModelAndView mv = new ModelAndView();
		JsonMessage result = new JsonMessage();
		if (username == null || password == null || nickname == null
				|| StringUtils.isBlank(username)
				|| StringUtils.isBlank(nickname)
				|| StringUtils.isBlank(password)) {
			mv.setViewName("/custom/register");
			return mv;
		}
		UserEntity user = new UserEntity();
		password = password.trim();
		if (StringUtils.isBlank(password)) {
			mv.addObject(result.fill(HttpState.HTTP_PARAME_NORMAL,
					HttpState.HTTP_PARAME_NORMAL_STR)); // 参数错误
			mv.setViewName("/custom/register");
			return mv;
		}
		if (userService.isRepeat(username)) {
			mv.addObject(result.fill(UserConstant.USER_REGISTER_USERNAME,
					UserConstant.USER_REGISTER_USERNAME_STR)); // 账号已占用
			mv.setViewName("/custom/register");
			return mv;
		}
		user.setUserName(username);
		user.setValid(1);
		user.setCreateDate(new Date());
		user.setNickname(nickname);
		user.setPassword(EncodeUtils.base64Md5(password));
		user.setUpdateDate(new Date());
		user.setImgSrc(CommonConstant.USER_DEFAULT_IMG);
		SessionEntity session = sessionService.addSession(request,user);
		Map<String ,Object> map = new HashMap<String ,Object>();
		map.put("isLogin",true);
		map.put("isAlive",true);
		map.put("userInfo", JsonUtils.objectToString(session));
		mv.addObject("map",map);
		result.fill(HttpState.HTTP_CHANNEL_SUCCESS,
				HttpState.HTTP_CHANNEL_SUCCESS_STR);
		mv.addObject(result);
		mv.setViewName("/custom/index");
		return mv;
	}
}
