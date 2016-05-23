package com.binghz.yy.entity.common.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.binghz.yy.entity.IdEntity;

@Entity
@Table(name="admin")
public class AdminEntity extends IdEntity{
	
	@Column(name="adminname")
	private String adminName;
	@Column(name="password")
	private String password;
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
