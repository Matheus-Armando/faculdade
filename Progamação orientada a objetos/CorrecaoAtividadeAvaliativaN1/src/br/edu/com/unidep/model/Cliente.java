package br.edu.com.unidep.model;

import java.time.LocalDate;

import br.edu.com.unidep.exception.IdadeException;

/*
	3.	Criar classe Cliente e estender da classe Pessoa;
		a.	Implementar os atributos para a classe;
		
		b.	Sobrescrever e implementar o método calcularIdade 
			da classe pai;
			
			i.	Caso a idade for igual ou maior do que 16 
			anos e menor do que 18 anos, de-verá mostrar a 
			mensagem “Cliente poderá ter um cadastro desde que 
			tenha aprovação de um responsável”.
			
			ii.	Caso a idade for igual ou maior do que do que 
			18 anos, deverá mostrar a mensagem “Cliente poderá 
			ter um cadastro sujeito a consulta SPC”.
			
			iii.Caso idade for menor do que 16 anos deverá 
			lançar a exceção com a seguinte mensagem: 
			“Não poderá ter um cadastro devido idade ser 
			menor do que 16 anos”.
 
 */
public class Cliente extends Pessoa {
	
	private LocalDate dataCadastro;
	
	public Cliente() {
		super();
	}

	public Cliente(Long codigo, String nome, 
			LocalDate dataCadastro) {
		super(codigo, nome);
		this.dataCadastro = dataCadastro;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public void calcularIdade(int idade) throws IdadeException {
		if (idade >= 16 && idade < 18) {
			System.out.println("Cliente poderá ter um cadastro "
					+ " desde que tenha aprovação de um "
					+ "responsável");
			
		} else if (idade >= 18) {
			System.out.println("Cliente poderá ter um cadastro sujeito "
					+ "a consulta SPC");
			
		} else {
			throw new IdadeException("Não poderá ter um cadastro devido "
					+ "idade ser menor do que 16 anos");
		}

	}

}
