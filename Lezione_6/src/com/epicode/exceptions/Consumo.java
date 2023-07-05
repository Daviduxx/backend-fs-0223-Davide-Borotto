package com.epicode.exceptions;

import java.util.Scanner;

public class Consumo {

	public static void calcola() {
		Scanner sc = new Scanner(System.in);
		
			System.out.println("Quanti km hai percorso?");
			int km = Integer.parseInt(sc.nextLine());
			System.out.println("Quanti litri ha consumato?");
			int litri = Integer.parseInt(sc.nextLine());
			try {
			int rapporto = km / litri;
			System.out.println("Hai percorso " + rapporto + " per ogni litro");
		}
		catch (ArithmeticException e) {
			System.out.println("Divisione per 0 non eseguibile");
		}
		
	}
}
