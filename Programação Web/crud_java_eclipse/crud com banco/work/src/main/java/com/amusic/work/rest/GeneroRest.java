package com.amusic.work.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amusic.work.model.Genero;
import com.amusic.work.service.GeneroService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("genero")
public class GeneroRest {


	@Autowired
	private GeneroService playService;
	
	@PostMapping
	public void inserir(@RequestBody Genero gen) {
		try {
			playService.inserir(gen);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping
	public List<Genero> buscarTodas() {
		try {
			return playService.buscarTodas();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@DeleteMapping(path = "/{id}")
	public void excluir(@PathVariable Long id) {
		try {
			playService.excluir(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping(path = "/{id}")
	public Genero buscarPorCodigo(@PathVariable Long id) {
		try {
			return playService.buscaPorCodigo(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@GetMapping(path = "/nome/{nome}")
	public List<Genero> buscarPorNome(@PathVariable String nome) {
		try {
			return playService.buscarPorNome(nome);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
