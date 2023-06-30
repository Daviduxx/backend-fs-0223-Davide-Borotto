package com.epicode.classes;

import java.util.Scanner;

public class Immagine extends ElementoMultimediale implements InterfaceImmagine{
	
	private int luminosita;
	
	
	public Immagine(String titolo, int luminosita) {
		super(titolo);
		this.luminosita = luminosita;
	}
	
	public void show() {
		String car = "";
		if(luminosita > 0) {
				for( int j = 0; j < luminosita; j++) {
					car = car + "*";				
				}
				System.out.println(this.getTitolo() + car);
				car = "";
		}
	}

	public static Immagine crea() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Hai scelto di creare un'immagine; ora inserisci la luminosita:");
		int luminosita = Integer.parseInt(sc.nextLine());
		System.out.println("L'immagine avrà una luminosita di " + luminosita + ". Ora inserisci il titolo:");
		String titolo = sc.nextLine();
		return new Immagine(titolo, luminosita);
	}
	
	//SETTERS
	public void aumnentaLuminosita() {
		if(luminosita < 20) {
			luminosita++;
			System.out.println("Luminosita: " + luminosita);
		}
		else if (luminosita == 20) {
			System.out.println("La luminosita è già al massimo... Non vorrai mica accecarti!");
		}
	}
	
	public void diminuisciLuminosita() {
		if(luminosita > 0) {
			luminosita--;
			System.out.println("Luminosita: " + luminosita);
		}
		else if (luminosita == 0) {
			System.out.println("La luminosita è già al minimo");
		}
	}
	
	//GETTERS
	public int getLuminosita() {
		return luminosita;
	}
	
}


