package com.amusic.work.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.amusic.work.mapper.GeneroMapper;
import com.amusic.work.model.Genero;

@Repository
@PropertySource("classpath:sql/genero.xml")
public class GeneroDAOImpl implements GeneroDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${sql.genero.buscaPorNome}")
	private String SQL_BUSCA_NOME;


	@Value("${sql.genero.buscarTodas}")
	private String SQL_BUSCAR_TODAS;

	@Value("${sql.genero.inserir}")
	private String SQL_INSERIR;

	@Value("${sql.genero.alterar}")
	private String SQL_ALTERAR;
	
	@Value("${sql.genero.excluir}")
	private String SQL_EXCLUIR;
	
	@Value("${sql.genero.buscaPorCodigo}")
	private String SQL_BUSCA_CODIGO;
	
	@Override
	public List<Genero> buscarTodas() throws Exception {
		return jdbcTemplate.query(SQL_BUSCAR_TODAS, new GeneroMapper());
	}

	@Override
	public List<Genero> buscarPorNome(String nome) throws Exception {
		return jdbcTemplate.query(SQL_BUSCA_NOME, new GeneroMapper(), "%"+nome+"%");
	}

	@Override
	public void inserir(Genero play) throws Exception {
		jdbcTemplate.update(SQL_INSERIR, play.getNome());
	}

	@Override
	public void alterar(Genero play) throws Exception {
		jdbcTemplate.update(SQL_INSERIR, play.getNome(), play.getIdGenero());
	}

	@Override
	public void excluir(Long id) throws Exception {
		jdbcTemplate.update(SQL_EXCLUIR, id);
	}

	@Override
	public Genero buscaPorCodigo(Long id) throws Exception {
		return jdbcTemplate.queryForObject(SQL_BUSCA_CODIGO, new GeneroMapper(), id);
	}

}
