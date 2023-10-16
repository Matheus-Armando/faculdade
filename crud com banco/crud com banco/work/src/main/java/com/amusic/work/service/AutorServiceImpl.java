package com.amusic.work.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.amusic.work.dao.AutorDAO;
import com.amusic.work.model.Autor;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AutorServiceImpl implements AutorService {

	@Autowired
	private AutorDAO autorDAO;
	
	@Override
	public List<Autor> buscarTodas() throws Exception {
		return autorDAO.buscarTodas();
	}

	@Override
	public List<Autor> buscarPorNome(String nome) throws Exception {
		return autorDAO.buscarPorNome(nome);
	}

	@Override
	public void inserir(Autor autor) throws Exception {
		if(autor.getIdAutor() == null) {
			autorDAO.inserir(autor);
		}else {
			autorDAO.alterar(autor);
		}
	}

	@Override
	public void alterar(Autor autor) throws Exception {
		autorDAO.alterar(autor);
	}

	@Override
	public void excluir(Long id) throws Exception {
		autorDAO.excluir(id);
	}

	@Override
	public Autor buscaPorCodigo(Long id) throws Exception {
		return autorDAO.buscaPorCodigo(id);
	}

}
