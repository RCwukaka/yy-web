package com.binghz.yy.entity.common.job;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.binghz.yy.entity.IdEntity;

/*
 * 工作职位信息
 * 
 */
@Entity
@Table(name="jobinfo")
public class JobInfoEntity extends IdEntity{
	
	@Column(name="jobname",nullable=false)
	private String jobName;
	
	@Column(name="jobrequire",nullable=false)
	private String jobRequire;
	
	@Column(name="jobposition",nullable=false)
	private String jobPosition;
	
	@Column(name="companyId")
	private Long companyId;
	
	@Column(name="salary")
	private Long salary;
	
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobRequire() {
		return jobRequire;
	}
	public void setJobRequire(String jobRequire) {
		this.jobRequire = jobRequire;
	}
	public String getJobPosition() {
		return jobPosition;
	}
	public void setJobPosition(String jobPosition) {
		this.jobPosition = jobPosition;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	
}
