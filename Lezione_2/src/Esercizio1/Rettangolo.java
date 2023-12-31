package Esercizio1;

public class Rettangolo {

	public int altezza;
	public int larghezza;
	
	public Rettangolo (int altezza, int larghezza) {
		this.altezza = altezza;
		this.larghezza = larghezza;
	}
	
	public int Perimetro() {
		return (this.altezza + this.larghezza) * 2;
	}
	
	public int Area() {
		return this.altezza * this.larghezza;
	}
	
	public void Dati() {
		System.out.println("Il perimetro del rettangolo è " + this.Perimetro() + "L'area del rettangolo è di " + this.Area());
	}
	
	public static void StampaDueRettangoli(Rettangolo r1, Rettangolo r2) {
		int sommaPerimetri = r1.Perimetro() + r2.Perimetro();
		int sommaAree = r1.Area() + r2.Area();
		System.out.println("Il perimetro del primo rettangolo è " + r1.Perimetro() + 
		"L'area del primo rettangolo è di " + r1.Area() +
		"Il perimetro del secondo rettangolo è " + r2.Perimetro() + 
		"L'area del secondo rettangolo è di " + r2.Area() +
		"La somma dei perimetri è di " + sommaPerimetri +
		"La somma delle aree è di " + sommaAree);
	}


}
