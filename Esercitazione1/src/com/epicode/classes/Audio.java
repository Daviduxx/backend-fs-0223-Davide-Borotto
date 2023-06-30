package com.epicode.classes;

import java.util.Scanner;

public class Audio extends ElementoMultimediale implements Multimedia{
	
	private int durata;
	private int volume;
	
	public Audio(String titolo, int durata, int volume) {
		super(titolo);
		this.durata = durata;
		this.volume = volume;
	}

	@Override
	public void play() {
		if(volume > 0 && durata > 0) {
			String car = "";
			if(durata > 0 && volume > 0) {
				for(int i = 0; i < durata; i++) {
					for( int j = 0; j < volume; j++) {
						car = car + "!";				
					}
					System.out.println(this.getTitolo() + car);
					car = "";
				}
			}
		}
		else if(volume <= 0 || durata <= 0) {
			System.out.println("Il contenuto non può essere riprodotto!");
		}
	}
	
	public static Audio crea() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Hai scelto di creare un audio; ora inserisci la durata:");
		int durata = Integer.parseInt(sc.nextLine());
		System.out.println("L'audio avrà una durata di " + durata + " minuti. Ora inserisci il volume;");
		int volume = Integer.parseInt(sc.nextLine());
		System.out.println("Hai impostato un volume di " + volume + " Ora inserisci il titolo:");
		String titolo = sc.nextLine();
		return new Audio(titolo, durata, volume);
	}
	
	
	
	//SETTER
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
	
	
	//GETTER
	public int getDurata() {
		return durata;
	}

	public int getVolume() {
		return volume;
	}
	
	
	
}
