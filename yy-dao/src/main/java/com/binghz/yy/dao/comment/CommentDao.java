package com.binghz.yy.dao.comment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.binghz.yy.entity.common.comment.CommentEntity;

public interface CommentDao extends
		PagingAndSortingRepository<CommentEntity, Long>,
		JpaSpecificationExecutor<CommentEntity> {

	public List<CommentEntity> findByNewsIdAndStatus(Long newsId, Integer status);
	
	public List<CommentEntity> findByNewsId(Long newsId);

}
