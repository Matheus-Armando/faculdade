c9package br.com.fernandofavin;

public class Refrigerante extends Bebida{

	@Override
	public double calcularVenda(double precoCusto) throws ExcecaoPreco {
		double precoVenda = precoCusto * 1.75;
		return precoVenda;
	}

	

	
}
