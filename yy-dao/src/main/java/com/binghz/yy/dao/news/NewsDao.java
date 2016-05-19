package com.binghz.yy.dao.news;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.binghz.yy.entity.common.news.NewsEntity;

public interface NewsDao extends PagingAndSortingRepository<NewsEntity, Long>, JpaSpecificationExecutor<NewsEntity>{
	
	public NewsEntity findByStatus(Integer status);
	
}
