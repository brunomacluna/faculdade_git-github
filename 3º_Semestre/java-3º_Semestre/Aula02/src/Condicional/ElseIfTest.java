package Condicional;

import java.util.Scanner;

public class ElseIfTest {
	public static void main(String[] args) {
		Scanner input;
		input = new Scanner(System.in);
		ElseIf obj;
		obj = new ElseIf();
		System.out.print("Digite a idade: ");
		int idade = input.nextInt();
		String resultado = obj.validarIdade(idade);
		System.out.println("O resultado foi: "+ resultado);
	}//fim main
}//fim class
