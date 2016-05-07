package com.binghz.yy.entity.role;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.binghz.yy.entity.IdEntity;
import com.binghz.yy.entity.user.UserEntity;


/*
 * 角色信息
 */
@Entity
@Table(name = "role")
public class RoleEntity extends IdEntity {

	@Column(name = "rolename")
	private String roleName;
	
	@Column(name = "roledescription")
	private String roleDescription;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", joinColumns = {
			@JoinColumn(name = "roleid", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "userid", referencedColumnName = "id") })
	private Set<UserEntity> users = new HashSet<UserEntity>();

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

}