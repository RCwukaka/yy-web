package com.binghz.yy.entity.common.jobSeeker;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.binghz.yy.entity.IdEntity;

/*
 * 求职者信息
 */
@Entity
@Table(name = "jobseeker")
public class JobSeekerEntity extends IdEntity {

	@Column(name = "seekername",nullable = false)
	private String jobSeekerName;

	@Column(name = "seekersex",nullable = false)
	private String jobSeekerSex;

	@Column(name = "seekergraduationschool",nullable = false)
	private String jobSeekerGraduationSchool;

	@Column(name = "seekereducation",nullable = false)
	private String jobSeekerEducation;

	@Column(name = "seekertel",nullable = false)
	private String jobSeekerTel;

	@Column(name = "seekeremail",nullable = false)
	private String jobSeekerEmail;

	@Column(name = "seekerresume",nullable = false)
	private String jobSeekerResume;

	public String getJobSeekerName() {
		return jobSeekerName;
	}

	public void setJobSeekerName(String jobSeekerName) {
		this.jobSeekerName = jobSeekerName;
	}

	public String getJobSeekerSex() {
		return jobSeekerSex;
	}

	public void setJobSeekerSex(String jobSeekerSex) {
		this.jobSeekerSex = jobSeekerSex;
	}

	public String getJobSeekerGraduationSchool() {
		return jobSeekerGraduationSchool;
	}

	public void setJobSeekerGraduationSchool(String jobSeekerGraduationSchool) {
		this.jobSeekerGraduationSchool = jobSeekerGraduationSchool;
	}

	public String getJobSeekerEducation() {
		return jobSeekerEducation;
	}

	public void setJobSeekerEducation(String jobSeekerEducation) {
		this.jobSeekerEducation = jobSeekerEducation;
	}

	public String getJobSeekerTel() {
		return jobSeekerTel;
	}

	public void setJobSeekerTel(String jobSeekerTel) {
		this.jobSeekerTel = jobSeekerTel;
	}

	public String getJobSeekerEmail() {
		return jobSeekerEmail;
	}

	public void setJobSeekerEmail(String jobSeekerEmail) {
		this.jobSeekerEmail = jobSeekerEmail;
	}

	public String getJobSeekerResume() {
		return jobSeekerResume;
	}

	public void setJobSeekerResume(String jobSeekerResume) {
		this.jobSeekerResume = jobSeekerResume;
	}

}
