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
		
		listFootages.add(new FootageEntity(1, "toto1", "popo1", 15));
		listFootages.add(new FootageEntity(2, "toto2", "popo2", 14));
		listFootages.add(new FootageEntity(3, "toto3", "popo3", 24));
		listFootages.add(new FootageEntity(4, "toto4", "popo4", 34));
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
