package com.binghz.yy.entity.common.job;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.binghz.yy.entity.IdEntity;

@Entity
@Table(name="job_resume")
public class JobResumeEntity extends IdEntity{
	@Column(name="jobid")
	private Long jobId;
	@Column(name="resumeid")
	private Long resumeId;
	@Column(name="state")
	private Integer state;
	public Long getJobId() {
		return jobId;
	}
	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}
	public Long getResumeId() {
		return resumeId;
	}
	public void setResumeId(Long resumeId) {
		this.resumeId = resumeId;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
}
