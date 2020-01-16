package com.johnabbott.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.johnabbott.project.dao.PublisherDao;
import com.johnabbott.project.model.PublisherEntity;

@Service
@Transactional
public class PublisherServiceImpl implements PublisherService {
	
	@Autowired
	PublisherDao publisherDao;
	
	List<PublisherEntity> listPublishers;
	
	public PublisherServiceImpl() {
		listPublishers = new ArrayList<PublisherEntity>();
		
		listPublishers.add(new PublisherEntity(1, "hero", "Canada"));
		listPublishers.add(new PublisherEntity(2, "ironman", "China"));
		listPublishers.add(new PublisherEntity(3, "batman", "Japan"));
		listPublishers.add(new PublisherEntity(4, "spiderman", "US"));
	}
	
	@Override
	public List<PublisherEntity> getPublishers(){
		return publisherDao.getPublishers();
	}

	@Override
	public boolean addPublisher(PublisherEntity pblsr) {
		return publisherDao.insertPublisher(pblsr) > 0 ;
	}

	@Override
	public PublisherEntity getPublisherById(int publisherId) {
		return publisherDao.getPublisherById(publisherId);
	}

	@Override
	public boolean deletePublisher(int publisherId) {
		return publisherDao.deletePublisher(publisherId);
	}

	@Override
	public boolean updatePublisher(PublisherEntity pblsr) {
		return publisherDao.updatePublisher(pblsr);
	}
}
