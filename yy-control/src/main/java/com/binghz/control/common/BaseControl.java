package com.binghz.control.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.binghz.yy.session.service.SessionService;

@Component
public class BaseControl {

	@Autowired
	private SessionService sessionService;

	public boolean isLogin(String username) {
		return sessionService.isLogin(username);
	}

	public boolean isAlive(String username) {
		return sessionService.isAlive(username);
	}
}
