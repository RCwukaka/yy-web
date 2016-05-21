package com.binghz.service.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binghz.yy.dao.QueryDao;
import com.binghz.yy.dao.Job.JobDao;
import com.binghz.yy.entity.common.job.JobInfoEntity;

@Service
public class JobService {

	@Autowired
	private QueryDao queryDao;
	@Autowired
	private JobDao jobDao;

	public List<JobInfoEntity> findByCompanyId(Long companyId) {
		return jobDao.findByCompanyId(companyId);
	}

	// 更新工作信息
	public void update(String jobname, String jobrequire, String jobposition,
			Long jobId) {
		String sql = "update jobinfo set jobname=" + jobname + " and jobrequire="
				+ jobrequire + " and jobposition=" + jobposition + " where id="
				+ jobId;
		queryDao.update(sql);
	}

	// 下架工作
	public void downJob(Long jobId) {
		String sql = "update jobinfo set vaild=0 where id=" + jobId;
		queryDao.update(sql);
	}

	// 上架工作
	public void upJob(Long jobId){
		String sql = "update jobinfo set vaild=1 where id=" + jobId;
		queryDao.update(sql);
	}
	
	public JobInfoEntity save(JobInfoEntity job){
		return jobDao.save(job);
	}
	
	public void delete(Long jobId){
		String sql = "delete from jobinfo where id="+jobId;
		queryDao.update(sql);
	}
}
