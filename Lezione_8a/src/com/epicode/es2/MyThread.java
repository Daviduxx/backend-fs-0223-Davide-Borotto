package com.epicode.es2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyThread extends Thread {
	
	private Logger log = LoggerFactory.getLogger(MyThread.class);
	
	private int[] arr;
	private int inizio;
	private int fine;
	int somma;


	public MyThread(int[] arr, int inizio, int fine, int somma) {
		this.arr = arr;
		this.inizio = inizio;
		this.fine = fine;
		this.somma = somma;
	}


	@Override
	public void run() {
		int sommaParziale = 0;
		for(int i = inizio; i < fine; i++) {
			sommaParziale += arr[i];
		}
		this.somma += sommaParziale;
		log.info("Somma parziale: " + sommaParziale);
	}
	
	
	
}
