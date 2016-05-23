package com.binghz.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binghz.yy.dao.QueryDao;
import com.binghz.yy.dao.admin.AdminDao;
import com.binghz.yy.entity.common.admin.AdminEntity;

@Service
public class AdminService {
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private QueryDao queryDao;
	
	public AdminEntity findOne(Long adminId) {
		return adminDao.findOne(adminId);
	}
	
	public AdminEntity findByAdminName(String adminName) {
		return adminDao.findByAdminName(adminName);
	}
	
}
