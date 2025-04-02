package Vetor;
import java.util.Scanner;

public class Ex2 {
	public void leValores() {
		int array[] = new int[6];
		Scanner entrada = new Scanner(System.in);
		for (int i = 0; i < array.length; i++) {
			System.out.printf("Digite o valor na posição %d: ", i);
			array[i] = entrada.nextInt();
		}//fim for
		
		this.imprimeVetor(array);
	}//fim metodo
	
	public void imprimeVetor(int vetor[]) {
		System.out.println("Imprimindo Vetor:");
		for(int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i] + " ");
		}//fim for
		System.out.println();
	}//fim metodo
}//fim class
