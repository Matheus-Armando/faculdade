package br.edu.unidep.bancario.modelo;

public class RealizarOperacao {

	public static void main(String[] args) {
		/*
		Conta contaCorrente = new Conta();
		Conta contaSalario = new Conta("2348-9", "500934", 8, 2000);
		
		contaCorrente.setAgencia("1235-7");
		contaCorrente.setNumero("500933");
		contaCorrente.setDigitoVerificador(9);
		contaCorrente.setSaldo(1500.00);
		
		System.out.println("A cc é: " + contaCorrente);
		System.out.println("A cs é: " + contaSalario);
		*/
	
		
		ContaCorrente contaCorrente = new ContaCorrente();
		ContaSalario contaSalario = new ContaSalario();
		
		double juroCalculadoContaSalario = 
				contaSalario.calcularJuros(10);
		
		double juroCalculadoContaCorrente =
				contaCorrente.calcularJuros(10);
		
		System.out.println("O meu saldo na cc é: " + 
				contaCorrente.meuSaldo());

		System.out.println("O meu saldo na cs é: " + 
		contaSalario.meuSaldo());
		
		System.out.println("Juros CC: " + 
				juroCalculadoContaCorrente);

		System.out.println("Juros CS: " + 
				juroCalculadoContaSalario);
		
		contaCorrente.setAgencia("adfdsafas");
		contaCorrente.getAgencia();

		
	}

}
