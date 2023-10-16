package com.amusic.work.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.amusic.work.dao.MusicaDAO;
import com.amusic.work.model.Musica;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class MusicaServiceImpl implements MusicaService {

	@Autowired
	private MusicaDAO musicaDAO;
	
	@Override
	public List<Musica> buscarTodas() throws Exception {
		return musicaDAO.buscarTodas();
	}

	@Override
	public void inserir(Musica musica) throws Exception {
		if (musica.getIdMusica() == null) {
			musicaDAO.inserir(musica);
		} else {
			musicaDAO.alterar(musica);
		}
	}

	@Override
	public void alterar(Musica musica) throws Exception {
		musicaDAO.alterar(musica);
	}

	@Override
	public void excluir(Long id) throws Exception {
		musicaDAO.excluir(id);
	}

	@Override
	public Musica buscarPorCodigo(Long id) throws Exception {
		return musicaDAO.buscaPorCodigo(id);
	}

	@Override
	public List<Musica> buscarPorNome(String nome) throws Exception {
		return musicaDAO.buscarPorNome(nome);
	}

	@Override
	public List<Musica> buscarPorGenero(Long id) throws Exception {
		return musicaDAO.buscaPorGenero(id);
	}

}
