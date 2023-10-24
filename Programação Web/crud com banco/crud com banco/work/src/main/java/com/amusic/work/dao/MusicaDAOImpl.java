package com.amusic.work.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.amusic.work.mapper.MusicaMapper;
import com.amusic.work.model.Musica;

@Repository
@PropertySource("classpath:sql/musica.xml")
public class MusicaDAOImpl implements MusicaDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Value("${sql.musica.buscaPorNome}")
	private String SQL_BUSCA_NOME;


	@Value("${sql.musica.buscarTodas}")
	private String SQL_BUSCAR_TODAS;

	@Value("${sql.musica.inserir}")
	private String SQL_INSERIR;

	@Value("${sql.musica.alterar}")
	private String SQL_ALTERAR;
	
	@Value("${sql.musica.excluir}")
	private String SQL_EXCLUIR;
	
	@Value("${sql.musica.buscaPorCodigo}")
	private String SQL_BUSCA_CODIGO;
	
	@Value("${sql.musica.buscaPorGenero}")
	private String SQL_BUSCA_GENERO;
	
	@Override
	public List<Musica> buscarTodas() throws Exception {
		return jdbcTemplate.query(SQL_BUSCAR_TODAS, new MusicaMapper());
	}

	@Override
	public void inserir(Musica musica) throws Exception {
		jdbcTemplate.update(SQL_INSERIR, musica.getNome(), musica.getIdAutor(), musica.getDuracaoMinutos(), musica.getIdGenero());
	}

	@Override
	public void alterar(Musica musica) throws Exception {
		 jdbcTemplate.update(SQL_ALTERAR, musica.getNome(), musica.getIdAutor(), musica.getDuracaoMinutos(), musica.getIdMusica());
	}

	@Override
	public void excluir(Long id) throws Exception {
		jdbcTemplate.update(SQL_EXCLUIR, id);

	}

	@Override
	public Musica buscaPorCodigo(Long id) throws Exception {
		return jdbcTemplate.queryForObject(SQL_BUSCA_CODIGO, new MusicaMapper(), id);
	}

	@Override
	public List<Musica> buscarPorNome(String nome) throws Exception {
		
		return jdbcTemplate.query(SQL_BUSCA_NOME, new MusicaMapper(), "%"+nome+"%" );
	}

	@Override
	public List<Musica> buscaPorGenero(Long id) throws Exception {
		return jdbcTemplate.query(SQL_BUSCA_GENERO, new MusicaMapper(), id);
	}

}
