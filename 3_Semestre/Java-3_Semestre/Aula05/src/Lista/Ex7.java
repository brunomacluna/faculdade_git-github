package Lista;
import java.util.Scanner;
public class Ex7 {

	public void tabuada() {
		
		Scanner input = new Scanner(System.in);
		
		int total = 0, valor;		
		
		do {System.out.print("Digite um valor entre [1 e 10]: ");
			valor = input.nextInt();
		
		if (valor < 1 || valor > 10) {
			System.out.println("[ERROR] Insira um valor entre [1 e 10]");
			}//fim if
		}//fim do
		while (valor < 1 || valor > 10);//coloquei um do while para continuar a pedir um número valido
		
		for (int i = 0; i <= 10; i++) {			
			
		total = valor * i;//o loop for itera de 0 a 10, calcula a cada iteração e imprime na linha debaixo
		System.out.println(valor + " x " + i + " = " + total);
	}//fim for
		
	}//fim metodo tabuada
	
}//fim class Ex7
/*
7. Escreva um programa que solicite ao usuário um valor N, entre 1 e 10, e calcule a tabuada 
desse número. A tabuada deve ser exibida de maneira organizada, mostrando cada operação de 
multiplicação, de 0 a 10, e o respectivo resultado. Discuta como o programa realiza o cálculo 
da tabuada e formata os resultados.
*/