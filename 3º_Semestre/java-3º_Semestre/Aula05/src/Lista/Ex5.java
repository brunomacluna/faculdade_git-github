package Lista;

import java.util.Scanner;
public class Ex5 {
	public void paresEimpares() {
		
		Scanner input = new Scanner(System.in);
		
		double pares = 0;
		double total_pares = 0;
		double impares = 0;
		double total_impares = 0;
		double media_pares = 0;
		double media_total = 0;
		double contador = 0;
		
		while (true) {
			
			System.out.print("Digite um valor OU zero [0] para encerrar: ");
			double valor = input.nextDouble();
			
			
			if (valor == 0) {
				break;
			}//fim if
			
			if (valor < 0) {
				System.out.println("[ERROR] Valores negativos não são aceitos!!!");
				continue;
			}//fim if
			
			if (valor % 2 == 0) {
				pares++;
				total_pares += valor;
			}//fim if
			else {
				impares++;
				total_impares+= valor;
			}//fim else			
			
			contador++;		
			
		}//fim while
		
		media_total = (total_pares + total_impares) / contador;
		media_pares = total_pares / pares;
		
		
		System.out.println("Foram inseridos "+pares+" números pares.");
		System.out.println("Foram inseridos "+impares+" números ímpares.");
		System.out.println("A média dos pares é "+Math.round(media_pares));
		System.out.println("A média total é "+Math.round(media_total));
	}//fim metodo paresEimpares
}//fim class Ex5
/*
5. Implemente um programa que leia uma sequência de números positivos, encerrando a leitura quando
o número zero for inserido. O programa deve contar quantos números pares e ímpares foram inseridos, 
além de calcular a média dos números pares e a média geral dos números lidos. Inclua uma explicação 
de como o programa diferencia números pares de ímpares.
 */
