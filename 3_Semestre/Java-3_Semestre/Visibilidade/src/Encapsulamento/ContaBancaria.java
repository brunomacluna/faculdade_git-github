package Encapsulamento;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ContaBancaria {
	private String titular;
	private double saldo;
	private List<String> historico;
	
	protected ContaBancaria(String titular, double saldo) {
		Scanner input = new Scanner(System.in);
		this.titular = titular;
		this.historico = new ArrayList<String>();
		if (saldo < 0) {
			System.out.println("Você digitou um saldo negativo, deseja alterar o saldo? digite [s/n]: ");
			this.saldo = 0;
			if (input.next().toLowerCase().equals("s")) {
				System.out.print("Digite o novo saldo: ");
				saldo = input.nextDouble();
			}
			this.saldo = saldo < 0 ? 0 : saldo;
		}//if
		else {
			this.saldo = saldo;
		}//else
	}//fim metodo
	public void setTitular(String novoTitular) {
		this.titular = novoTitular;
	}//fim setTitular
	public String getTitular() {
		return this.titular;
	}//fim getTitular
	// Método para obter o saldo
	public double getSaldo() {
	    return this.saldo;
	}
	public void setSaldo(double novoSaldo) {
		this.saldo = novoSaldo;
	}//fim setSaldo
	// Método para obter o histórico (retorna a lista)
	public List<String> getHistorico() {
	    return this.historico;
	}
	public void depositar(double novoDeposito) {
		if (novoDeposito <= 0) {
			System.out.println("Valor Inválido");
		} else {
			this.saldo = this.saldo + novoDeposito;
			historico.add("Deposito no valor de "+ novoDeposito);
			System.out.println("Deposito no valor de " + novoDeposito + "feito com sucesso.");
		}//ifelse
	}//fim depositar
	public void sacar(double valorSaque) {
		if(valorSaque <= 0) {
			System.out.println("O valor digitado não é o esperado!!");
		} else {
			this.saldo = this.saldo - valorSaque;
			historico.add("Saque no valor de "+ valorSaque);
			System.out.println("Saque no valor de "+ valorSaque +"feito com sucesso!");
		}//ifelse
	}//fim sacar
}//fim class
