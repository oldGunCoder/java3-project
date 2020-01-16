package com.johnabbott.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.johnabbott.project.model.PublisherEntity;

@Repository
public class HibernatePublisherDaoImpl implements PublisherDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int insertPublisher(PublisherEntity pblsr) {
		sessionFactory.getCurrentSession().save(pblsr);
		//sessionFactory.getCurrentSession().save(ftg.getAddress());
		sessionFactory.getCurrentSession().save(pblsr.getPublisher());
		return 1;
	}

	@Override
	public List<PublisherEntity> getPublishers() {
		//Student is not the table name => it is the class name(@Entity)
		return getSession().createQuery("from PublisherEntity", PublisherEntity.class).list();
	}

	@Override
	public PublisherEntity getPublisherById(int publisherId) {
		return (PublisherEntity) getSession().get(PublisherEntity.class, publisherId);
	}
	
	@Override
	public PublisherEntity getPublisherByUsername(String publisherUsername) {
		String hql = "from PublisherEntity where username= :publisher_username";
		Query query = getSession().createQuery(hql);
		query.setParameter("publisher_username",publisherUsername);
		if (query.list().size() > 0) {
			return (PublisherEntity)query.list().get(0);
		}
		else {
			return null;
		}
			
		
	}

	@Override
	public boolean deletePublisher(int publisherId) {
		PublisherEntity fetchedFootage = getPublisherById(publisherId);
		getSession().delete(fetchedFootage);
		return true;
	}

	@Override
	public boolean updatePublisher(PublisherEntity pblsr) {
		getSession().update(pblsr);
		return true;
	}

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
}
