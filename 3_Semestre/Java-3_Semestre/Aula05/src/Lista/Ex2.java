package Lista;

import java.util.Scanner;
public class Ex2 {
	public void minMaxAltura(Scanner input) {
		double min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int i = 1; i < 6; i++) {
			System.out.print("Digite a altura: ");
			double altura = input.nextDouble();
			if (min > altura) {
				min = altura;
			}//fim if
			if (max < altura) {
				max = altura;
			}//fim if
		System.out.println("Altura máxima: "+ max);
		System.out.println("Altura mínima: "+ min);
		}//fim for
	}//fim metodo	
}//fim class
/*
 2. Escreva um algoritmo que leia a altura de 5 participantes de uma pesquisa. Após a
leitura, o programa deve identificar e exibir as alturas máxima e mínima registradas.
Explique como o algoritmo determina esses valores ao longo da execução.
 */
