package tipo;

import java.util.Scanner;

public class CapturaDado {
	public static void main(String args[]) {
		Scanner input; // declara o objeto
		input = new Scanner(System.in); // instancia o objeto
		System.out.print("Digite seu nome: ");
		String nomePessoa = input.nextLine();
		
		System.out.print("Digite sua idade: ");
		int idadePessoa = input.nextInt();
		
		System.out.print("Digite seu salário: ");
		double salarioPessoa = input.nextDouble();
		
		System.out.println("Nome: "+ nomePessoa);
		System.out.println("Idade: "+ idadePessoa);
		System.out.println("Salário: "+ salarioPessoa);
	}
}
