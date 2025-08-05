package Encapsulamento;

import java.util.List;

public class ContaBancariaTest {
	public static void main(String[] args) {
		ContaBancaria obj = new ContaBancaria("Maria Joaquina", 0);
		obj.depositar(2456.78);
		obj.sacar(220);
		obj.sacar(120);
		obj.sacar(800);
		obj.sacar(700);
		System.out.println("Titular da conta "+obj.getTitular());
		System.out.println("Saldo da conta "+obj.getSaldo());
		List<String> historico = obj.getHistorico();
		System.out.println("\n***********Resumo do mês************");
		for (String operacao : historico ) {
			System.out.println(operacao);
		}
	}//main
}//class
