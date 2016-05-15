package com.binghz.yy.session.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.binghz.yy.session.entity.SessionEntity;

public interface SessionDao
		extends PagingAndSortingRepository<SessionEntity, Long>, JpaSpecificationExecutor<SessionEntity> {
	
	SessionEntity findByUsername(String username);
}
