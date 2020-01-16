package com.johnabbott.project.dao;

import java.util.List;

import com.johnabbott.project.model.PublisherEntity;

public interface PublisherDao {
	public int insertPublisher(PublisherEntity pblsr); //Create
	
	public List<PublisherEntity> getPublishers(); // Read
	
	public PublisherEntity getPublisherById(int publisherId); // Read
	
	public PublisherEntity getPublisherByUsername(String footageUsername); //Read
	
	public boolean deletePublisher(int publisherId); //DELETE
	
	public boolean updatePublisher(PublisherEntity pblsr); // UPDATE
	
	
}
