package com.amusic.work.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.amusic.work.mapper.AutorMapper;
import com.amusic.work.model.Autor;

@Repository
@PropertySource("classpath:sql/autor.xml")
public class AutorDAOImpl implements AutorDAO {
	
	@Value("${sql.autor.buscaPorNome}")
	private String SQL_BUSCA_NOME;

	@Value("${sql.autor.buscarTodas}")
	private String SQL_BUSCAR_TODAS;

	@Value("${sql.autor.inserir}")
	private String SQL_INSERIR;

	@Value("${sql.autor.alterar}")
	private String SQL_ALTERAR;
	
	@Value("${sql.autor.excluir}")
	private String SQL_EXCLUIR;
	
	@Value("${sql.autor.buscaPorCodigo}")
	private String SQL_BUSCA_CODIGO;

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Autor> buscarTodas() throws Exception {
		return jdbcTemplate.query(SQL_BUSCAR_TODAS, new AutorMapper());
	}

	@Override
	public List<Autor> buscarPorNome(String nome) throws Exception {
		return jdbcTemplate.query(SQL_BUSCA_NOME, new AutorMapper(), "%"+nome+"%");
	}

	@Override
	public void inserir(Autor autor) throws Exception {
		jdbcTemplate.update(SQL_INSERIR, autor.getNome(), autor.getBiografia());

	}

	@Override
	public void alterar(Autor autor) throws Exception {
		jdbcTemplate.update(SQL_ALTERAR, autor.getNome(), autor.getBiografia(), autor.getIdAutor());
	}

	@Override
	public void excluir(Long id) throws Exception {
		jdbcTemplate.update(SQL_EXCLUIR, id);
	}

	@Override
	public Autor buscaPorCodigo(Long id) throws Exception {
		return jdbcTemplate.queryForObject(SQL_BUSCA_CODIGO, new AutorMapper(), id);
	}

}
