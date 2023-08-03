package br.edu.unidep.bancario.modelo;

public class ContaCorrente extends Conta implements Operacao {
	
	private String gerente;
	
	private double limite;
	
	public String getGerente() {
		return gerente;
	}

	public void setGerente(String gerente) {
		this.gerente = gerente;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	@Override
	public double meuSaldo() {
		return 10.0;
	}

	@Override
	public double calcularJuros(double valor) {
		return valor * 0.08;
	}

}
