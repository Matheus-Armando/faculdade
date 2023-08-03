package br.com.fernandofavin;

public class Vinho extends Bebida implements Imposto {

	@Override
	public double calcularVenda(double precoCusto) {
		double precoVenda = precoCusto * 2;
		return precoVenda;
	}

	@Override
	public double gerarFunRural(double precoCompra) {
		return (precoCompra * 0.07);
	}

}
