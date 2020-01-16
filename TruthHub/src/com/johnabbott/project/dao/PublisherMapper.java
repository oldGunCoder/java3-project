package com.johnabbott.project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.johnabbott.project.model.PublisherEntity;

public class PublisherMapper implements RowMapper<PublisherEntity> {

	@Override
	public PublisherEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new PublisherEntity(rs.getInt("id"), rs.getString("username"),
				rs.getString("country"));
	}

}
