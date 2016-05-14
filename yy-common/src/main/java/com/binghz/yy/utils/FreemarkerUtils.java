package com.binghz.yy.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreemarkerUtils {
	public static void createHTML(ServletContext context,
			Map<String, Object> data, String templatePath, String targetHtmlPath){
		String htmlPath = context.getRealPath("/html") + "/"
				+ targetHtmlPath;
		File htmlFile = new File(htmlPath);
		Configuration freemarkerCfg = new Configuration();
		// 加载模版
		freemarkerCfg.setServletContextForTemplateLoading(context, "/templates");
		freemarkerCfg.setEncoding(Locale.getDefault(), "UTF-8");
		try {
			// 指定模版路径
			Template template = freemarkerCfg
					.getTemplate(templatePath, "UTF-8");
			template.setEncoding("UTF-8");
			// 静态页面路径
			Writer out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(htmlFile), "UTF-8"));
			// 处理模版
			template.process(data, out);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/*
	 * 生成index页面左部导航框
	 */
	public static void createIndexNewsNavbar(ServletContext context,Map<String,Object> data){
		createHTML(context,data,"/index/index_news_navbar.ftl","/index/index_news_navbar.html");
	}
	/*
	 * 生成index页面贴片广告去的html
	 */
	public static void createIndexNewsImage(ServletContext context,Map<String,Object> data){
		createHTML(context,data,"/index/index_news_image.ftl","/index/index_news_image.html");
	}
	/*
	 * 生成index页面的新闻列表html文件
	 */
	public static void createIndexNewsContent(ServletContext context,Map<String,Object> data){
		createHTML(context,data,"/index/index_news_content.ftl","/index/index_news_content.html");
	}
	/*
	 * 生成新闻html
	 */
	public static void createNewsHtml(ServletContext context,Map<String,Object> data){
		createHTML(context,data,"/news/news.ftl","/news/news.html");
	}

}
