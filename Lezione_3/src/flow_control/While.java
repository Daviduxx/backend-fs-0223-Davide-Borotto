package flow_control;

import java.util.Scanner;

public class While {
	
	public static void Scrivi() {
		//String test = null;
		Scanner sc = new Scanner(System.in);
			do {
			System.out.println("Scrivi un carattere a piacere:");
			String test = sc.nextLine();
			System.out.println(test.split(","));
			
		}
		while (test != ":q");
			sc.close();	

}
}