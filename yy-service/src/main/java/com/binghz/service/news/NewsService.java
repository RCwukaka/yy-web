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
		String sql = "select * from news where status="+status+" order by create_date desc";
		List<Map<String,Object>> map = queryDao.queryMap(sql);
		return map;
	}
	/*
	 * 更新新闻信息
	 */
	public void update(NewsEntity news){
		String sql="update news set newsurl='"+news.getNewsUrl()+"' where id='"+news.getId()+"'";
		queryDao.update(sql);
	}
	/*
	 * 根据userId得到新闻
	 */
	public List<Map<String,Object>> findNewsByAuthor(Long authorId){
		String sql = "select * from news where authorid="+authorId;
		List<Map<String,Object>> map = queryDao.queryMap(sql);
		return map;
	}
}
