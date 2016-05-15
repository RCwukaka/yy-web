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

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public int getStatus() {
		return status;
	}
}
