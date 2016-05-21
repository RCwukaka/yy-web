package com.binghz.yy.dao.Job;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.binghz.yy.entity.common.job.JobInfoEntity;

public interface JobDao extends PagingAndSortingRepository<JobInfoEntity, Long>, JpaSpecificationExecutor<JobInfoEntity>{
	
	public List<JobInfoEntity> findByCompanyId(Long companyId);
}
