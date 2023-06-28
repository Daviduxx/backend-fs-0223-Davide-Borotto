package flow_control;

public class Switch {
	
	public static void Stampa(int numero) {
		switch(numero) {
		case 0:
			System.out.println("zero");
			break;
		case 1:
			System.out.println("uno");
			break;
		case 2:
			System.out.println("due");
			break;
		case 3:
			System.out.println("tre");
			break;
		default:
			System.out.println("errore");
		}
	}

}
