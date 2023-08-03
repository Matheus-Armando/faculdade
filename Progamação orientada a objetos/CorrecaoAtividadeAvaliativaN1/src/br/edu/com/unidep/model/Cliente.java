package br.edu.com.unidep.model;

import java.time.LocalDate;

import br.edu.com.unidep.exception.IdadeException;

/*
	3.	Criar classe Cliente e estender da classe Pessoa;
		a.	Implementar os atributos para a classe;
		
		b.	Sobrescrever e implementar o m�todo calcularIdade 
			da classe pai;
			
			i.	Caso a idade for igual ou maior do que 16 
			anos e menor do que 18 anos, de-ver� mostrar a 
			mensagem �Cliente poder� ter um cadastro desde que 
			tenha aprova��o de um respons�vel�.
			
			ii.	Caso a idade for igual ou maior do que do que 
			18 anos, dever� mostrar a mensagem �Cliente poder� 
			ter um cadastro sujeito a consulta SPC�.
			
			iii.Caso idade for menor do que 16 anos dever� 
			lan�ar a exce��o com a seguinte mensagem: 
			�N�o poder� ter um cadastro devido idade ser 
			menor do que 16 anos�.
 
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
			System.out.println("Cliente poder� ter um cadastro "
					+ " desde que tenha aprova��o de um "
					+ "respons�vel");
			
		} else if (idade >= 18) {
			System.out.println("Cliente poder� ter um cadastro sujeito "
					+ "a consulta SPC");
			
		} else {
			throw new IdadeException("N�o poder� ter um cadastro devido "
					+ "idade ser menor do que 16 anos");
		}

	}

}
