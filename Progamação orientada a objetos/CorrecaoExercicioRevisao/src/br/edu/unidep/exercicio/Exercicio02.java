package br.edu.unidep.exercicio;

import java.util.Scanner;

/*
 2.	Implemente um algoritmo que leia o nome de um vendedor, 
 		o seu sal�rio fixo e o valor total de vendas efetuadas 
 		por ele no m�s.

a.	Sabendo que este vendedor ganha uma comiss�o 15% sobre suas
 	vendas efetuadas, implemente um m�todo que retorne o valor 
 	final de seu sal�rio.
 
 */
public class Exercicio02 {

	public static void main(String[] args) {
		obterDados();
	}
	
	public static void obterDados() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Informe o nome do vendedor: ");
		String nomeDoVendedor = scanner.next();
		
		System.out.println("Informe o sal�rio do vendedor");
		double salarioDoVendedor = scanner.nextDouble();
		
		System.out.println("Informe o valor total de vendas "
				+ "efetuado pelo " + nomeDoVendedor + " no m�s");
		double valorTotalVendas = scanner.nextDouble();
		
		double salarioCalculado = 
				calcularSalario(salarioDoVendedor, valorTotalVendas);
		
		System.out.println("O valor do sal�rio de " + nomeDoVendedor + 
				" �: " + salarioCalculado);
		
		scanner.close();
	}
	
	public static double calcularSalario(double salario, double valorTotal) {
		double comissao = valorTotal * 0.15;
		double valorSalarioCalculado =  salario + comissao;
		return valorSalarioCalculado;
	}
	
}