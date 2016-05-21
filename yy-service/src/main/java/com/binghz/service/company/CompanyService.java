package com.binghz.service.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binghz.yy.dao.QueryDao;
import com.binghz.yy.dao.company.CompanyDao;
import com.binghz.yy.entity.common.company.CompanyEntity;

@Service
public class CompanyService {

	@Autowired
	private CompanyDao companyDao;
	@Autowired
	private QueryDao queryDao;

	public CompanyEntity findByCompanyName(String companyName) {
		return companyDao.findByCompanyName(companyName);
	}

	public CompanyEntity save(CompanyEntity companyEntity) {
		return companyDao.save(companyEntity);
	}

	public void update(String stage, 
			String companylocation, String companyemployernumber,
			String companyintroduce) {
		String sql = "update company set "
				+ " companylocation=" + companylocation
				+ " and companyemployernumber=" + companyemployernumber
				+ " and companyintroduce=" + companyintroduce
				+ "and stage="+stage;
		queryDao.update(sql);
	}
	
	public CompanyEntity findOne(Long companyId) {
		return companyDao.findOne(companyId);
	}
}
