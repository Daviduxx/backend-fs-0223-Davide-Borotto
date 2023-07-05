package com.epicode.exceptions;

import java.util.Random;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainProject {

	static Logger log = LoggerFactory.getLogger(MainProject.class);
	
	public static void main(String[] args) {
		
		
		//ESERCIZIO 1
//		int[] arr = generaArr();
//		cambiaValore(arr);
		
		//esercizio 2
		Consumo.calcola();
	}
	
	// ESERCIZIO 1
	public static int[] generaArr() {
		int[] arr = new int[5];
		Random rand = new Random();
		for(int i=0; i<arr.length; i++) {
		
			arr[i] = rand.nextInt(11);
		}
		
		for (int i = 0; i < arr.length; i++) {
			log.info("Posizione: " + i + " Valore: " + arr[i]);
		}
		
		return arr;
	}
	
	public static void cambiaValore(int[] arr) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("Inserisci un nuovo valore da 1 a 10 oppure 0 per uscire: ");
			int val = Integer.parseInt(sc.nextLine());
			if(val == 0) {
				log.info("FINE");
				return;
			}
			System.out.print("Inserisci la posizione dove inserire il nuovo valore:");
			int pos = Integer.parseInt(sc.nextLine());
			try {
				arr[pos] = val;				
			}
			catch (ArrayIndexOutOfBoundsException e){
				log.error(e.getMessage());
			}
		}
	}

}
