package Transporte;

public interface Reservavel {
	public boolean reservar(String nome);
	public boolean cancelar(String nome);
	public void listarReservas();
}
