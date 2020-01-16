package com.johnabbott.project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.johnabbott.project.model.FootageEntity;

public class FootageMapper implements RowMapper<FootageEntity> {

	@Override
	public FootageEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new FootageEntity(rs.getInt("id"), rs.getString("title"),
				rs.getString("time"), rs.getString("location"));
	}

}
