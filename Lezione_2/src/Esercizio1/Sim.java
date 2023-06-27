package Esercizio1;

public class Sim {
	
	
	public int numeroTelefono;
	public int[] chiamate = {};
	public static int credito = 0;
	
	public Sim(int numeroTelefono, int[]chiamate) {
		this.numeroTelefono = numeroTelefono;
		this.chiamate = chiamate;
		credito = 0;
	}
	

	public void Stampa(Sim s) {
		System.out.println("Numero di telefono: " + this.numeroTelefono);
		System.out.println("Credito: " + credito);
		System.out.println("Chiamate effettuate :" + this.chiamate);
	}

}
