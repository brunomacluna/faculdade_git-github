package Pack1;

public class Visibilidade {
	
	public void imprimirPublic() {
		System.out.println("Imprimindo método publico");	
	}//fim imprimirPublic
	
	protected void imprimirProtected() {
		System.out.println("Imprimindo método protegido");
		this.imprimirPrivate();
	}//fim imprimirProtected
	
	private void imprimirPrivate() {
		System.out.println("Imprimindo método privado");
	}//fim imprimirPrivate
}//fim class
