package com.binghz.control.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.binghz.control.common.BaseControl;
import com.binghz.service.job.JobService;
import com.binghz.service.user.UserService;
import com.binghz.yy.session.service.SessionService;

@Controller
@RequestMapping("job")
public class JobResumeControl extends BaseControl {

	@Autowired
	private JobService jobService;
	@Autowired
	private UserService userService;
	@Autowired
	private SessionService sessionService;

	
}
