package com.binghz.control.job;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.binghz.control.common.BaseControl;
import com.binghz.service.job.JobResumeService;
import com.binghz.service.resume.ResumeService;
import com.binghz.service.user.UserService;
import com.binghz.yy.consts.common.HttpState;
import com.binghz.yy.entity.common.job.JobResumeEntity;
import com.binghz.yy.session.service.SessionService;
import com.binghz.yy.utils.JsonMessage;

@Controller
@RequestMapping("jobresume")
public class JobResumeControl extends BaseControl {

	@Autowired
	private UserService userService;
	@Autowired
	private SessionService sessionService;
	@Autowired
	private JobResumeService jobResumeService;
	@Autowired
	private ResumeService resumeService;
	
	@ResponseBody
	@RequestMapping("save/{token}")
	public JsonMessage save(@PathVariable(value="token")String token,String jobId,String resumeId){
		JsonMessage result = new JsonMessage();
		JobResumeEntity jobResumeEntity = new JobResumeEntity();
		jobResumeEntity.setCreateDate(new Date());
		jobResumeEntity.setJobId(NumberUtils.toLong(jobId));
		jobResumeEntity.setUpdateDate(new Date());
		jobResumeEntity.setState(0);
		jobResumeEntity.setResumeId(NumberUtils.toLong(resumeId));
		List<JobResumeEntity> list = jobResumeService.findByResumeIdAndJobId(NumberUtils.toLong(resumeId), NumberUtils.toLong(jobId));
		if(list.size()!=0){
			return result.fill(-1,"已经投递过");
		}
		jobResumeService.save(jobResumeEntity);
		result.fill(HttpState.HTTP_CHANNEL_SUCCESS,
				HttpState.HTTP_CHANNEL_SUCCESS_STR);
		return result;
	}
	
	@ResponseBody
	@RequestMapping("findByJobId")
	public JsonMessage findByJobId(String jobId,String resumeId){
		JsonMessage result = new JsonMessage();
		result.fill(HttpState.HTTP_CHANNEL_SUCCESS,
				HttpState.HTTP_CHANNEL_SUCCESS_STR);
		return result;
	}
	
	@ResponseBody
	@RequestMapping("updateState")
	public JsonMessage updateState(String jobId,String resumeId,String state){
		JsonMessage result = new JsonMessage();
		 List<JobResumeEntity> list = jobResumeService.findByResumeIdAndJobId(NumberUtils.toLong(resumeId), NumberUtils.toLong(jobId));
		 JobResumeEntity jobResumeEntity = list.get(0);
		 jobResumeEntity.setState(NumberUtils.toInt(state));
		 jobResumeService.save(jobResumeEntity);
		result.fill(HttpState.HTTP_CHANNEL_SUCCESS,
				HttpState.HTTP_CHANNEL_SUCCESS_STR);
		return result;
	}
	
}
