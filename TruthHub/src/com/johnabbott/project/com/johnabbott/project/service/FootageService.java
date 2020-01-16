package com.johnabbott.project.service;

import java.util.List;

import com.johnabbott.project.model.FootageEntity;

public interface FootageService {
	public boolean addFootage(FootageEntity ftg);
	
	public List<FootageEntity> getFootages(); // Read
	
	public FootageEntity getFootageById(int footageId); // Read
	
	public boolean deleteFootage(int footageId); //DELETE
	
	public boolean updateFootage(FootageEntity ftg); // UPDATE
}
