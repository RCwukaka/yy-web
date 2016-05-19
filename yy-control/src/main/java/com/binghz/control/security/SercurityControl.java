package com.binghz.control.security;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.binghz.control.common.BaseControl;
import com.binghz.yy.session.service.SessionService;
import com.binghz.yy.utils.VerificationCodeUtils;

@Controller
@RequestMapping("sercurity")
public class SercurityControl extends BaseControl {
	
	@Autowired
	private SessionService sessionService;

	@RequestMapping("securityCodeImage/{sessionId}")
	public void excute(HttpServletRequest request, HttpServletResponse response,@PathVariable(value = "sessionId") String sessionId) {
		VerificationCodeUtils verification = VerificationCodeUtils.Instance();
		String code = verification.getVerificationCodeValue();
		request.getSession().setAttribute("random", code);
		if(sessionService.findBySessionId(sessionId)!=null){
			sessionService.delSession(sessionId);
			sessionService.addSession(request);
		}else{
			sessionService.addSession(request);
		}
		ByteArrayInputStream inputStream = verification.getImage();
		byte[] data = new byte[2024];
		try {
			inputStream.read(data);
			response.setContentType("image/png");
			OutputStream stream = response.getOutputStream();
			stream.write(data);
			stream.flush();
			stream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
