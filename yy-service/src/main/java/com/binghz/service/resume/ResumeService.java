package com.binghz.service.resume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binghz.yy.dao.QueryDao;
import com.binghz.yy.dao.resume.ResumeDao;

@Service
public class ResumeService {
	@Autowired
	private ResumeDao resumeDao;
	
	@Autowired
	private QueryDao queryDao;
}
