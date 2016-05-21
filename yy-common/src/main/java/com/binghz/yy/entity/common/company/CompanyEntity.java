package com.binghz.yy.entity.common.company;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.binghz.yy.entity.IdEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "company")
@JsonIgnoreProperties({"password"})
public class CompanyEntity extends IdEntity {

	@Column(name = "companyname")
	private String companyName;

	// 公司地址
	@Column(name = "companylocation")
	private String companyLocation;

	// 公司员工数量
	@Column(name = "companyemployernumber")
	private Long companyEmployerNumber;

	// 公司融资阶段
	@Column(name = "stage")
	private String stage;

	// 公司介绍
	@Column(name = "companyintroduce")
	private String companyIntroduce;
	
	@Column(name = "passsword")
	private String password;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyLocation() {
		return companyLocation;
	}

	public void setCompanyLocation(String companyLocation) {
		this.companyLocation = companyLocation;
	}

	public Long getCompanyEmployerNumber() {
		return companyEmployerNumber;
	}

	public void setCompanyEmployerNumber(Long companyEmployerNumber) {
		this.companyEmployerNumber = companyEmployerNumber;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getCompanyIntroduce() {
		return companyIntroduce;
	}

	public void setCompanyIntroduce(String companyIntroduce) {
		this.companyIntroduce = companyIntroduce;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
