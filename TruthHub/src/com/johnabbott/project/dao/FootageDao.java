package com.johnabbott.project.dao;

import java.util.List;

import com.johnabbott.project.model.FootageEntity;

public interface FootageDao {
	public int insertFootage(FootageEntity ftg); //Create
	
	public List<FootageEntity> getFootages(); // Read
	
	public FootageEntity getFootageById(int footageId); // Read
	
	public FootageEntity getFootageByTitle(String footageName); //Read
	
	public boolean deleteFootage(int footageId); //DELETE
	
	public boolean updateFootage(FootageEntity ftg); // UPDATE
	
	
}
