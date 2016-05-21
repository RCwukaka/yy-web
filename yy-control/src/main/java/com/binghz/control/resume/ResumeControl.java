package com.binghz.control.resume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.binghz.service.resume.ResumeService;

@Controller
public class ResumeControl {
	
	@Autowired
	private ResumeService resumeService;
}
