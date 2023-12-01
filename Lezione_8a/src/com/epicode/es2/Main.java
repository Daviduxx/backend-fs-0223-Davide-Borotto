package com.epicode.es2;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	
	private Logger log = LoggerFactory.getLogger(MyThread.class);

	public static void main(String[] args) throws InterruptedException {
		Logger log = LoggerFactory.getLogger(Main.class);
		int[] arr = generaArr();;
		int somma = 0;
		
		Thread t1 = new Thread(new MyThread(arr, 0, 1000, somma));
		Thread t2 = new Thread(new MyThread(arr, 1000, 2000, somma));
		Thread t3 = new Thread(new MyThread(arr, 2000, 3000, somma));

		t1.start();
		t2.start();
		t3.start();
		
		t1.join();
		t2.join();
		t3.join();
 		
		log.info("Somma totale: "+ somma);
	}
	
	public static int[] generaArr() {
		int[] arr = new int[3000];
		Random rand = new Random();
		for(int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(3000);
		}
		return arr;
	}
	

}
