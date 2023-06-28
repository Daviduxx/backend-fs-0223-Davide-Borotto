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
	
	

}
