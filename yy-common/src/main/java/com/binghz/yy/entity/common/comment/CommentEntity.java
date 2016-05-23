package com.binghz.yy.entity.common.comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.binghz.yy.entity.IdEntity;

@Entity
@Table(name = "comment")
public class CommentEntity extends IdEntity {
	@Column(name = "commentcontent")
	private String commentContent;
	@Column(name = "status")
	private Integer status;
	@Column(name="newsid")
	private Long newsId;
	@Column(name="userid")
	private Long userId;

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public int getStatus() {
		return status;
	}

	public Long getNewsId() {
		return newsId;
	}

	public void setNewsId(Long newsId) {
		this.newsId = newsId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
