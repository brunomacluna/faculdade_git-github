package Lista;

public class Ex1 {
	public void ex1() {
		int i = 1;
		int contador = 0;
		
		for (i = 1; i <= 500; i++) {
		
		if (i % 2 != 0 && i % 3 == 0) {
			contador++;			
			System.out.println("Impares e mutiplos de 3: "+i);
			System.out.println("O total de números nessa condição é: "+contador);
			}//fim for
		}//fim if
	}//fim metodo
}//fim class
/*  
 1. Desenvolva um algoritmo que, dentro de um intervalo específico de números (de 1
a 500), selecione e some os números que atendam a dois critérios: serem ímpares e
também múltiplos de três. Além disso, exiba o total de números que atenderam a
esses critérios.
 */