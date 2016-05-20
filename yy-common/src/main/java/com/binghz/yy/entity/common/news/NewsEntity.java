package com.binghz.yy.entity.common.news;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.binghz.yy.entity.IdEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name="news")
@JsonIgnoreProperties({"content"})
public class NewsEntity extends IdEntity{
	@Column(name="title")
	private String title;
	@Column(name="content")
	private String content;
	@Column(name="briefcontent")
	private String briefContent;
	@Column(name="classification")
	private Integer classification;
	@Column(name="status")
	private Integer status;
	@Column(name="newsurl")
	private String newsUrl;
	@Column(name="authorid")
	private Long authorid;
	@Column(name="newsimage")
	private String newsimage;
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getBriefContent() {
		return briefContent;
	}

	public void setBriefContent(String briefContent) {
		this.briefContent = briefContent;
	}

	public Integer getClassification() {
		return classification;
	}

	public void setClassification(Integer classification) {
		this.classification = classification;
	}

	public String getNewsUrl() {
		return newsUrl;
	}

	public void setNewsUrl(String newsUrl) {
		this.newsUrl = newsUrl;
	}

	public Long getAuthorid() {
		return authorid;
	}

	public void setAuthorid(Long authorid) {
		this.authorid = authorid;
	}

	public String getNewsimage() {
		return newsimage;
	}

	public void setNewsimage(String newsimage) {
		this.newsimage = newsimage;
	}
}
