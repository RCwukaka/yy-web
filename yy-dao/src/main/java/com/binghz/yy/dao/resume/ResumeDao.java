package com.binghz.yy.dao.resume;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.binghz.yy.entity.common.resume.ResumeEntity;

public interface ResumeDao extends PagingAndSortingRepository<ResumeEntity, Long>, JpaSpecificationExecutor<ResumeEntity>{
	
	public ResumeEntity findByUserId(Long userId);
}
