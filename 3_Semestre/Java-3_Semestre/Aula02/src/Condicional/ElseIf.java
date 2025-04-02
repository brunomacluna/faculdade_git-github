package Condicional;

public class ElseIf {
	public String validarIdade(int idade) {
		String out = "";
		if(idade >= 18) {
			out = "Você é maior de idade";
		}//Fim if
		else {
			out = "Você é menor de idade";
		}//fim else
		return out;
	}//fim metodo
}//fim class
