package com.binghz.yy.entity.role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.binghz.yy.entity.IdEntity;

@Entity
@Table(name = "role")
public class RoleEntity extends IdEntity {
	@Column(name = "role_name")
	private String roleName;
	@Column(name = "decription")
	private String decription;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}
}
