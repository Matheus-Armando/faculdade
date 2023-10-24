package com.amusic.work.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.amusic.work.model.Autor;

public class AutorMapper implements RowMapper<Autor>  {

	@Override
	public Autor mapRow(ResultSet rs, int rowNum) throws SQLException {
		Autor autor = new Autor();
		autor.setIdAutor(rs.getLong("idautor"));
		autor.setNome(rs.getString("nome"));
		autor.setBiografia(rs.getString("biografia"));
		return autor;
	}

}
