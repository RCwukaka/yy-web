package com.binghz.yy.dao.resume;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.binghz.yy.entity.common.company.CompanyEntity;

public interface ResumeDao extends PagingAndSortingRepository<CompanyEntity, Long>, JpaSpecificationExecutor<CompanyEntity>{

}
