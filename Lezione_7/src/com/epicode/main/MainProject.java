package com.epicode.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MainProject {

	private static Logger log = LoggerFactory.getLogger(MainProject.class);
	
	public static void main(String[] args) {
		
		esercizioSet();
		
		List<Integer> miaLista = creaIntCasuali(8);

		List<Integer> miaListaModificata = creaLista(miaLista);
		stampaList(miaListaModificata, false);
		
		inserisci("davide", "12345");
		inserisci("gianni", "67890");
		inserisci("pippo", "112233");
		inserisci("pluto", "223344");
		stampaRubrica();
		eliminaContatto("pluto");
		stampaRubrica();
		cercaPerNome("davide");
		cercaContatto("67890");
		

	}
	
	// Esercizio 1
	public static void esercizioSet() {
		
		Scanner sc = new Scanner(System.in);
		Set<String> s1 = new HashSet<String>();
		Set<String> sDuplicate = new HashSet<String>();
		System.out.println("Inserisci la dimensione della collection");
		int userInput = 0;
		try {
		userInput = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException nfe) {
			System.out.println(nfe.getMessage());
		}
		
		for (int i = 0; i < userInput; i++) {
			System.out.println("Inserisci una parola a scelta");
			String elemento = sc.nextLine();
			if(s1.contains(elemento)) {
				sDuplicate.add(elemento);
			}
			else {
				s1.add(elemento);				
			}
		}
		
		for (String s : sDuplicate) {
			log.info("Elemento duplicato: " + s);
		}
		log.info("NUmero di parole distinte: " + s1.size());

		for (String s : s1) {
			log.info("Elemento distinto: " + s);
		}
	}
	
	//Esercizio 2
	public static List<Integer> creaIntCasuali(int x) {
		
		Random randomNumber = new Random();
		List<Integer> l1 = new ArrayList<Integer>();
		for(int i = 0; i < x; i++) {
			l1.add(randomNumber.nextInt(101));
		}
		return l1;
	}
	
	public static List<Integer> creaLista(List<Integer> x) {
		List<Integer> l2 = new ArrayList<Integer>();
		for (int i = 0; i < x.size(); i++) {
			l2.add((Integer) x.get(i));
		}

		for (int j = x.size() - 1; j >= 0; j--) {
			l2.add((Integer) x.get(j));
		}
		return l2;
	}
	
	public static void stampaList(List<Integer> x, Boolean y) {
		
			for(int i = 0; i < x.size(); i++) {
				if(y && i % 2 == 0) {
					log.info("Elemento con indice pari: " + x.get(i));
				} else if(!y && i % 2 != 0) {
					log.info("Elemento con indice dispari: " + x.get(i));
				}
			}	
	}
	
	//ESERCIZIO 3
	static Map<String, String> m = new HashMap<String, String>();
	
	public static void inserisci(String nome, String numero) {
		m.put(nome, numero);
	}
	
	public static void eliminaContatto(String nome) {
		m.remove(nome);
	}
	
	public static void cercaContatto(String numero) {
		Set<String> nomi = m.keySet();
		for (Object c : nomi) {
			if(numero.equals(m.get(c))) {
				log.info("Chiave: " + c + " valore: " + numero);
			}
		}
	}
	
	public static void cercaPerNome(String nome) {
		log.info("Nome: " + nome + "numero: " + m.get(nome));
	}
	
	public static void stampaRubrica() {
		Set<String> nomi = m.keySet();
		Object[] rubrica = nomi.toArray();
		for (Object c : rubrica) {
			log.info("Nome: " + c + " Numero di telefono: " + m.get(c));
		}
	}

}
