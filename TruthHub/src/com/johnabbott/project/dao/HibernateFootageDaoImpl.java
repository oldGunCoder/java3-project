package com.johnabbott.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.johnabbott.project.model.FootageEntity;

@Repository
public class HibernateFootageDaoImpl implements FootageDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int insertFootage(FootageEntity ftg) {
		sessionFactory.getCurrentSession().save(ftg);
		//sessionFactory.getCurrentSession().save(ftg.getAddress());
		sessionFactory.getCurrentSession().save(ftg.getPublisher());
		return 1;
	}

	@Override
	public List<FootageEntity> getFootages() {
		//Student is not the table name => it is the class name(@Entity)
		return getSession().createQuery("from FootageEntity", FootageEntity.class).list();
	}

	@Override
	public FootageEntity getFootageById(int footageId) {
		return (FootageEntity) getSession().get(FootageEntity.class, footageId);
	}
	
	@Override
	public FootageEntity getFootageByTitle(String footageTitle) {
		String hql = "from FootageEntity where title= :footage_title";
		Query query = getSession().createQuery(hql);
		query.setParameter("footage_title",footageTitle);
		if (query.list().size() > 0) {
			return (FootageEntity)query.list().get(0);
		}
		else {
			return null;
		}
			
		
	}

	@Override
	public boolean deleteFootage(int footageId) {
		FootageEntity fetchedFootage = getFootageById(footageId);
		getSession().delete(fetchedFootage);
		return true;
	}

	@Override
	public boolean updateFootage(FootageEntity ftg) {
		getSession().update(ftg);
		return true;
	}

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
}
