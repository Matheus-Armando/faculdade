package br.edu.com.unidep.model;

import br.edu.com.unidep.exception.IdadeException;

/*
2.	Criar classe Funcionario e estender da classe Pessoa.
	a.	Implementar os atributos para a classe;
	
	b.	Sobrescrever e implementar o método calcularIdade da 
		classe pai;
		
		i.	Caso a idade for igual ou maior do que 16 anos e 
			menor do que 18 anos, deverá mostrar a mensagem 
			“Colaborador poderá ser vinculado a empresa como 
			Menor Aprendiz”.
			
		ii.	Caso a idade for igual ou maior do que do que 
		18 anos, deverá mostrar a mensagem “Colaborador poderá 
		ser vinculado a empresa com contrato efetivo”.
		
		iii.	Caso idade for menor do que 16 anos deverá 
		lançar a exceção com a seguinte mensagem: 
		“Não poderá ter um vincula a empresa”. 

 */
public class Funcionario extends Pessoa {

	private double salario;

	public Funcionario() {
		super();
	}

	public Funcionario(Long codigo, String nome, double salario) {
		super(codigo, nome);
		this.salario = salario;
	}
	
	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public void calcularIdade(int idade) throws IdadeException {
		if (idade >= 16 && idade < 18) {
			System.out.println("Colaborador poderá ser vinculado "
				+ "a empresa como Menor Aprendiz");
		} else if (idade >= 18) {
			System.out.println("Colaborador poderá ser vinculado "
					+ " a empresa com contrato efetivo");
		} else {
			throw new IdadeException("Não poderá ter um vincula a empresa");
		}
		

	}

}
