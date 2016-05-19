package com.binghz.service.news;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binghz.yy.dao.QueryDao;
import com.binghz.yy.dao.news.NewsDao;
import com.binghz.yy.entity.common.news.NewsEntity;

@Service
public class NewsService {
	
	@Autowired
	private NewsDao newsDao;
	@Autowired
	private QueryDao queryDao;
	
	/*
	 * 
	 */
	public NewsEntity findById(Long id){
		return newsDao.findOne(id);
	};
	
	/*
	 * 保存新闻
	 */
	public NewsEntity save(NewsEntity newsEntity){
		return newsDao.save(newsEntity);
	}
	/*
	 * 返回对应状态的新闻
	 */
	public List<Map<String,Object>> findNewsByStatus(Integer status){
		String sql = "select from news where status="+status;
		List<Map<String,Object>> map = queryDao.queryMap(sql);
		return map;
	}
}
