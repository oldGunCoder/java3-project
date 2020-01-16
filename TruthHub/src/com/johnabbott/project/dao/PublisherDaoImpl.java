package com.johnabbott.project.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.johnabbott.project.model.PublisherEntity;


public class PublisherDaoImpl implements PublisherDao {

	JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT_PUBLISHER = "insert into " + "publisher(title, time, location) values(?, ?, ?)";

	private final String SQL_UPDATE_PUBLISHER = "update publisher set title= ? , time =? , location = ? where id = ? ";

	private final String SQL_SELECT_PUBLISHER = "select id, title, time, location" + " from publisher";
		
	private final String SQL_SELECT_PUBLISHER_BY_ID = "select id, title, time, location from publisher where id = ?";
	
	private final String SQL_DELETE_PUBLISHER = "delete from publisher where id = ? ";

	public PublisherDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int insertPublisher(PublisherEntity publisher) {
		return jdbcTemplate.update(SQL_INSERT_PUBLISHER, publisher.getUsername(), publisher.getCountry());
	}

	@Override
	public List<PublisherEntity> getPublishers() {
		return jdbcTemplate.query(SQL_SELECT_PUBLISHER, new PublisherMapper());
	}

	@Override
	public PublisherEntity getPublisherById(int publisherId) {
		return jdbcTemplate.queryForObject(SQL_SELECT_PUBLISHER_BY_ID, 
				new Object[]{publisherId}, new PublisherMapper());
	}

	@Override
	public boolean deletePublisher(int publisherId) {
		int deleteResult = jdbcTemplate.update(SQL_DELETE_PUBLISHER, publisherId);
		return deleteResult > 0;
	}

	@Override
	public boolean updatePublisher(PublisherEntity ftg) {
		int updateResult = jdbcTemplate.update
				(SQL_UPDATE_PUBLISHER, 
						ftg.getUsername(), 
						ftg.getCountry(), 
						ftg.getId());
		return updateResult > 0;
	}

	@Override
	public PublisherEntity getPublisherByUsername(String publisherUsername) {
		// TODO Auto-generated method stub
		return null;
	}

}
