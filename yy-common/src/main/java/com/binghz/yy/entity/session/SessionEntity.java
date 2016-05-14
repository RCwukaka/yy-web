package com.binghz.yy.entity.session;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.binghz.yy.entity.IdEntity;
@Entity
@Table(name="session")
public class SessionEntity extends IdEntity{
	private String sessionId;
	private String username;
	private String nickname;
	private String token;
	private String imgSrc;
	private Date dieTime;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getDieTime() {
		return dieTime;
	}

	public void setDieTime(Date dieTime) {
		this.dieTime = dieTime;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	
}
