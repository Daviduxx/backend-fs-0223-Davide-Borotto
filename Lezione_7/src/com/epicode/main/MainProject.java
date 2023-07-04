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
		
		List miaLista = creaIntCasuali(8);
		System.out.println(miaLista);
		List miaListaModificata = creaLista(miaLista);
		System.out.println(miaListaModificata);
		stampaList(miaListaModificata, false);
		
		inserisci("davide", "12345");
		inserisci("gianni", "67890");
		inserisci("pippo", "112233");
		inserisci("pluto", "223344");
		stampaRubrica();
		eliminaContatto("pluto");
		stampaRubrica();
		cercaPerNome("davide");
		
		

	}
	
	// Esercizio 1
	public static void esercizioSet() {
		
		Scanner sc = new Scanner(System.in);
		Set<String> s1 = new HashSet<String>();
		Set<String> sDuplicate = new HashSet<String>();
		
		int userInput = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < userInput; i++) {
			String elemento = sc.nextLine();
			if(s1.contains(elemento)) {
				sDuplicate.add(elemento);
			}
			else {
				s1.add(elemento);				
			}
		}
		Object[] arr = sDuplicate.toArray();
		for (Object s : arr) {
			log.info("Elemento duplicato: " + s.toString());
		}
		log.info("NUmero di parole distinte: " + s1.size());
		Object[] s1Arr = s1.toArray();
		for (Object s : s1Arr) {
			log.info("Elemento distinto: " + s.toString());
		}
	}
	
	//Esercizio 2
	public static List creaIntCasuali(int x) {
		
		Random randomNumber = new Random();
		List<Integer> l1 = new ArrayList<Integer>();
		for(int i = 0; i < x; i++) {
			l1.add(randomNumber.nextInt(101));
		}
		return l1;
	}
	
	public static List creaLista(List x) {
		List<Integer> l2 = new ArrayList<Integer>();
		for (int i = 0; i < x.size(); i++) {
			l2.add((Integer) x.get(i));
		}
		log.info(x.size() + "lunvhezza del singolo array");
		for (int j = x.size() - 1; j >= 0; j--) {
			l2.add((Integer) x.get(j));
		}
		return l2;
	}
	
	public static void stampaList(List x, Boolean y) {
		if(y) {
			for(int i = 0; i < x.size(); i++) {
				if(i % 2 == 0) {
					log.info("Elemento con indice pari: " + x.get(i));
				}
			}
		}
		else {
			for(int j = 0; j < x.size(); j++) {
				if(j % 2 != 0) {
					log.info("Elemento con indice dispari: " + x.get(j));
				}
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
	
//	public static void cercaContatto(String numero) {
//	
//	    for (Entry<String, String> entry : m.entrySet()) {
//	        if (entry.getValue().equals(value)) {
//	            return entry.getKey();
//	        }
//	    }
//
//	}
	
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
