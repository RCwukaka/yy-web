package com.binghz.yy.entity.user;

import java.util.HashSet;
import java.util.Set;

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
	@Column(name = "password")
	private String password;
	@Column(name = "userrealname", nullable = true)
	private String userRealName;
	@Column(name = "usersex", nullable = false)
	private String userSex;
	@Column(name = "useryear", nullable = false)
	private int userYear;
	@Column(name="nickname",nullable=false)
	private String nickname;

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

	public String getUserRealName() {
		return userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public int getUserYear() {
		return userYear;
	}

	public void setUserYear(int userYear) {
		this.userYear = userYear;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
