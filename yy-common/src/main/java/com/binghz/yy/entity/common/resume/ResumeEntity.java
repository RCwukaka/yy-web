package com.binghz.yy.entity.common.resume;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.binghz.yy.entity.IdEntity;

@Entity
@Table(name ="resume")
public class ResumeEntity extends IdEntity{
	
	@Column(name="userId")
	private Long userId;
	@Column(name="phone")
	private String phone;
	@Column(name="introduce")
	private String introduce;
	@Column(name="skills")
	private String skills;
	@Column(name="expectSalary")
	private String expectSalary;
	@Column(name="position")
	private String position;
	@Column(name="resumeurl")
	private String resumeUrl;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getExpectSalary() {
		return expectSalary;
	}
	public void setExpectSalary(String expectSalary) {
		this.expectSalary = expectSalary;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getResumeUrl() {
		return resumeUrl;
	}
	public void setResumeUrl(String resumeUrl) {
		this.resumeUrl = resumeUrl;
	}
}
