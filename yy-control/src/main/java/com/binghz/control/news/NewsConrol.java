package com.binghz.control.news;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.binghz.control.common.BaseControl;
import com.binghz.service.news.NewsService;
import com.binghz.service.user.UserService;
import com.binghz.yy.consts.common.CommonConstant;
import com.binghz.yy.consts.common.HttpState;
import com.binghz.yy.entity.common.news.NewsEntity;
import com.binghz.yy.entity.common.user.UserEntity;
import com.binghz.yy.session.entity.SessionEntity;
import com.binghz.yy.session.service.SessionService;
import com.binghz.yy.utils.CSDNUtils;
import com.binghz.yy.utils.FreemarkerUtils;
import com.binghz.yy.utils.JsonMessage;
import com.qiniu.common.QiniuException;

@Controller
@RequestMapping("news")
public class NewsConrol extends BaseControl {

	@Autowired
	private NewsService newsService;
	@Autowired
	private SessionService sessionService;
	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping("save/{token}")
	public JsonMessage saveNews(HttpServletRequest request,
			@PathVariable(value = "token") String token, String title,
			String content, String briefContent)
			throws UnsupportedEncodingException {
		System.out.println(briefContent + " " + title);
		JsonMessage result = new JsonMessage();
		if (token == null || title == null || content == null
				|| briefContent == null) {
			return result.fill(HttpState.HTTP_PARAME_NORMAL,
					HttpState.HTTP_PARAME_NORMAL_STR); // 参数错误
		}
		String contentUTF = URLEncoder.encode(content, "UTF-8");
		String briefContentUTF = URLEncoder.encode(briefContent, "UTF-8");
		String titleUTF = URLEncoder.encode(title, "UTF-8");
		SessionEntity sessionEntity = sessionService.findByToken(token);
		UserEntity userEntity = userService.findByUserName(sessionEntity
				.getUsername());
		NewsEntity newsEntity = new NewsEntity();
		newsEntity.setAuthorid(userEntity.getId());
		newsEntity.setBriefContent(briefContentUTF);
		newsEntity.setClassification(1);
		newsEntity.setCreateDate(new Date());
		newsEntity.setStatus(1); // /状态暂定为1
		newsEntity.setContent(contentUTF);
		newsEntity.setUpdateDate(new Date());
		newsEntity.setTitle(titleUTF);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("content", content);
		ServletContext servletContext = request.getSession()
				.getServletContext();
		NewsEntity newsCreate = newsService.save(newsEntity);
		File htmlFile = FreemarkerUtils.createNewsHtml(servletContext, map,
				newsCreate.getId().toString());
		newsCreate.setNewsUrl(CommonConstant.CSDN_MIRRO_LOCATION + "/news/"
				+ newsCreate.getId().toString());
		newsService.update(newsCreate);
		try {
			CSDNUtils.getFtpQiNiu().upFile(htmlFile,
					"news/" + newsCreate.getId().toString());
		} catch (QiniuException e) {
			e.printStackTrace();
		}
		return result.fill(HttpState.HTTP_CHANNEL_SUCCESS,
				HttpState.HTTP_CHANNEL_SUCCESS_STR);
	}

	@ResponseBody
	@RequestMapping("newsBrief")
	public JsonMessage newsBrief(Integer page) {
		JsonMessage result = new JsonMessage();
		List<Map<String, Object>> newsList = newsService.findNewsByStatus(1);
		result.fill(0, "", null, newsList);
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/newsCreateView")
	public ModelAndView newsCreateViews() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/custom/login");
		return mv;
	}

	@ResponseBody
	@RequestMapping("newsCreateView/{token}")
	public ModelAndView newsCreateView(
			@PathVariable(value = "token") String token) {
		ModelAndView mv = new ModelAndView();
		if (!isLogin(token) || !isLogin(token)) {
			mv.setViewName("/custom/login");
			return mv;
		}
		SessionEntity sessionEntity = sessionService.findByToken(token);
		mv.addObject("isLogin", isLogin(token));
		mv.addObject("isAlive", isAlive(token));
		mv.addObject("imgSrc", sessionEntity.getImgSrc());
		mv.setViewName("/custom/newsCreate");
		mv.addObject("token", token);
		return mv;
	}

	@ResponseBody
	@RequestMapping("info/{id}")
	public ModelAndView newsInfo(@PathVariable(value = "id") String id,
			String token) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/custom/news");
		mv.addObject("ctx", CommonConstant.CSDN_MIRRO_LOCATION + "/news/" + id);
		NewsEntity newsEntity = newsService.findById(NumberUtils.toLong(id));
		mv.addObject("title", newsEntity.getTitle());
		mv.addObject("id", newsEntity.getId());
		mv.addObject("date", newsEntity.getUpdateDate());
		UserEntity userEntity = userService.findOne(newsEntity.getAuthorid());
		mv.addObject("nickname", userEntity.getNickname());
		mv.addObject("articlenum", userEntity.getArticlenum());
		mv.addObject("introduce", userEntity.getIntroduce());
		if (token == null) {
			return mv;
		}
		SessionEntity sessionEntity = sessionService.findByToken(token);
		mv.addObject("isLogin", isLogin(token));
		mv.addObject("isAlive", isAlive(token));
		mv.addObject("token", token);
		mv.addObject("imgSrc", sessionEntity.getImgSrc());
		return mv;
	}

	@ResponseBody
	@RequestMapping("createIndexNews")
	public JsonMessage createIndexNews(HttpServletRequest request) {
		List<Map<String, Object>> newsList = newsService.findNewsByStatus(1);
		JsonMessage result = new JsonMessage();
		Map<String, Object> map = new HashMap<String, Object>();
		for (Map<String, Object> news : newsList) {
			UserEntity authorEntity = userService.findOne(NumberUtils
					.toLong(news.get("authorid").toString()));
			news.put("imgSrc", authorEntity.getImgSrc());
		}
		ServletContext servletContext = request.getSession()
				.getServletContext();
		map.put("newsList", newsList);
		map.put("ctx", servletContext.getContextPath());
		File file = FreemarkerUtils.createIndexNewsContent(servletContext, map);
		try {
			CSDNUtils.getFtpQiNiu().upFile(file, "news/index");
		} catch (QiniuException e) {
			e.printStackTrace();
		}
		return result.fill(HttpState.HTTP_CHANNEL_SUCCESS,
				HttpState.HTTP_CHANNEL_SUCCESS_STR);
	}
}
