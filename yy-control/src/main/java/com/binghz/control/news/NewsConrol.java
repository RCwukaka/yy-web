package com.binghz.control.news;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.binghz.service.news.NewsService;
import com.binghz.service.user.UserService;
import com.binghz.yy.consts.common.HttpState;
import com.binghz.yy.entity.common.news.NewsEntity;
import com.binghz.yy.entity.common.user.UserEntity;
import com.binghz.yy.session.entity.SessionEntity;
import com.binghz.yy.session.service.SessionService;
import com.binghz.yy.utils.FreemarkerUtils;
import com.binghz.yy.utils.JsonMessage;

@Controller
@RequestMapping("news")
public class NewsConrol {

	@Autowired
	private NewsService newsService;
	@Autowired
	private SessionService sessionService;
	@Autowired
	private UserService userService;

	@RequestMapping("save/{token}")
	public JsonMessage saveNews(@PathVariable(value = "token") String token,
			String title, String content, String briefContent) {
		JsonMessage result = new JsonMessage();
		if (token == null || title == null
				|| content==null
				|| briefContent==null) {
			return result.fill(HttpState.HTTP_PARAME_NORMAL,
					HttpState.HTTP_PARAME_NORMAL_STR); // 参数错误
		}
		SessionEntity sessionEntity = sessionService.findByToken(token);
		UserEntity userEntity = userService.findByUserName(sessionEntity.getUsername());
		NewsEntity newsEntity = new NewsEntity();
		newsEntity.setAuthorid(userEntity.getId());
		newsEntity.setBriefContent(briefContent);
		newsEntity.setClassification(1);
		newsEntity.setCreateDate(new Date());
		newsEntity.setStatus(0);
		newsEntity.setContent(content);
		newsService.save(newsEntity);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("title", title);
		map.put("content", content);
		map.put("briefContent", briefContent);
		map.put("classification",1);
		map.put("username", userEntity.getUserName());
		map.put("nickname", userEntity.getNickname());
		map.put("date", new Date());
		List<Map<String,Object>> newsList = newsService.findNewsByStatus(1);
		WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();    
        ServletContext servletContext = webApplicationContext.getServletContext(); 
		FreemarkerUtils.createNewsHtml(servletContext,map);
		FreemarkerUtils.createIndexNewsContent(servletContext, newsList);
		return result.fill(HttpState.HTTP_CHANNEL_SUCCESS,
				HttpState.HTTP_CHANNEL_SUCCESS_STR);
	}
	
	@RequestMapping("newsBrief")
	public JsonMessage newsBrief(Integer page){
		JsonMessage result = new JsonMessage();
		List<Map<String,Object>> newsList = newsService.findNewsByStatus(1);
		result.fill(0, "", null,newsList);
		return result;
	}
}
