package Vetor;
import java.util.Scanner;

public class VetoresTeste {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Vetores obj = new Vetores();
		System.out.print("Quantos valores gostaria de armazernar? ");
		int qtd = input.nextInt();
		int vetorAux[] = obj.createVetor(qtd, input);
		int maior = obj.maiorElemento(vetorAux);
		int menor = obj.menorElemento(vetorAux);
		obj.imprimeVetor(vetorAux);
		System.out.println("O maior elemento é: "+ maior);
		System.out.println("O menor elemento é: "+ menor);
		
	}//fim main
}//fim class
