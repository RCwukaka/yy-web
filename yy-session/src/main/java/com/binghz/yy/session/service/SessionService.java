package com.binghz.yy.session.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binghz.yy.consts.common.CommonConstant;
import com.binghz.yy.entity.common.user.UserEntity;
import com.binghz.yy.session.dao.SessionDao;
import com.binghz.yy.session.entity.SessionEntity;
import com.binghz.yy.utils.UUIDUtils;

@Service
public class SessionService {
	@Autowired
	private SessionDao sessionDao;

	// 添加sesison
	public SessionEntity addSession(HttpServletRequest request, UserEntity userEntity) {
		SessionEntity sessionEntity = sessionDao.findByUsername(userEntity.getUserName());
		if (sessionEntity != null) {
			Date data = new Date();
			data.setMinutes(data.getMinutes() + 20);
			sessionEntity.setDieTime(data);
		} else {
			sessionEntity = new SessionEntity();
			Date data = new Date();
			data.setMinutes(data.getMinutes() + 20);
			sessionEntity.setDieTime(data);
			sessionEntity.setImgSrc(CommonConstant.USER_DEFAULT_IMG);
			sessionEntity.setSessionId(request.getSession().getId());
			sessionEntity.setUsername(userEntity.getUserName());
			sessionEntity.setNickname(userEntity.getNickname());
			sessionEntity.setToken(UUIDUtils.generateValue());
		}
		return sessionDao.save(sessionEntity);
	}
	
	public boolean isLogin(HttpServletRequest request,String username){
		SessionEntity sessionEntity = sessionDao.findByUsername(username);
		if (sessionEntity == null) {
			return false;
		}else{
			return true;
		}
	}
	
	public boolean isAlive(HttpServletRequest request,String username){
		SessionEntity sessionEntity = sessionDao.findByUsername(username);
		if (sessionEntity == null) {
			return false;
		} else {
			if (sessionEntity.getDieTime().after(new Date())) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	public boolean isValid(HttpServletRequest request,String username,String token){
		SessionEntity sessionEntity = sessionDao.findByUsernameAndToken(username,token);
		if (sessionEntity == null) {
			return false;
		} 
		return true;
	}
}
