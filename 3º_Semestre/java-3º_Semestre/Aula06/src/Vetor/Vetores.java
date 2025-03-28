package Vetor;

import java.util.Scanner;

public class Vetores {
	public int maiorElemento(int valores[]) {
		int maiorElemento = valores[0];
		for (int i = 1; i < valores.length; i++) {
			if(valores[i] > maiorElemento) {
				maiorElemento = valores[i];
			}//fim if
		}//fim for
		return maiorElemento;
	}//fim metodo maiorElemento
	
	public int menorElemento(int valores[]) {
		int menorElemento = valores[0];
		for (int i = 1; i < valores.length; i++) {
			if (valores[i] < menorElemento) {
				menorElemento = valores[i];
			}//fim if
		}//fim for
		return menorElemento;
	}//fim metodo menorElemento
	
	public int[] createVetor(int quantidade, Scanner entrada) {
		int vet[] = new int[quantidade];
		for (int j = 0; j < vet.length; j++) {
			System.out.printf("Digite o valor na posição %d: ", j);
			vet[j] = entrada.nextInt();
		}//fim for
		return vet;
	}//fim metodo
	
	public void imprimeVetor(int vetor[]) {
		System.out.println("Imprimindo Vetor:");
		for(int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i] + " ");
		}//fim for
		System.out.println();
	}//fim metodo
}//fim class
