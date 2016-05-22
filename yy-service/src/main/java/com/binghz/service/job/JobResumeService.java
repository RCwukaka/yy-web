package com.binghz.service.job;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binghz.yy.dao.QueryDao;
import com.binghz.yy.dao.Job.JobResumeDao;
import com.binghz.yy.entity.common.job.JobInfoEntity;
import com.binghz.yy.entity.common.job.JobResumeEntity;

@Service
public class JobResumeService {

	@Autowired
	private QueryDao queryDao;
	@Autowired
	private JobResumeDao jobResumeDao;

	public List<JobResumeEntity> findByJobId(Long jobId) {
		return jobResumeDao.findByJobId(jobId);
	}

	public List<JobResumeEntity> findByResumeId(Long resumeId) {
		return jobResumeDao.findByResumeId(resumeId);
	}
}
