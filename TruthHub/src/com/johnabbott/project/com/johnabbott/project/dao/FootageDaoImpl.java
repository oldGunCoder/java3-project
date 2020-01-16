package com.johnabbott.project.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.johnabbott.project.model.FootageEntity;


public class FootageDaoImpl implements FootageDao {

	JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT_FOOTAGE = "insert into " + "student(firstname, lastname, age) values(?, ?, ?)";

	private final String SQL_UPDATE_FOOTAGE = "update student set firstname= ? , lastname =? , age = ? where id = ? ";

	private final String SQL_SELECT_FOOTAGE = "select id, firstname, lastname, age" + " from student";
		
	private final String SQL_SELECT_FOOTAGE_BY_ID = "select id, firstname, lastname, age from student where id = ?";
	
	private final String SQL_DELETE_FOOTAGE = "delete from student where id = ? ";

	public FootageDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int insertFootage(FootageEntity footage) {
		return jdbcTemplate.update(SQL_INSERT_FOOTAGE, footage.getFirstName(), footage.getLastName(), footage.getAge());
	}

	@Override
	public List<FootageEntity> getFootages() {
		return jdbcTemplate.query(SQL_SELECT_FOOTAGE, new FootageMapper());
	}

	@Override
	public FootageEntity getFootageById(int footageId) {
		return jdbcTemplate.queryForObject(SQL_SELECT_FOOTAGE_BY_ID, 
				new Object[]{footageId}, new FootageMapper());
	}

	@Override
	public boolean deleteFootage(int footageId) {
		int deleteResult = jdbcTemplate.update(SQL_DELETE_FOOTAGE, footageId);
		return deleteResult > 0;
	}

	@Override
	public boolean updateFootage(FootageEntity ftg) {
		int updateResult = jdbcTemplate.update
				(SQL_UPDATE_FOOTAGE, 
						ftg.getFirstName(), 
						ftg.getLastName(), 
						ftg.getAge(),
						ftg.getId());
		return updateResult > 0;
	}

	@Override
	public FootageEntity getFootageByName(String footageName) {
		// TODO Auto-generated method stub
		return null;
	}

}
