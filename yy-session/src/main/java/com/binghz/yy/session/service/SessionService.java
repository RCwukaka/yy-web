package com.binghz.yy.session.service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binghz.yy.consts.common.CommonConstant;
import com.binghz.yy.entity.common.user.UserEntity;
import com.binghz.yy.session.dao.SessionDao;
import com.binghz.yy.session.entity.SessionEntity;
import com.binghz.yy.utils.UUIDUtils;
import com.binghz.yy.dao.QueryDao;

@Service
public class SessionService {
	@Autowired
	private SessionDao sessionDao;
	@Autowired
	private QueryDao queryDao;

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
	//存储验证码
	public SessionEntity addSession(HttpServletRequest request){
		SessionEntity sessionEntity = new SessionEntity();
		sessionEntity.setSessionId(request.getSession().getId());
		sessionEntity.setToken(request.getSession().getAttribute("random").toString());
		sessionDao.save(sessionEntity);
		return sessionEntity;
	}
	
	public void delSession(String sessionid){
		String sql = "delete from session.redis where sessionid='"+sessionid+"'";
		queryDao.update(sql);
	}
	
	public void delNoUseSession(String sessionId ,String token){
		String sql = "delete from session.redis where sessionid='"+sessionId+"' and token='"+token+"'";
		queryDao.update(sql);
	}
	
	public void delSessionByUsername(String username){
		String sql = "delete from session.redis where username='"+username+"'";
		queryDao.update(sql);
	}
	
	public boolean isLogin(String username){
		SessionEntity sessionEntity = sessionDao.findByUsername(username);
		if (sessionEntity == null) {
			return false;
		}else{
			return true;
		}
	}
	
	public boolean isAlive(String username){
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
	
	public boolean isValid(String username,String token){
		SessionEntity sessionEntity = sessionDao.findByUsernameAndToken(username,token);
		if (sessionEntity == null) {
			return false;
		} 
		return true;
	}
	
	public SessionEntity findByUsername(String username){
		return sessionDao.findByUsername(username);
	}
	
	public SessionEntity findBySessionId(String sessionId){
		return sessionDao.findBySessionId(sessionId);
	}
}
