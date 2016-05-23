package com.binghz.control.company;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.binghz.service.company.CompanyService;
import com.binghz.service.job.JobService;
import com.binghz.yy.consts.common.HttpState;
import com.binghz.yy.consts.company.CompanyConstant;
import com.binghz.yy.dao.QueryDao;
import com.binghz.yy.entity.common.company.CompanyEntity;
import com.binghz.yy.entity.common.job.JobInfoEntity;
import com.binghz.yy.utils.EncodeUtils;
import com.binghz.yy.utils.JsonMessage;
import com.binghz.yy.utils.StringUtils;

@Controller
@RequestMapping("company")
public class CompanyControl {

	@Autowired
	private CompanyService companyService;
	@Autowired
	private QueryDao queryDao;
	@Autowired
	private JobService jobService;

	@ResponseBody
	@RequestMapping("login")
	public JsonMessage login(String companyName, String password) {
		JsonMessage result = new JsonMessage();
		System.out.println(companyName + "  " + password);
		if (companyName == null || password == null
				|| StringUtils.isBlank(companyName)
				|| StringUtils.isBlank(password)) {
			return result.fill(HttpState.HTTP_PARAME_NORMAL,
					HttpState.HTTP_PARAME_NORMAL_STR); // 参数错误
		}
		CompanyEntity companyEntity = companyService
				.findByCompanyName(companyName);
		if (StringUtils.equals(companyEntity.getPassword(),
				EncodeUtils.base64Md5(password))) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("companyId", companyEntity.getId().toString());
			return result.fill(HttpState.HTTP_CHANNEL_SUCCESS,
					HttpState.HTTP_CHANNEL_SUCCESS_STR, map);
		} else {
			return result.fill(HttpState.HTTP_USERNAMEPASSWD_ERROR,
					HttpState.HTTP_USERNAMEPASSWD_ERROR_STR);
		}
	}

	@ResponseBody
	@RequestMapping("loginView")
	public ModelAndView loginView() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/company/login");
		return mv;
	}

	@ResponseBody
	@RequestMapping("register")
	public JsonMessage register(String companyName, String password) {
		JsonMessage result = new JsonMessage();
		CompanyEntity companyEntity = companyService
				.findByCompanyName(companyName);
		if (companyEntity != null) {
			return result.fill(CompanyConstant.COMPANY_NAME_REPEAT,
					CompanyConstant.COMPANY_NAME_REPEAT_STR);
		}
		companyEntity = new CompanyEntity();
		companyEntity.setCompanyName(companyName);
		companyEntity.setPassword(EncodeUtils.base64Md5(password));
		companyEntity.setCreateDate(new Date());
		companyEntity.setUpdateDate(new Date());
		CompanyEntity save = companyService.save(companyEntity);
		Map<String, String> map = new HashMap<String, String>();
		map.put("companyId", save.getId().toString());
		return result.fill(HttpState.HTTP_CHANNEL_SUCCESS,
				HttpState.HTTP_CHANNEL_SUCCESS_STR, map);
	}

	@ResponseBody
	@RequestMapping("index/{companyId}")
	public ModelAndView indexView(
			@PathVariable(value = "companyId") String companyId) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("companyId", companyId);
		mv.setViewName("/company/index");
		return mv;
	}

	@ResponseBody
	@RequestMapping("changeInfo")
	public JsonMessage changeInfo(
			@RequestParam("companyId") String companyId,
			@RequestParam("companylocation") String companylocation,
			@RequestParam("companyemployernumber") String companyemployernumber,
			@RequestParam("companyintroduce") String companyintroduce,
			@RequestParam("stage") String stage) {
		JsonMessage result = new JsonMessage();
		companyService.update(stage, companylocation, companyemployernumber,
				companyintroduce);
		result.fill(HttpState.HTTP_CHANNEL_SUCCESS,
				HttpState.HTTP_CHANNEL_SUCCESS_STR);
		return result;
	}

	@ResponseBody
	@RequestMapping("changeInfoView/{companyId}")
	public ModelAndView changeInfoView(
			@PathVariable(value = "companyId") String companyId) {
		ModelAndView mv = new ModelAndView();
		CompanyEntity companyEntity = companyService.findOne(NumberUtils
				.toLong(companyId));
		mv.addObject("companyname", companyEntity.getCompanyName());
		mv.addObject("stage", companyEntity.getStage());
		mv.addObject("companyintroduce", companyEntity.getCompanyIntroduce());
		mv.addObject("companylocation", companyEntity.getCompanyLocation());
		mv.addObject("companyId", companyId);
		mv.setViewName("/company/info");
		return mv;
	}

	@ResponseBody
	@RequestMapping("jobPublicView/{companyId}")
	public ModelAndView jobPublicView(
			@PathVariable(value = "companyId") String companyId) {
		ModelAndView mv = new ModelAndView();
		CompanyEntity companyEntity = companyService.findOne(NumberUtils
				.toLong(companyId));
		mv.addObject("companyId", companyEntity.getId());
		mv.setViewName("/company/jobPublic");
		return mv;
	}

	@RequestMapping("resumeChancel")
	public JsonMessage resumeChancel() {
		JsonMessage result = new JsonMessage();

		return result;
	}

	@RequestMapping("resumeChancelView/{companyId}")
	public ModelAndView resumeChancelView(
			@PathVariable(value = "companyId") String companyId) {
		ModelAndView mv = new ModelAndView();
		List<Map<String, Object>> lists = jobService.findByCompanyId(companyId);
		mv.addObject("lists",lists);
		mv.addObject("companyId", companyId);
		mv.setViewName("/company/resume");
		return mv;
	}

	@RequestMapping("jobDelView/{companyId}")
	public ModelAndView jobDelView(
			@PathVariable(value = "companyId") String companyId) {
		ModelAndView mv = new ModelAndView();
		CompanyEntity companyEntity = companyService.findOne(NumberUtils
				.toLong(companyId));
		List<JobInfoEntity> lists = jobService.findByCompanyId(companyEntity
				.getId());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("jobList", lists);
		mv.addObject("map", map);
		mv.addObject("companyId", companyId);
		mv.setViewName("/company/jobdel");
		return mv;
	}
}
