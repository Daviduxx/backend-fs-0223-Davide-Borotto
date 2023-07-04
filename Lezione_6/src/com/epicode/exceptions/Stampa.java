package com.epicode.exceptions;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Stampa {
	
	static Logger log = LoggerFactory.getLogger(Stampa.class);
	
	private static int[] arr = new int[5];
	private static int min = 0;
	private static int max = 10;
	
	public static int randomNumber() {
		return (int)Math.floor(Math.random() * 10);
		}
	
	public static void stampaInArr() {
		while(true) {
			Scanner sc = new Scanner(System.in);
			log.info("info");
			try {
				int posizione = Integer.parseInt(sc.nextLine());

					arr[posizione -1] = randomNumber();
					System.out.println(arr[posizione]);
				
				if(posizione == 0) {
					break;
				}
			}
			catch (NumberFormatException e){
				System.out.println("Formato del numero non corretto!!!");
			}
			catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Numeri consentiti da 1 a 5");
			}
			finally {
				System.out.println("finally");
			}
		}
		
	}
}
