package Esercizio1;

public class Sim {
	
	int numeroTelefono;
	Chiamata[] chiamate;
	int credito;
	
	public Sim(int numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
		this.chiamate = new Chiamata[5];
		this.credito = 0;
	}
	

	public void Stampa() {
		System.out.println("Numero di telefono: " + this.numeroTelefono);
		System.out.println("Credito: " + this.credito);
		System.out.println("Chiamate effettuate :");
		for (int i = 0; i < this.chiamate.length; i++) {
			if(this.chiamate[i] != null) {
				System.out.println(this.chiamate[i].numeroChiamato + "durata: " + this.chiamate[i].numeroChiamato);
			}
		}
	}
	

}
