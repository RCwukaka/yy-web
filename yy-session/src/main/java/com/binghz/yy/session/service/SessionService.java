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

	// 判断session
	public Map<String, Object> isLoginOrAlive(HttpServletRequest request,
			UserEntity userEntity) {
		Map<String, Object> map = new HashMap<String, Object>();
		SessionEntity sessionEntity = sessionDao.findByUsername(userEntity
				.getUserName());
		if (sessionEntity == null) {
			map.put("isLogin", false);
		} else {
			map.put("isLogin", true);
			if (sessionEntity.getDieTime().after(new Date())) {
				map.put("isAlive", true);
			} else {
				map.put("isAlive", false);
			}
		}
		return map;
	}
}
