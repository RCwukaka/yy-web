package com.binghz.yy.entity.right;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.binghz.yy.entity.IdEntity;

@Entity
@Table(name="right")
public class RightEntity extends IdEntity{
	@Column(name="right_name")
	private String rightName;
	@Column(name="decription")
	private String decription;
	@Column(name="status")
	private int status;
	
	public String getRightName() {
		return rightName;
	}
	public void setRightName(String rightName) {
		this.rightName = rightName;
	}
	public String getDecription() {
		return decription;
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}