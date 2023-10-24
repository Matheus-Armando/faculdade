package com.amusic.work.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.amusic.work.model.Genero;

public class GeneroMapper implements RowMapper<Genero> {

	@Override
	public Genero mapRow(ResultSet rs, int rowNum) throws SQLException {
		Genero gen = new Genero();
		gen.setIdGenero(rs.getLong("idGenero"));
		gen.setNome(rs.getString("nome"));
		return gen;
	}

}
