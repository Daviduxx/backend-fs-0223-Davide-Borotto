package Esercizio1;

public class MainProject {

	public static void main(String[] args) {
		
		// ESERCIZIO 1
		Rettangolo r1 = new Rettangolo(5,4);
		Rettangolo r2 = new Rettangolo(3,2);
		System.out.println("Perimetro: " + r1.Perimetro());
		System.out.println("Area: " + r1.Area());
		
		r1.Dati(r1);
		Rettangolo.StampaDueRettangoli(r1,r2);
		
		// ESERCIZIO 2
		Sim s1 = new Sim(343231234);
		s1.Stampa();
	}

	
}
