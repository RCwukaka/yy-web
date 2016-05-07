package com.binghz.yy.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class IdEntity {

	@Id
	@Column(name = "id", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "create_date", nullable = false)
	private Date createDate;// 创建时间

	@Column(name = "update_date", nullable = false)
	private Date updateDate;// 更新时间

	@Column(name = "vaild")
	private Integer vaild;// 有效性

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getVaild() {
		return vaild;
	}

	public void setValid(Integer valid) {
		this.vaild = valid;
	}

}
