package tipo;

public class NovaClasse {
	public static void main(String argumentos[]) {
		int idade = 21;
		long numero = 9999999999L;
		double troco = 2.45;
		float salario = 1234.56F;
		char letra = 'a';
		String nome = "Maria Francisca";
		boolean isJovem = true;
				
		System.out.println("Nome:"+nome);
		System.out.print("Ela é jovem? "+isJovem +"\n");
		System.out.printf("A %s é jovem? %b e qual é o seu salário? %f\n", nome, isJovem, salario);
	}
}
