package Esercizio1;

public class Rettangolo {

	public int altezza;
	public int larghezza;
	
	public Rettangolo (int altezza, int larghezza) {
		this.altezza = altezza;
		this.larghezza = larghezza;
	}
	
	public int Perimetro() {
		int perimetro = (this.altezza + this.larghezza) * 2;
		return perimetro;
	}
	
	public int Area() {
		int area = this.altezza * this.larghezza;
		return area;
	}
	
	public void Dati(Rettangolo r) {
		System.out.println("Il perimetro del rettangolo è " + r.Perimetro() + "L'area del rettangolo è di " + r.Area());
	}
	
	public static void StampaDueRettangoli(Rettangolo r1, Rettangolo r2) {
		System.out.println("Il perimetro del primo rettangolo è " + r1.Perimetro() + "L'area del primo rettangolo è di " + r1.Area() +
		"Il perimetro del secondo rettangolo è " + r2.Perimetro() + "L'area del secondo rettangolo è di " + r2.Area());
		System.out.println("La somma dei perimetri è di " + r1.Perimetro() + r2.Perimetro());
	}

}
