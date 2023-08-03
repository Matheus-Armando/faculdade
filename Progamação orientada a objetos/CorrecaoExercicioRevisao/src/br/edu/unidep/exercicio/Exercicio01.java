package br.edu.unidep.exercicio;

import java.util.Scanner;

/*
 1.	Implemente um algoritmo que calcule o consumo m�dio 
 	de um autom�vel, sendo fornecida a dist�ncia total 
 	percorrida pelo autom�vel e o total de combust�vel 
 	gasto.

	a.	Implemente um m�todo que retorne o consumo m�dio 
		de acordo com as informa��es:
	i.	Quilometragem inicial;
	ii.	Quilometragem final;
	iii.	Quilometragem percorrida;
	iv.	Quantidade de combust�vel gasta.

 */
public class Exercicio01 {

	public static void main(String[] args) {
		double consumoMedio = calcularConsumoMedio();
		System.out.println("O consumo m�dio foi: " + consumoMedio);
	}
	
	public static double calcularConsumoMedio() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Informe a quilometragem inicial:");
		double quilometragemInicial = scanner.nextDouble();
		
		System.out.println("Informe a quilometragem final:");
		double quilometragemFinal = scanner.nextDouble();
		
		System.out.println("Informe a quantidade de combust�vel "
				+ "gasta:");
		double quantidadeCombustivel = scanner.nextDouble();
		
		double quilometragemPercorrida = quilometragemFinal -
				quilometragemInicial;
		
		double consumoMedio = quilometragemPercorrida / 
				quantidadeCombustivel;
		
		scanner.close();
		
		return consumoMedio;
	}

}