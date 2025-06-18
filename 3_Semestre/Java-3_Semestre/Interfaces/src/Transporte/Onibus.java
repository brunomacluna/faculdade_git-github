package Transporte;

import java.util.ArrayList;

public class Onibus implements Reservavel{

	final int LIMIT=5;
	ArrayList<String> reservas;
	public Onibus() {
		reservas = new ArrayList<String>(); 
	}//construtor
	@Override
	public boolean reservar(String nome) {
		if(reservas.size() < LIMIT) {
			reservas.add(nome);
			return true;
		} else {
			return false;
		}// if else
	}//metodo	

	@Override
	public boolean cancelar(String nome) {
		int indice = -1;
		boolean sentinela = false;
		for (String reserva : reservas) {
			indice++;
			if(reserva.equals(nome)) {
				sentinela = true;
				break;
			}
		}//for
		if(sentinela) {
			reservas.remove(indice);
			return true;
		}else {
			return false;
		}		
	}//metodo

	@Override
	public void listarReservas() {
		System.out.println("**********RESERVAS***********");
		for(String reserva : reservas) {
			System.out.println(reserva);
		}//for
		
		System.out.println("*****************************");
		
	}//metodo
	
}//class
