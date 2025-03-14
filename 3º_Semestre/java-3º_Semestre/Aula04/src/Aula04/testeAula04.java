package Aula04;

import java.util.Scanner; 

public class testeAula04 {
	
	public static void main (String[] args) {
		Loop obj_loop;
		obj_loop = new Loop();
		Scanner entrada;
		entrada = new Scanner(System.in);
		System.out.print("Digite o número de repetições: ");
		int number = entrada.nextInt();
		obj_loop.imprimirValores(number);
		
		obj_loop.contarPares(entrada);
		entrada.close();
		
		
		
	}//fim main
}//fim class
