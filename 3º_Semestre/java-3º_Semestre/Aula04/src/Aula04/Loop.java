package Aula04;

import java.util.Scanner;

public class Loop {
	
	public void imprimirValores(int qtd) {
		int i;
		
		for(i = 1; i <= qtd; i++) {
			System.out.println("Númmero: " + i);
		}//fim for
	}//fim metodo
	
	public void contar(int contador, Scanner entrada) {
		int repetiu = 0;
		while(contador != 0) {
			repetiu++;
			System.out.print("Repetindo \n"+ repetiu);
			System.out.print("\nDigite qualquer valor para continuar: " );
			contador = entrada.nextInt();
		}//fim while
	}//fim metodo
	
	public void contaMais(int contador) {
		for (int i = 1; i <= contador; i++) {
			System.out.println("Repetiu: "+i);
		}//fim for
	}
	
	public void core (Scanner input) {
		while(true) {
			System.out.print("Repete quantas vezes? ");
			int valor = input.nextInt();
			if(valor <= 0) {
				break;
			}//fim if
			this.contaMais(valor);
			System.out.println("*****Finalizando a impressão*****");
		}//fim while
	}//fim metodo
	
	public void exemploDo(Scanner input) {
		int v1 = 0;
		do {
			System.out.print("Digite um valor entre 1 e 10: ");
			v1 = input.nextInt();
		}while(v1 < 1 || v1 > 10);
		System.out.println("O valor final de v1? "+v1);
	}//fim metodo
	
	public void contarPares(Scanner input) {
		System.out.println("Digite um número maior 10 at´e 100: ");
		int num = input.nextInt();
		int pares = 0;
		for(int i = 1; i <= num; i++) {
			
		}//fim for
		
	}//fim contarPares
}//fim class
