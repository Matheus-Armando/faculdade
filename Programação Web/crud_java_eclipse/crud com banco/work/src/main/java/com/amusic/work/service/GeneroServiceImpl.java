package com.amusic.work.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.amusic.work.dao.GeneroDAO;
import com.amusic.work.model.Genero;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class GeneroServiceImpl implements GeneroService {

	@Autowired
	private GeneroDAO playDAO;
	
	@Override
	public List<Genero> buscarTodas() throws Exception {
		return playDAO.buscarTodas();
	}

	@Override
	public List<Genero> buscarPorNome(String nome) throws Exception {
		return playDAO.buscarPorNome(nome);
	}

	@Override
	public void inserir(Genero play) throws Exception {
		if(play.getIdGenero() == null) {
			playDAO.inserir(play);
		} else {
			playDAO.alterar(play);
		}
	}

	@Override
	public void alterar(Genero play) throws Exception {
		playDAO.alterar(play);

	}

	@Override
	public void excluir(Long id) throws Exception {
		playDAO.excluir(id);
	}

	@Override
	public Genero buscaPorCodigo(Long id) throws Exception {
		return playDAO.buscaPorCodigo(id);
	}

}
