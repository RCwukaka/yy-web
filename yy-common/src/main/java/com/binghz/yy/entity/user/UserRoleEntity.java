package com.binghz.yy.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.binghz.yy.entity.IdEntity;

@Entity
@Table(name = "user_role")
public class UserRoleEntity extends IdEntity {
	@Column(name = "userId", nullable = false)
	private Long userId;
	@Column(name = "roleId", nullable = false)
	private Integer roleId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

}
