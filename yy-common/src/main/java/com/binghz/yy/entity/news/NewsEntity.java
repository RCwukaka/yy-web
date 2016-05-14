package com.binghz.yy.entity.news;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.binghz.yy.entity.IdEntity;
@Entity
@Table(name="news")
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
	
}
