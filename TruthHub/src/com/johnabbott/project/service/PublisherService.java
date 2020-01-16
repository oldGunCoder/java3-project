package com.johnabbott.project.service;

import java.util.List;

import com.johnabbott.project.model.PublisherEntity;

public interface PublisherService {
	public boolean addPublisher(PublisherEntity pblsr); //Add
	
	public List<PublisherEntity> getPublishers(); // Read
	
	public PublisherEntity getPublisherById(int publisherId); // Read
	
	public boolean deletePublisher(int publisherId); //DELETE
	
	public boolean updatePublisher(PublisherEntity pblsr); // UPDATE
}
