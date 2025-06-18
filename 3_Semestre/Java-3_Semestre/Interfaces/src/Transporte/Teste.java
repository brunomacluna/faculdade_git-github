package Transporte;

import java.uti.Scanner;

public class Teste {

	public static void main(String[] args) {
		java.util.Scanner input = new Scanner(System.in);
		Onibus objOnibus = new Onibus();
		CarroCompartilhado objCarro = new CarroCompartilhado();

		//trabalhar com onibus
		while(true) {
			System.out.println("1-Para reservar em onibus");
			System.out.println("2-Para cancelar em onibus");
			System.out.println("3-Para ver reservas em onibus");
			System.out.println("4-Para encerrar");
			int opcao = input.nextInt();
			if(opcao==1) {
				System.out.println("Digite o nome do cliente: ");
				if(objOnibus.reservar(input.next())) {
					System.out.println("Reserva efetuada com sucesso!");
				}else {
					System.out.println("Não ha´ mais vagas no ônibus!");
				}
			}else if(opcao==2) {
				System.out.println("Digite o nome do cliente: ");
				if(objOnibus.cancelar(input.next())) {
					System.out.println("Reserva cancelada com sucesso!");
				}else {
					System.out.println("Reserva não encontrada!");
				}
			}else if(opcao==3) {
				objOnibus.listarReservas();
			}else if(opcao==4) {
				System.out.println("Encerrando aplicação!");
			}else {
				System.out.println("Opção inválida!");
			}
			
		}//while
	}//main

}//class
