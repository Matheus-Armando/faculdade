package com.amusic.work.service;

import java.util.List;

import com.amusic.work.model.Autor;

public interface AutorService {

	public List<Autor> buscarTodas() throws Exception;
	public List<Autor> buscarPorNome(String nome) throws Exception;
	public void inserir(Autor autor) throws Exception;
	public void alterar(Autor autor) throws Exception;
	public void excluir (Long id) throws Exception;
	public Autor buscaPorCodigo (Long id) throws Exception;
}
