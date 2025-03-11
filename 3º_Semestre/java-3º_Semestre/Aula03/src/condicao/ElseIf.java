package condicao;

public class ElseIf {
	public String verificarNota(int nota) {
		if(nota >= 90) {
			return "Nota A";
		}//fim if
		else if(nota >= 80) {
			return "Nota B";
		}//fim else if
		else if(nota >= 70) {
			return "Nota C";
		}//fim else if
		else if(nota >= 60) {
			return "Nota D";
		}//fim else if
		else {
			return "Reprovado";
		}//fim else
	}//fim metodo
	
	public double calcular(double num1, double num2, char operador) {
		double resultado = -99999;
		switch(operador) {
		case '+':
			resultado = num1 + num2;
		break;
		case '-':
			resultado = num1 - num2;
		break;
		case '*':
			resultado = num1 * num2;
		break;
		case '/':
			if(num2 != 0) {
				resultado = num1 / num2;
			}//fim if
			else {
				System.out.println("Não se pode dividir por zero.");
			}//fim else
		break;
		case '%':
			resultado = num1 % num2;
		break;
		default:
			System.out.println("Operador inválido");			
		}//fim switch
		return resultado;
	}//fim metodo
	
	public int potencia(int n1, int expoente) {
		int resultPotencia = (int) Math.pow(n1, expoente);;
		return resultPotencia;
	}
	
	public String semaforo(String sinal) {
		String sinaleiro = "";
		case 'verde':
			sinaleiro = ""
			
	}fim metodo
}//fim class








