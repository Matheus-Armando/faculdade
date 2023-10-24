package com.amusic.work.service;

import java.util.List;

import com.amusic.work.model.Musica;

public interface MusicaService {

	public List<Musica> buscarTodas() throws Exception;
	public List<Musica> buscarPorNome(String nome) throws Exception;
	public void inserir(Musica musica) throws Exception;
	public void alterar(Musica musica) throws Exception;
	public void excluir (Long id) throws Exception;
	public Musica buscarPorCodigo (Long id) throws Exception;
	public List<Musica> buscarPorGenero(Long id) throws Exception;
}
