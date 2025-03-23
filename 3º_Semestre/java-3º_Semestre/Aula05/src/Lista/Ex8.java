package Lista;
import java.util.Scanner;
public class Ex8 {

	public void fatoracao() {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Digite um número a ser Fatorado: ");
		int numero = input.nextInt();
		
		int resultado = 1;
		
		for (int i = 1; numero > 1;) {// o for para no 1
			resultado *= numero;//multiplica o valor atual de resultado"pelo numero atual
			numero -= 1;//decrementa o numero passando para o proximo fator na sequencia
			System.out.println(resultado + " x " + numero + " = " + (resultado * numero));
			
		}//fim for
		
		System.out.println("O fatorial é "+resultado);
	}//fim metodo fatoracao
	
}//fim class Ex8
/*
8. Desenvolva um programa que receba um valor inicial A e imprima a sequência de
operações necessárias para calcular o fatorial de A, além de exibir o resultado final
do cálculo. Como exemplo, mostre a sequência de multiplicações e o resultado final
para o fatorial de 5. Explique como o programa gerencia o processo de multiplicação
em sequência.
*/