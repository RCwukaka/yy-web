package com.binghz.yy.dao.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.binghz.yy.entity.common.user.UserEntity;

/*
 * 
 * 继承pagingAndSortingRespositry和jpaspecificationExecutor接口
 * spring data模块进行dao层的简约化开发
 * 
 * pageAndSortingResposity接口为了分页查询
 * jpaspecificationExecutor接口为了dao层的增删查改查询 是面向接口的编程
 */
public interface UserDao
		extends PagingAndSortingRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {
	
	List<UserEntity> findUserById(Long userId);
	
	UserEntity findByUserName(String userName);
	
	//查找多个用户
	UserEntity findByIdIn(List<Long> ids);
	
	//登录验证
	UserEntity findByUserNameAndPasswordAndVaild(String userName,String password,Integer vaild);
	
	//根据昵称获得用户
	List<UserEntity> findByNickname(String nickname);
	
}
