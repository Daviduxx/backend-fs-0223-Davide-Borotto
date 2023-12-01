package com.epicode.classes;

import java.util.Scanner;

public class Video extends ElementoMultimediale implements Multimedia {
	
	private int durata;
	private int volume;
	private int luminosita;
	
	public Video(String titolo, int durata, int volume, int luminosita) {
		super(titolo);
		this.durata = durata;
		this.volume = volume;
		this.luminosita = luminosita;
	}


	@Override
	public void play() {
		if(volume > 0 && durata > 0 && luminosita > 0) {
			String car = "";
			String asterischi = "";
			if(durata > 0 && volume > 0) {
				for(int i = 0; i < durata; i++) {
					for( int j = 0; j < volume; j++) {
						car = car + "!";				
					}
					for (int k = 0; k < luminosita; k++) {
						asterischi = asterischi + "*";
					}
					System.out.println(this.getTitolo() + car + asterischi);
					car = "";
					asterischi = "";
				}
			}	
		}
		else if(volume <= 0 || durata <= 0 || luminosita <= 0) {
			System.out.println("Il contenuto non può essere riprodotto!");
		}
		}
		
	
	public static Video crea() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Hai scelto di creare un video; ora inserisci la durata:");
		int durata = Integer.parseInt(sc.nextLine());
		System.out.println("Il video avrà una durata di " + durata + " minuti. Ora inserisci il volume;");
		int volume = Integer.parseInt(sc.nextLine());
		System.out.println("Hai impostato un volume di " + volume + " Ora inserisci la luminosità:");
		int luminosita = Integer.parseInt(sc.nextLine());
		System.out.println("Hai impostato una luminosita di " + luminosita + " Ora inserisci il titolo:");
		String titolo = sc.nextLine();
		return new Video(titolo, durata, volume, luminosita);
	}

	
	
	//SETTERS
	public void diminuisciLuminosita() {
		if(luminosita > 0) {
			luminosita--;
			System.out.println("Luminosita: " + luminosita);
		}
		else if (luminosita == 0) {
			System.out.println("La luminosita è già al minimo");
		}
	}
	
	public void aumnentaLuminosita() {
		if(luminosita < 20) {
			luminosita++;
			System.out.println("Luminosita: " + luminosita);
		}
		else if (luminosita == 20) {
			System.out.println("La luminosita è già al massimo... Non vorrai mica accecarti!");
		}
	}

	public void abbassaVolume() {
		if(volume > 0) {
			volume--;
			System.out.println("Volume: " + volume);
		}
		else if (volume == 0) {
			System.out.println("Il volume è già al minimo");
		}
	}
	
	public void alzaVolume() {
		if(volume < 20) {
			volume++;
			System.out.println("Volume: " + volume);
		}
		else if (volume == 20) {
			System.out.println("Il volume è già al massimo... Non vorrai sfondarti i timpani!");
		}
	}



	//GETTERS
	public int getDurata() {
		return durata;
	}

	public int getVolume() {
		return volume;
	}

	public int getLuminosita() {
		return luminosita;
	}
	
	
}
