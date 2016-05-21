package com.binghz.yy.dao.company;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.binghz.yy.entity.common.company.CompanyEntity;

public interface CompanyDao extends PagingAndSortingRepository<CompanyEntity, Long>, JpaSpecificationExecutor<CompanyEntity>{
	
	public CompanyEntity findByCompanyName(String companyName);
	
}
