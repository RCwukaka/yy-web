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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.binghz.control.common.BaseControl;
import com.binghz.service.user.UserService;
import com.binghz.yy.consts.common.CommonConstant;
import com.binghz.yy.consts.common.HttpState;
import com.binghz.yy.consts.user.UserConstant;
import com.binghz.yy.entity.common.user.UserEntity;
import com.binghz.yy.session.entity.SessionEntity;
import com.binghz.yy.session.service.SessionService;
import com.binghz.yy.utils.EncodeUtils;
import com.binghz.yy.utils.JsonMessage;
import com.binghz.yy.utils.StringUtils;

@Controller
public class UserControl extends BaseControl {

	@Autowired
	private UserService userService;
	@Autowired
	private SessionService sessionService;

	@ModelAttribute
	public void initPath(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		model.addAttribute("code",
				Integer.valueOf(HttpState.HTTP_CHANNEL_SUCCESS));

	}

	@ResponseBody
	@RequestMapping("login")
	public JsonMessage loginIn(HttpServletRequest request, String username,
			String password) {
		JsonMessage result = new JsonMessage();
		if (username == null || password == null
				|| StringUtils.isBlank(username)
				|| StringUtils.isBlank(password)) {
			return result.fill(HttpState.HTTP_PARAME_NORMAL,
					HttpState.HTTP_PARAME_NORMAL_STR); // 参数错误
		}
		UserEntity user = userService.findByUserName(username);
		if (StringUtils.equals(user.getPassword(),
				EncodeUtils.base64Md5(password))) {
			sessionService.addSession(request, user);
			Map<String, String> map = new HashMap<String, String>();
			map.put("usename", user.getUserName());
			return result.fill(HttpState.HTTP_CHANNEL_SUCCESS,
					HttpState.HTTP_CHANNEL_SUCCESS_STR, map);
		} else {
			return result.fill(HttpState.HTTP_USERNAMEPASSWD_ERROR,
					HttpState.HTTP_USERNAMEPASSWD_ERROR_STR);
		}
	}

	@ResponseBody
	@RequestMapping("loginOut/{username}")
	public JsonMessage loginOut(@PathVariable(value = "username") String username) {
		JsonMessage result = new JsonMessage();
		if (username == null ||StringUtils.isBlank(username)) {
			return result.fill(HttpState.HTTP_PARAME_NORMAL,
					HttpState.HTTP_PARAME_NORMAL_STR); // 参数错误
		}
		sessionService.delSessionByUsername(username);
		return result.fill(HttpState.HTTP_CHANNEL_SUCCESS,
				HttpState.HTTP_CHANNEL_SUCCESS_STR);
	}

	@ResponseBody
	@RequestMapping("register/{sessionId}")
	public JsonMessage register(HttpServletRequest request, String username,
			String password, String nickname, String securityCode,
			@PathVariable(value = "sessionId") String sessionId) {
		JsonMessage result = new JsonMessage();
		if (username == null || password == null || nickname == null
				|| StringUtils.isBlank(username)
				|| StringUtils.isBlank(nickname)
				|| StringUtils.isBlank(password)) {
			sessionService.delSession(sessionId);
			return result.fill(HttpState.HTTP_PARAME_NORMAL,
					HttpState.HTTP_PARAME_NORMAL_STR); // 参数错误
		}
		if (securityCode == null
				|| !securityCode.equals(sessionService
						.findBySessionId(sessionId).getToken())) {
			sessionService.delSession(sessionId);
			return result.fill(HttpState.HTTP_PARAME_NORMAL, "验证码错误"); // 参数错误
		}
		UserEntity user = new UserEntity();
		password = password.trim();
		if (StringUtils.isBlank(password)) {
			sessionService.delSession(sessionId);
			return result.fill(HttpState.HTTP_PARAME_NORMAL,
					HttpState.HTTP_PARAME_NORMAL_STR); // 参数错误
		}
		if (userService.isRepeat(username)) {
			sessionService.delSession(sessionId);
			return result.fill(UserConstant.USER_REGISTER_USERNAME,
					UserConstant.USER_REGISTER_USERNAME_STR); // 账号已占用
		}
		sessionService.delNoUseSession(sessionId,securityCode);
		user.setUserName(username);
		user.setValid(1);
		user.setCreateDate(new Date());
		user.setNickname(nickname);
		user.setPassword(EncodeUtils.base64Md5(password));
		user.setUpdateDate(new Date());
		user.setImgSrc(CommonConstant.USER_DEFAULT_IMG);
		sessionService.addSession(request, user);
		userService.save(user);
		return result.fill(HttpState.HTTP_CHANNEL_SUCCESS,
				HttpState.HTTP_CHANNEL_SUCCESS_STR);
	}

	@ResponseBody
	@RequestMapping("loginView")
	public ModelAndView loginPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/custom/login");
		return mv;
	}

	@ResponseBody
	@RequestMapping("registerView")
	public ModelAndView registerPage(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("sessionId", request.getSession().getId());
		mv.setViewName("/custom/register");
		return mv;
	}

	@ResponseBody
	@RequestMapping("index/{username}")
	public ModelAndView index(HttpServletRequest request,
			@PathVariable(value = "username") String username) {
		ModelAndView mv = new ModelAndView();
		if(username==null){
			mv.setViewName("/custom/index");
			return mv;
		}
		mv.addObject("isLogin", isLogin(username));
		mv.addObject("isAlive", isAlive(username));
		SessionEntity sessionEntity = sessionService.findByUsername(username);
		mv.addObject("imgSrc", sessionEntity.getImgSrc());
		mv.addObject("token", sessionEntity.getToken());
		mv.setViewName("/custom/index");
		return mv;
	}
	
}
