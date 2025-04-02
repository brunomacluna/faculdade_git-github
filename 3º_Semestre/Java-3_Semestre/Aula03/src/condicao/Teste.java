package condicao;

import java.util.Scanner;

public class Teste {
	public static void main(String[] args) {
		Scanner input;
		input = new Scanner(System.in);
		ElseIf obj;
		obj = new ElseIf();
		System.out.print("Digite sua nota: ");
		int notaAluno = input.nextInt();
		String out = obj.verificarNota(notaAluno);
		System.out.println(out);
		
		System.out.println("Digite a primeiro valor: ");
		double numero1 = input.nextDouble();
		System.out.println("Digite a segundo valor: ");
		double numero2 = input.nextDouble();
		System.out.println("Digite o operador: ");
		char operador = input.next().charAt(0);
		double resultCalculo = obj.calcular(numero1, numero2, operador);
		System.out.printf("O resultado é: %.2f", resultCalculo);
		
		System.out.println("\nDigite o número: ");
		int numeroP = input.nextInt();
		System.out.println("Digite o expoente: ");
		int numeroE = input.nextInt();
		int resultPotencia = obj.potencia(numeroP, numeroE);
		System.out.println("O resultado da potencia é: " + resultPotencia);
		input.close();
	}//fim metodo
}//fim class



