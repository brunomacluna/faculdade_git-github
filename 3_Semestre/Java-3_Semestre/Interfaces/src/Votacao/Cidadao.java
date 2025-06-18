package Votacao;

public class Cidadao extends Pessoa implements Votavel{
	public Cidadao (String nome, int idade) {
		super(nome, idade);
	}
	@Override
	public void Votar() {
		if(super.getIdade()>17 && super.getIdade()<70) {
			System.out.println(super.getIdade() + " é obrigado a votar!");
		}else if(super.getIdade()>15) {
			System.out.println(super.getIdade() + " esta´ apto a votar!");
		}else {
			System.out.println(super.getIdade() + " não pode votar!");
		}
		
	}//metodo
}//class

