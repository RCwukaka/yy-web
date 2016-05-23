package com.binghz.yy.dao.Job;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.binghz.yy.entity.common.job.JobResumeEntity;

public interface JobResumeDao extends PagingAndSortingRepository<JobResumeEntity, Long>, JpaSpecificationExecutor<JobResumeEntity>{
	
	public List<JobResumeEntity> findByJobId(Long jobId);
	
	public List<JobResumeEntity> findByResumeId(Long resumeId);
	
	public List<JobResumeEntity> findByResumeIdAndJobId(Long resumeId,Long jobId);
}
