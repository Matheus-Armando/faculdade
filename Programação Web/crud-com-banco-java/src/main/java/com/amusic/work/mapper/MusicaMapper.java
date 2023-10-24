package com.amusic.work.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.amusic.work.model.Musica;

public class MusicaMapper implements RowMapper<Musica> {

	@Override
	public Musica mapRow(ResultSet rs, int rowNum) throws SQLException {
		Musica musica = new Musica();
		musica.setIdMusica(rs.getLong("idmusica"));
		musica.setNome(rs.getString("nome"));
		musica.setIdAutor(rs.getLong("idautor"));
		musica.setDuracaoMinutos(rs.getInt("duracaominutos"));
		musica.setIdGenero(rs.getLong("idgenero"));
		return musica;
	}

}
