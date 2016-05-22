package com.binghz.control.job;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.binghz.control.common.BaseControl;
import com.binghz.service.job.JobService;
import com.binghz.service.user.UserService;
import com.binghz.yy.consts.common.HttpState;
import com.binghz.yy.entity.common.job.JobInfoEntity;
import com.binghz.yy.entity.common.user.UserEntity;
import com.binghz.yy.session.entity.SessionEntity;
import com.binghz.yy.session.service.SessionService;
import com.binghz.yy.utils.JsonMessage;

@Controller
@RequestMapping("job")
public class JobControl extends BaseControl {

	@Autowired
	private JobService jobService;
	@Autowired
	private UserService userService;
	@Autowired
	private SessionService sessionService;

	@ResponseBody
	@RequestMapping("save/{companyId}")
	public JsonMessage save(String jobName, String jobRequire,
			String jobPosition, String salary,
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

	@ResponseBody
	@RequestMapping("index/{token}")
	public ModelAndView index(@PathVariable(value = "token") String token) {
		ModelAndView mv = new ModelAndView();
		SessionEntity sessionEntity = sessionService.findByToken(token);
		if (sessionEntity == null) {
			mv.setViewName("/custom/index");
		}
		mv.addObject("isLogin", isLogin(token));
		mv.addObject("isAlive", isAlive(token));
		mv.addObject("imgSrc", sessionEntity.getImgSrc());
		mv.addObject("token", token);
		mv.setViewName("/custom/job/recurit");
		return mv;
	}

	@ResponseBody
	@RequestMapping("index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/custom/job/recurit");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("findJob/{job}/{token}")
	public ModelAndView findJob(@PathVariable(value="job")String job,@PathVariable(value="token")String token){
		ModelAndView mv = new ModelAndView();
		try {
			job = new String(job.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Map<String,Object>> maps = jobService.find(job);
		SessionEntity sessionEntity = sessionService.findByToken(token);
		UserEntity userEntity = userService.findByUserName(sessionEntity.getUsername());
		mv.setViewName("/custom/job/jobinfo");
		if (sessionEntity == null) {
			mv.addObject("valid",false);
			return mv;
		}
		for(Map<String,Object> map:maps){
			if(map.get("salary").toString().equals("1")){
				map.put("salary", "1000-2000");
			}else if(map.get("salary").toString().equals("2")){
				map.put("salary", "2000-4000");
			}else if(map.get("salary").toString().equals("3")){
				map.put("salary", "4000-6000");
			}else if(map.get("salary").toString().equals("4")){
				map.put("salary", "6000-8000");
			}else if(map.get("salary").toString().equals("5")){
				map.put("salary", "8000-");
			}
		}
		mv.addObject("valid",true);
		mv.addObject("userId",userEntity.getId());
		mv.addObject("lists",maps);
		mv.addObject("token", token);
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("findJob/{job}")
	public ModelAndView findUnLoginJob(@PathVariable(value="job")String job){
		ModelAndView mv = new ModelAndView();
		List<Map<String,Object>> map = jobService.find(job);
		return mv;
	}
}
