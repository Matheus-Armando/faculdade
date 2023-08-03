package br.edu.unidep.bancario.modelo;

public abstract class Conta extends Object {
	
	private String agencia;
	private String numero;
	private int digitoVerificador;
	private double saldo;
	
	public Conta() {
		System.out.println("Construindo a classe conta!!");
	}

	public Conta(String agencia, String numero, 
			int digitoVerificador, double saldo) {
		System.out.println("Construindo a classe conta"
				+ " com valores padroes!!!");
		
		this.agencia = agencia;
		this.numero = numero;
		this.digitoVerificador = digitoVerificador;
		this.saldo = saldo;
	}

	public String getAgencia() {
		return agencia;
	}
	
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public int getDigitoVerificador() {
		return digitoVerificador;
	}
	
	public void setDigitoVerificador(int digitoVerificador) {
		this.digitoVerificador = digitoVerificador;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public abstract double meuSaldo();

	@Override
	public String toString() {
		String valor = "Conta [agencia=" + agencia + ", numero=" + numero + ", digitoVerificador=" + digitoVerificador
				+ ", saldo=" + saldo + "]";
		
		return valor;
	}

}