package br.edu.unidep.exercicio;

import java.util.Scanner;

/*
 2.	Implemente um algoritmo que leia o nome de um vendedor, 
 		o seu salário fixo e o valor total de vendas efetuadas 
 		por ele no mês.

a.	Sabendo que este vendedor ganha uma comissão 15% sobre suas
 	vendas efetuadas, implemente um método que retorne o valor 
 	final de seu salário.
 
 */
public class Exercicio02 {

	public static void main(String[] args) {
		obterDados();
	}
	
	public static void obterDados() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Informe o nome do vendedor: ");
		String nomeDoVendedor = scanner.next();
		
		System.out.println("Informe o salário do vendedor");
		double salarioDoVendedor = scanner.nextDouble();
		
		System.out.println("Informe o valor total de vendas "
				+ "efetuado pelo " + nomeDoVendedor + " no mês");
		double valorTotalVendas = scanner.nextDouble();
		
		double salarioCalculado = 
				calcularSalario(salarioDoVendedor, valorTotalVendas);
		
		System.out.println("O valor do salário de " + nomeDoVendedor + 
				" é: " + salarioCalculado);
		
		scanner.close();
	}
	
	public static double calcularSalario(double salario, double valorTotal) {
		double comissao = valorTotal * 0.15;
		double valorSalarioCalculado =  salario + comissao;
		return valorSalarioCalculado;
	}
	
}