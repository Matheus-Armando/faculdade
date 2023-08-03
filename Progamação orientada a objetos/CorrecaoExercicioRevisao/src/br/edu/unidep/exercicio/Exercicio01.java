package br.edu.unidep.exercicio;

import java.util.Scanner;

/*
 1.	Implemente um algoritmo que calcule o consumo médio 
 	de um automóvel, sendo fornecida a distância total 
 	percorrida pelo automóvel e o total de combustível 
 	gasto.

	a.	Implemente um método que retorne o consumo médio 
		de acordo com as informações:
	i.	Quilometragem inicial;
	ii.	Quilometragem final;
	iii.	Quilometragem percorrida;
	iv.	Quantidade de combustível gasta.

 */
public class Exercicio01 {

	public static void main(String[] args) {
		double consumoMedio = calcularConsumoMedio();
		System.out.println("O consumo médio foi: " + consumoMedio);
	}
	
	public static double calcularConsumoMedio() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Informe a quilometragem inicial:");
		double quilometragemInicial = scanner.nextDouble();
		
		System.out.println("Informe a quilometragem final:");
		double quilometragemFinal = scanner.nextDouble();
		
		System.out.println("Informe a quantidade de combustível "
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