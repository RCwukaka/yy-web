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
	
	public void save(JobResumeEntity jobResumeEntity){
		jobResumeDao.save(jobResumeEntity);
	}
	
	public List<Map<String, Object>> deliverHistory(Long userId){
		String sql = "select job_resume.state,job_resume.create_date,jobinfo.jobname,company.companyname from jobinfo left join company on jobinfo.company_id=company.id left join job_resume on job_resume.jobid=jobinfo.id where jobinfo.id in (select job_resume.jobid from job_resume where job_resume.resumeid in (select id from resume where id="+userId+")) ";
		return queryDao.queryMap(sql);
	}
	
	public List<JobResumeEntity> findByResumeIdAndJobId(Long resumeId, Long jobId){
		return jobResumeDao.findByResumeIdAndJobId(resumeId,jobId);
	}
}
