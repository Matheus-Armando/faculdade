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

import com.amusic.work.model.Musica;
import com.amusic.work.service.MusicaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("musica")
public class MusicaRest {
	
	@Autowired
	private MusicaService musicaService;
	
	@PostMapping
	public void inserir(@RequestBody Musica musica) {
		try {
			musicaService.inserir(musica);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping
	public List<Musica> buscarTodas() {
		try {
			return musicaService.buscarTodas();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@DeleteMapping(path = "/{id}")
	public void excluir(@PathVariable Long id) {
		try {
			musicaService.excluir(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping(path = "/{id}")
	public Musica buscarPorCodigo(@PathVariable Long id) {
		try {
			return musicaService.buscarPorCodigo(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@GetMapping(path = "/nome/{nome}")
	public List<Musica> buscarPorNome(@PathVariable String nome) {
		try {
			return musicaService.buscarPorNome(nome);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@GetMapping(path = "/genero/{id}")
	public List<Musica> buscarPorNome(@PathVariable Long id) {
		try {
			return musicaService.buscarPorGenero(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

}
