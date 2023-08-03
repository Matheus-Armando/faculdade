package br.com.fernandofavin.test;

import java.util.Scanner;

import br.com.fernandofavin.ExcecaoPreco;
import br.com.fernandofavin.Queijo;
import br.com.fernandofavin.Refrigerante;
import br.com.fernandofavin.Vinho;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws ExcecaoPreco {
		// teste de pre�o e exce��o e imposto do VINHO
		Scanner scan = new Scanner(System.in);
		Vinho v = new Vinho();
		Refrigerante r = new Refrigerante();
		Queijo q = new Queijo();

		System.out.println("Digite a marca do Vinho: ");
		v.setMarca(scan.next());
		System.out.println("Digite a unidade de medida do Vinho: ");
		v.setUnidadeMedida(scan.next());
		System.out.println("Digite o pre�o de compra do Vinho: ");
		v.setPrecoCompra(scan.nextDouble());
		double precoCalculado = v.calcularVenda(v.getPrecoCompra());
		System.out.println("* * * pre�o de venda sugerido: " + precoCalculado + " R$ * * *");
		System.out.println("Insira o pre�o de venda: ");
		double precoInserido = scan.nextDouble();
		if (precoInserido < precoCalculado) {
			throw new ExcecaoPreco("O valor de venda � abaixo do valor calculado. ");
		} else {
			v.setPrecoVenda(precoInserido);
		}
		double impostoVinho = v.gerarFunRural(v.getPrecoVenda());
		System.out.format("A quantia de imposto ser� de: " + "%.2f", impostoVinho);
		System.out.println();
		System.out.println();
		// teste de pre�o e exce��o do REFRIGERANTE

		System.out.println("Digite a marca do Refrigerante: ");
		r.setMarca(scan.next());
		System.out.println("Digite a unidade de medida do Refrigerante: ");
		r.setUnidadeMedida(scan.next());
		System.out.println("Digite o pre�o de compra do Refrigerante: ");
		r.setPrecoCompra(scan.nextDouble());
		double precoCalculadoR = r.calcularVenda(r.getPrecoCompra());
		System.out.println("* * * pre�o de venda sugerido: " + precoCalculadoR + " R$ * * *");
		System.out.println("Insira o pre�o de venda: ");
		double precoInseridoR = scan.nextDouble();
		if (precoInseridoR < precoCalculadoR) {
			throw new ExcecaoPreco("O valor de venda está abaixo do valor calculado. ");
		} else {
			r.setPrecoVenda(precoInseridoR);
		}
		System.out.println();
		// teste imposto do Queijo

		System.out.println("Digite a marca do Queijo: ");
		q.setMarca(scan.next());
		System.out.println("Digite a unidade de medida do Queijo: ");
		q.setUnidadeMedida(scan.next());
		System.out.println("Digite o pre�o de compra do Queijo: ");
		q.setPrecoCompra(scan.nextDouble());
		System.out.println("Insira o pre�o de venda: ");
		q.setPrecoVenda(scan.nextDouble());
		double impostoQueijo = q.gerarFunRural(q.getPrecoCompra());
		System.out.format("O queijo tera um imposto de " + "%.2f", impostoQueijo);
	}

}
