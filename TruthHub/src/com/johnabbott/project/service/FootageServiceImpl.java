package com.johnabbott.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.johnabbott.project.dao.FootageDao;
import com.johnabbott.project.model.FootageEntity;

@Service
@Transactional
public class FootageServiceImpl implements FootageService {
	
	@Autowired
	FootageDao footageDao;
	
	List<FootageEntity> listFootages;
	
	public FootageServiceImpl() {
		listFootages = new ArrayList<FootageEntity>();
		
		listFootages.add(new FootageEntity(1, "accident", "2008-05-26_11:00", "Montreal"));
		listFootages.add(new FootageEntity(2, "robery", "2010-12-22_16:00", "Verdun"));
		listFootages.add(new FootageEntity(3, "theft", "2015-05-19_15:55", "Dorval"));
		listFootages.add(new FootageEntity(4, "assult", "2015-09-19_03:18", "DDO"));
	}
	
	@Override
	public List<FootageEntity> getFootages(){
		return footageDao.getFootages();
	}

	@Override
	public boolean addFootage(FootageEntity ftg) {
		return footageDao.insertFootage(ftg) > 0 ;
	}

	@Override
	public FootageEntity getFootageById(int footageId) {
		return footageDao.getFootageById(footageId);
	}

	@Override
	public boolean deleteFootage(int footageId) {
		return footageDao.deleteFootage(footageId);
	}

	@Override
	public boolean updateFootage(FootageEntity ftg) {
		return footageDao.updateFootage(ftg);
	}
}
