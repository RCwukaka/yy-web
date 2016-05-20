package com.binghz.yy.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreemarkerUtils {
	public static File createHTML(ServletContext context,
			Map<String, Object> data, String templatePath, String targetHtmlPath){
		String htmlPath = context.getRealPath("/html") + "/"
				+ targetHtmlPath;
		File htmlFile = new File(htmlPath);
		try {
			htmlFile.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
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
		return htmlFile;
	}
	
	public static File createHTMLIndex(ServletContext context,
			Map<String,Object> data, String templatePath, String targetHtmlPath){
		String htmlPath = context.getRealPath("/html") + "/"
				+ targetHtmlPath;
		File htmlFile = new File(htmlPath);
		try {
			htmlFile.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
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
		return htmlFile;
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
	public static File createIndexNewsContent(ServletContext context,Map<String,Object> data){
		return createHTMLIndex(context,data,"/index/index_news_content.ftl","/index/index_news_content.html");
	}
	/*
	 * 生成新闻html
	 */
	public static File createNewsHtml(ServletContext context,Map<String,Object> data,String pathName){
		return createHTML(context,data,"/news/news.ftl","/news/"+pathName+".html");
	}

}
