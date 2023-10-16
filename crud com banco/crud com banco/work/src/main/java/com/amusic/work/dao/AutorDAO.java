package com.amusic.work.dao;

import java.util.List;

import com.amusic.work.model.Autor;

public interface AutorDAO {

	public List<Autor> buscarTodas() throws Exception;
	public List<Autor> buscarPorNome(String nome) throws Exception;
	public void inserir(Autor autor) throws Exception;
	public void alterar(Autor autor) throws Exception;
	public void excluir (Long id) throws Exception;
	public Autor buscaPorCodigo (Long id) throws Exception;
	 
}
