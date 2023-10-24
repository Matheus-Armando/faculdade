package com.amusic.work.dao;

import java.util.List;

import com.amusic.work.model.Musica;

public interface MusicaDAO {

	public List<Musica> buscarTodas() throws Exception;
	public List<Musica> buscarPorNome(String nome) throws Exception;
	public void inserir(Musica musica) throws Exception;
	public void alterar(Musica musica) throws Exception;
	public void excluir (Long id) throws Exception;
	public Musica buscaPorCodigo (Long id) throws Exception;
	public List<Musica> buscaPorGenero (Long id) throws Exception;
	 
}
