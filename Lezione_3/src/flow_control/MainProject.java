package flow_control;

public class MainProject {

	public static void main(String[] args) {
		
		// ESERCIZIO 1
		
		Ifelse i1 = new Ifelse("stringa");
		System.out.println(i1.stringaPariDispari("stringaa"));
		
		Ifelse a1 = new Ifelse(2020);
		System.out.println(a1.annoBisestile(a1.anno));
		
		// ESERCIZIO 2
		
		Switch.Stampa(1);
		
		//ESERCIZIO 3
		
		While.Scrivi();
		
		//ESERCIZIO 4
		
		For.Countdown(5);

	}

}
