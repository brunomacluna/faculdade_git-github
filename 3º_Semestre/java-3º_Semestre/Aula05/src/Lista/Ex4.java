package Lista;

import java.util.Scanner;
public class Ex4 {
	
	public void ex() {
		Scanner input;
		input = new Scanner(System.in);
		int intervalo1 = 0, intervalo2 = 0, intervalo3 = 0, intervalo4 = 0;
		while (true) {
			System.out.print("Digite um valor: ");
			int v = input.nextInt();
			if (v >= 0 && v <= 25) {
				intervalo1++;
			}//fim if
			else if (v >= 26 && v <= 50) {
				intervalo2++;
			}//fim else if
			else if (v >= 51 && v <= 75) {
				intervalo3++;
			}//fim else if
			else if (v >= 76 && v <= 100) {
				intervalo4++;
			}//fim else if
			else {
				System.out.print("Intervalo fora do range!");
			}//fim else
			System.out.print("Deseja continuar? [s/n]");
			if (input.next().toLowerCase().equals("n")) {
				break;
			}
		}//fim while
		System.out.println("Quantos valores no intervalo de 0 a 25? "+intervalo1);
		System.out.println("Quantos valores no intervalo de 26 a 50? "+intervalo2);
		System.out.println("Quantos valores no intervalo de 51 a 75? "+intervalo3);
		System.out.println("Quantos valores no intervalo de 76 a 100? "+intervalo4);
	}//fim metodo
}//fimm class
