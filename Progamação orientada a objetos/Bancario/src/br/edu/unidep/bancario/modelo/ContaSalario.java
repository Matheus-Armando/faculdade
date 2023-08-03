package br.edu.unidep.bancario.modelo;

public class ContaSalario extends Conta implements Operacao {
	
	private double juros;
	
	public double getJuros() {
		return juros;
	}

	public void setJuros(double juros) {
		this.juros = juros;
	}

	@Override
	public double meuSaldo() {
		return 500;
	}

	@Override
	public double calcularJuros(double valor) {
		return valor * 0.06;
	}
	
}
