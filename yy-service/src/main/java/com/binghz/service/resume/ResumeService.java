package com.binghz.service.resume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binghz.yy.dao.QueryDao;
import com.binghz.yy.dao.resume.ResumeDao;
import com.binghz.yy.entity.common.resume.ResumeEntity;

@Service
public class ResumeService {
	@Autowired
	private ResumeDao resumeDao;
	@Autowired
	private QueryDao queryDao;
	
	public ResumeEntity save(ResumeEntity resumeEntity){
		return resumeDao.save(resumeEntity);
	}
	
	public ResumeEntity findByUserId(Long userId){
		return resumeDao.findByUserId(userId);
	}
	
	public void update(Long resumeId,String url){
		String sql = "update resume set resumeurl="+url+" where id="+resumeId;
		queryDao.update(sql);
	}
}
