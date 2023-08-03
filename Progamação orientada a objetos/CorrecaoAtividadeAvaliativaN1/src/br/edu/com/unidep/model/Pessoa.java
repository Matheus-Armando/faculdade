package br.edu.com.unidep.model;

import br.edu.com.unidep.exception.IdadeException;

/*
 1.	Criar classe Pessoa, declarar seus atributos e o 
 	método calcularIdade. 
 */
public abstract class Pessoa {
	
	private Long codigo;
	private String nome;
	
	public Pessoa() {
		super();
	}
	
	public Pessoa(Long codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}



	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public abstract void calcularIdade(int idade) throws IdadeException;
	

}
