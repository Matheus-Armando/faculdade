package br.edu.com.unidep.saida;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.edu.com.unidep.exception.IdadeException;
import br.edu.com.unidep.model.Cliente;

/*
	4.	Criar uma classe chamada Principal com o método main, 
	contendo as implementações para simular a entrada dos dados 
	utilizando a classe Scanner. 
 */
public class Principal {

	public static void main(String[] args) throws IdadeException {

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("*** Entrada dados do cliente ***");
		Cliente cliente = new Cliente();
		
		System.out.println("*** Informe o código do cliente ***");
		Long codigoCliente = scanner.nextLong();
		cliente.setCodigo(codigoCliente);
		
		System.out.println("*** Informe o nome do cliente ***");
		String nomeCliente = scanner.next();
		cliente.setNome(nomeCliente);
			
		System.out.println("Informe a data de cadastro dd/MM/yyyy");
		String dataCadastro = scanner.next();
		cliente.setDataCadastro(formatDate(dataCadastro));
		
		System.out.println("*** Validação do calculo de idade ***");
		cliente.calcularIdade(25);
		
		System.out.println("*** Mostrar informações ***");
		System.out.println("Código.............: " + cliente.getCodigo());
		System.out.println("Nome...............:" + cliente.getNome());
		System.out.println("Data de cadastro...:" + cliente.getDataCadastro());
		System.out.println("*** FIM ***");
		
		scanner.close();

	}
	
	public static LocalDate formatDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return LocalDate.parse(date, formatter);
	}

}
