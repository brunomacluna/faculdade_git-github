package Lista;

import java.util.Scanner;
public class Ex3 {
	public void calculoEx3() {
		
		Scanner input = new Scanner(System.in);
		
		double positivos = 0;
		double negativos = 0;
		double contador = 0;
		double media_aritimetica = 0;
		double total = 0;
		
		while (true) {
			System.out.print("Digite um valor: ");
			double valor = input.nextDouble();
			contador++;
			total += valor;
			
			if (valor > 0) {
				positivos++;
			}//fim if
			else {
				negativos++;
			}//fim if else
			
			if (positivos > 0 && negativos > 0) {
				System.out.print("Deseja inserir mais números? [s/n]" );
				if (input.next().toLowerCase().equals("n")) {
					break;
				}//fim if
			} else {
				System.out.println("Você precisa inserir pelo um número positivo e um negativo: ");
			}//fim else
		}//fim while 1	
				
		double percentual_positivo = positivos * 100 / contador;
		double percentual_negativo = negativos * 100 / contador;
		media_aritimetica = total / contador;
		
		System.out.println("Média aritimética: "+Math.round(media_aritimetica));
		System.out.println("Números positivos: "+positivos);
		System.out.println("Números negativos: "+negativos);
		System.out.println("Porcentagem dos positivos: "+(Math.round(percentual_positivo))+"% do total.");
		System.out.println("Porcentegam do negativos: "+(Math.round(percentual_negativo))+"% do total.");
	}//fim metodo calculoEx3
}//fim class Ex3
/*
3. Crie um programa que solicite ao usuário uma quantidade indefinida de valores
numéricos. O programa deve calcular e exibir a média aritmética dos números
inseridos, além de contar quantos desses números são positivos e quantos são
negativos. Finalmente, calcule e apresente a porcentagem de números positivos e
negativos. Considere que o usuário deve inserir pelo menos um número positivo e
um negativo.
*/