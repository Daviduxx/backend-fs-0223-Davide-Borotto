package flow_control;

import java.util.Scanner;

public class While {
	
	public static void Scrivi() {
		
		Scanner sc = new Scanner(System.in);
			while(true) {
			System.out.println("Scrivi una stringa a piacere:");
			String test = sc.nextLine();
			if(test.equals(":q")) {
				break;
			}
			String[] testoSplittato = test.split("");
			for(int i = 0; i < testoSplittato.length; i++) {
				System.out.println(testoSplittato[i] + ",");
				}
			}
			sc.close();

		

}
}