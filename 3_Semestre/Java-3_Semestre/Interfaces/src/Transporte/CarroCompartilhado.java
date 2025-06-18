package Transporte;

import java.util.HashSet;

public class CarroCompartilhado implements Reservavel{

	HashSet<String> reservas = new HashSet<String>();
	
	@Override
	public boolean reservar(String nome) {
		if(reservas.add(nome)) {
			return true;
		}else {
			return false;
		}//if else
	}//metodo

	@Override
	public boolean cancelar(String nome) {
		for (String reserva : reservas) {
		if(reserva.equals(nome)) {
			reservas.remove(nome);
			return true;
			}
		}//for
		return false;
	}//metodo

	@Override
	public void listarReservas() {
		System.out.println("**********RESERVAS***********");
		for(String reserva : reservas) {
			System.out.println(reserva);
		}//for
		
		System.out.println("*****************************");
		
		
	}
		

}//class
