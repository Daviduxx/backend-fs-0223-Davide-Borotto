package Esercizio1;

public class MainProject {

	public static void main(String[] args) {
		// ESERCIZIO 1
		
		Rettangolo r1 = new Rettangolo(5,4);
		Rettangolo r2 = new Rettangolo(3,2);
		
		System.out.println("Perimetro: " + r1.Perimetro());
		System.out.println("Area: " + r1.Area());
		
		r1.Dati(r1);
		StampaDueRettangoli(r1,r2);
		
		// ESERCIZIO 2
		
		int[] chiamateIniziali = {};
		
		Sim s1 = new Sim(343231234, chiamateIniziali);
		s1.Stampa(s1);
	}

	private static void StampaDueRettangoli(Rettangolo r1, Rettangolo r2) {
		System.out.println("Il perimetro del primo rettangolo è " + r1.Perimetro() + "L'area del primo rettangolo è di " + r1.Area() +
		"Il perimetro del secondo rettangolo è " + r2.Perimetro() + "L'area del secondo rettangolo è di " + r2.Area());
		System.out.println("La somma dei perimetri è di " + r1.Perimetro() + r2.Perimetro());
		System.out.println("La somma delle aree è di " + r1.Area() + r2.Area());
	}

}
