package com.amusic.work.model;

public class Musica {

	private Long idMusica;
	private String nome;
	private Long idAutor;
	private int duracaoMinutos;
	private Long idGenero;
	
	public Long getIdGenero() {
		return idGenero;
	}
	public void setIdGenero(Long idGenero) {
		this.idGenero = idGenero;
	}
	public Integer getDuracaoMinutos() {
		return duracaoMinutos;
	}
	public void setDuracaoMinutos(Integer duracaoMinutos) {
		this.duracaoMinutos = duracaoMinutos;
	}
	public Long getIdMusica() {
		return idMusica;
	}
	public void setIdMusica(Long idMusica) {
		this.idMusica = idMusica;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(Long idAutor) {
		this.idAutor = idAutor;
	}
}
