package com.binghz.yy.dao.admin;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.binghz.yy.entity.common.admin.AdminEntity;

public interface AdminDao extends PagingAndSortingRepository<AdminEntity, Long>, JpaSpecificationExecutor<AdminEntity>{

	public AdminEntity findByAdminName(String adminName);
}
