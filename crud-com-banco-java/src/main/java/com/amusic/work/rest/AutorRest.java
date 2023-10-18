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

import com.amusic.work.model.Autor;
import com.amusic.work.service.AutorService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("autor")
public class AutorRest {

	@Autowired
	private AutorService autorService;
	
	@PostMapping
	public void inserir(@RequestBody Autor autor) {
		try {
			autorService.inserir(autor);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping
	public List<Autor> buscarTodas() {
		try {
			return autorService.buscarTodas();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@DeleteMapping(path = "/{id}")
	public void excluir(@PathVariable Long id) {
		try {
			autorService.excluir(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping(path = "/{id}")
	public Autor buscarPorCodigo(@PathVariable Long id) {
		try {
			return autorService.buscaPorCodigo(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@GetMapping(path = "/nome/{nome}")
	public List<Autor> buscarPorNome(@PathVariable String nome) {
		try {
			return autorService.buscarPorNome(nome);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
