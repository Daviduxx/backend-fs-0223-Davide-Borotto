package com.epicode.main;

import java.util.Scanner;

import com.epicode.classes.Audio;
import com.epicode.classes.ElementoMultimediale;
import com.epicode.classes.Immagine;
import com.epicode.classes.Video;

public class MainProject {

	public static void main(String[] args) {
		
		//TEST DEI METODI
		Audio a1 = new Audio("Highway to Hell", 4, 18);
		a1.play();
		System.out.println(a1.getVolume());
		a1.alzaVolume();
		a1.alzaVolume();
		a1.alzaVolume();
		a1.abbassaVolume();
		a1.abbassaVolume();
		a1.abbassaVolume();
		a1.abbassaVolume();
		a1.play();
		
		Video v1 = new Video("VIDEO DI TEST", 7, 18, 18);
		v1.play();
		System.out.println(v1.getVolume());
		v1.alzaVolume();
		v1.alzaVolume();
		v1.alzaVolume();
		v1.abbassaVolume();
		v1.play();
		v1.abbassaVolume();
		System.out.println(v1.getLuminosita());
		v1.aumnentaLuminosita();
		v1.aumnentaLuminosita();
		v1.aumnentaLuminosita();
		v1.diminuisciLuminosita();
		v1.diminuisciLuminosita();
		v1.diminuisciLuminosita();
		v1.aumnentaLuminosita();
		v1.play();
		
		
		Immagine i1 = new Immagine("immagine di test", 18);
		i1.show();
		System.out.println(i1.getLuminosita());
		i1.aumnentaLuminosita();
		i1.aumnentaLuminosita();
		i1.aumnentaLuminosita();
		i1.diminuisciLuminosita();
		i1.diminuisciLuminosita();
		i1.diminuisciLuminosita();
		i1.show();
		
		
		// LETTORE MULTIMEDIALE
		ElementoMultimediale[] contenuti = new ElementoMultimediale[5];
		String[] tipi = {"VIDEO", "AUDIO", "IMMAGINE"};
		
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < contenuti.length; i++) {
			System.out.println("Che tipo di contenuto vuoi creare?");
			for(int j = 0; j < tipi.length; j++) {
				System.out.println("Premi " + (j + 1) + " per creare un " + tipi[j]);
			}
		
			int tipoContenuto = Integer.parseInt(sc.nextLine());
			switch(tipoContenuto) {
			case 1:
				contenuti[i] = Video.crea();
				break;	
			case 2:
				contenuti[i] = Audio.crea();
				break;
			case 3: 
				contenuti[i] = Immagine.crea();
				break;
				default:
					i -= 1;
					System.out.println("Qualcosa è andato storto");
					System.out.println("Reinserisci i dati, ma ricorda che sono concessi solamente i caratteri 1, 2 e 3");
			}
			if(i == contenuti.length - 1) {
				System.out.println("Complimenti, hai riempito la memoria del lettore. Ora puoi riprodurre i contenuti che vuoi");
			}
			else {
				System.out.println("Inserisci ancora un contenuto");
			}
		}
		
		while(true) {
			
			for (int k = 0; k < contenuti.length; k++) {
				System.out.println("Premi " + (k + 1) + " per riprodurre " + contenuti[k].getTitolo());
			}
			int index = Integer.parseInt(sc.nextLine()) - 1;
			if(index == -1) {
				System.out.println("Hai stoppato l'esecuzione");
				System.out.println("Premi 0 per confermare lo stop, premi un qualsiasi altro numero per continuare");
				int continua = Integer.parseInt(sc.nextLine());
				if(continua == 0) {
					System.out.println("Player stoppato");
					break;					
				}
				else {
					System.out.println("Esecuzione di nuovo in corso!");
					continue;
				}
			}
			else if(index < -1 || index > contenuti.length) {
				System.out.println("L'elemento inserito non è valido. Sono validi solo i numeri da 1 a " + contenuti.length);
				continue;
			}
			else if(contenuti[index] instanceof Video) {
				Video v = (Video) contenuti[index];
				v.play();	
			}
			else if(contenuti[index] instanceof Audio) {
				Audio a = (Audio) contenuti[index];
				a.play();				
			}
			else if(contenuti[index] instanceof Immagine) {
				Immagine im = (Immagine) contenuti[index];
				im.show();	
			}		
		}
		sc.close();
	}
}
