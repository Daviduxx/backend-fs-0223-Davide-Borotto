package com.epicode.es2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyThread extends Thread {
	
	private Logger log = LoggerFactory.getLogger(MyThread.class);
	
	private int somma = 0;
	private int somma1;
	private int somma2;
	private int somma3;
	private int inizio;
	private int fine;

	

	public MyThread(int inizio, int fine) {
		super();
		this.somma = 0;
		this.inizio = inizio;
		this.fine = fine;
	}



	public MyThread(int somma1, int somma2, int somma3) {
		super();
		this.somma1 = somma1;
		this.somma2 = somma2;
		this.somma3 = somma3;
	}



	@Override
	public void run() {
		int sommaTotale = somma1 + somma2 + somma3;
		 log.info("somma totale: " + sommaTotale);
	}
	
	public int somma(int[] arr) {
		for(int i = inizio; i < fine; i++) {
			somma += arr[i];
		}
		log.info("somma:" + somma);
		return somma;
	}
	
	
}
