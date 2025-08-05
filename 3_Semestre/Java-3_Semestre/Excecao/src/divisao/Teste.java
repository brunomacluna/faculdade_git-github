package divisao;

import java.util.Scanner;

public class Teste {

	public static void main(String[] args) {
		
		int a = 10;
		int b = 0;
		
	/*	try {
			double resultado = a / b;
			System.out.println("Resultado: " + resultado);
		} catch(ArithmeticException erro) {
			System.err.println(erro.getMessage());
		} finally {
			System.out.println("Continue excecutando!");
		}
		*/
		
		Scanner input = new Scanner(System.in);
		
		try {
			
			System.out.print("Digite seu nome: ");
			String nome = input.next();		
		} catch (Exception erro) {
			System.out.println("Entrada inesperada" + erro.getMessage());
			erro.printStackTrace();
		} finally {
			System.out.println("Continue excecutando: ");
		}
		
	}//main
	
}
