package com.binghz.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.binghz.yy.dao.user.UserDao;
import com.binghz.yy.entity.common.user.UserEntity;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public UserEntity findByUserName(String userName) {
		UserEntity user = userDao.findByUserName(userName);
		return user;
	}

	public UserEntity findByUserNameAndPassword(String userName, String password) {
		UserEntity user = userDao.findByUserNameAndPasswordAndVaild(userName,
				password, 1);
		return user;
	}

	public UserEntity save(UserEntity user) {
		return userDao.save(user);
	}

	public UserEntity findByNickname(String nickname) {
		List<UserEntity> list = userDao.findByNickname(nickname);
		if (!CollectionUtils.isEmpty(list)) {
			return list.get(0);
		}
		return null;
	}

	public boolean isRepeat(String username) {
		return this.findByUserName(username) == null ? false : true;
	}

	public UserEntity findOne(Long id){
		return userDao.findOne(id);
	}
}
