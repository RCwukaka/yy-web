package com.binghz.yy.entity.right;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.binghz.yy.entity.IdEntity;
@Entity
@Table(name="role_right")
public class RightRole extends IdEntity{
	@Column(name="right_id")
	private Integer rightId;
	@Column(name="role_id")
	private Integer roleId;
	@Column(name="right_type")
	private Integer rightType;
	public Integer getRightId() {
		return rightId;
	}
	public void setRightId(Integer rightId) {
		this.rightId = rightId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getRightType() {
		return rightType;
	}
	public void setRightType(Integer rightType) {
		this.rightType = rightType;
	}

}
