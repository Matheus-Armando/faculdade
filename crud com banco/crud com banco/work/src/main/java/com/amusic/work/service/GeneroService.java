package com.amusic.work.service;

import java.util.List;

import com.amusic.work.model.Genero;

public interface GeneroService {

	public List<Genero> buscarTodas() throws Exception;
	public List<Genero> buscarPorNome(String nome) throws Exception;
	public void inserir(Genero play) throws Exception;
	public void alterar(Genero play) throws Exception;
	public void excluir (Long id) throws Exception;
	public Genero buscaPorCodigo (Long id) throws Exception;
}
