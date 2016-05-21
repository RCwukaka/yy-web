package com.binghz.control.job;

import java.util.Date;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.binghz.service.job.JobService;
import com.binghz.yy.consts.common.HttpState;
import com.binghz.yy.entity.common.job.JobInfoEntity;
import com.binghz.yy.utils.JsonMessage;

@Controller
@RequestMapping("job")
public class JobControl {

	@Autowired
	private JobService jobService;

	@ResponseBody
	@RequestMapping("save/{companyId}")
	public JsonMessage save(String jobName, String jobRequire,
			String jobPosition,String salary,
			@PathVariable(value = "companyId") String companyId) {
		JobInfoEntity job = new JobInfoEntity();
		job.setJobName(jobName);
		job.setJobPosition(jobPosition);
		job.setJobRequire(jobRequire);
		job.setSalary(NumberUtils.toLong(salary));
		job.setUpdateDate(new Date());
		job.setCreateDate(new Date());
		job.setValid(1);
		job.setCompanyId(NumberUtils.toLong(companyId));
		jobService.save(job);
		JsonMessage result = new JsonMessage();
		result.fill(HttpState.HTTP_CHANNEL_SUCCESS,
				HttpState.HTTP_CHANNEL_SUCCESS_STR);
		return result;
	}

	@ResponseBody
	@RequestMapping("downJob/{jobId}")
	public JsonMessage downJob(@PathVariable(value = "jobId") String id) {
		JsonMessage result = new JsonMessage();
		jobService.downJob(NumberUtils.toLong(id));
		result.fill(HttpState.HTTP_CHANNEL_SUCCESS,
				HttpState.HTTP_CHANNEL_SUCCESS_STR);
		return result;
	}

	@ResponseBody
	@RequestMapping("upJob/{jobId}")
	public JsonMessage upJob(@PathVariable(value = "jobId") String id) {
		JsonMessage result = new JsonMessage();
		jobService.upJob(NumberUtils.toLong(id));
		result.fill(HttpState.HTTP_CHANNEL_SUCCESS,
				HttpState.HTTP_CHANNEL_SUCCESS_STR);
		return result;
	}

	@RequestMapping("update")
	public JsonMessage update(String jobname, String jobrequire,
			String jobposition, Long jobId) {
		JsonMessage result = new JsonMessage();
		jobService.update(jobname, jobrequire, jobposition, jobId);
		result.fill(HttpState.HTTP_CHANNEL_SUCCESS,
				HttpState.HTTP_CHANNEL_SUCCESS_STR);
		return result;
	}

	@ResponseBody
	@RequestMapping("delJob/{jobId}")
	public JsonMessage delJob(@PathVariable(value = "jobId") String jobId) {
		JsonMessage result = new JsonMessage();
		jobService.delete(NumberUtils.toLong(jobId));
		result.fill(HttpState.HTTP_CHANNEL_SUCCESS,
				HttpState.HTTP_CHANNEL_SUCCESS_STR);
		return result;
	}
}
