package com.binghz.yy.entity.user;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.binghz.yy.entity.IdEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/*
 * 用户信息
 */
@Entity
@Table(name = "user")
@JsonIgnoreProperties({"password","create_date","update_date","vaild"})
public class UserEntity extends IdEntity {

	@Column(name = "username", nullable = false)
	private String userName;
	@Column(name = "password",nullable = false)
	private String password;
	@Column(name = "nickname", nullable = true)
	private String nickname;
	@Column(name="imgSrc",nullable=false)
	private String imgSrc;
	@Column(name="email",nullable=false)
	private String email;
	@Column(name="phone",nullable=false)
	private String phone;
	@Column(name="position",nullable=false)
	private String position;
	@Column(name="introduce",nullable=false)
	private String introduce;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
}
