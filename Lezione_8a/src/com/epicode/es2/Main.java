package com.epicode.es2;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	
	private Logger log = LoggerFactory.getLogger(MyThread.class);

	public static void main(String[] args) {
		
		int[] arr = new int[3000];
		generaArr(arr);
		
		MyThread t1 = new MyThread(0, 999);
		MyThread t2 = new MyThread(1000, 1999);
		MyThread t3 = new MyThread(2000, 2999);
		
		int sommaArr1 = t1.somma(arr);
		int sommaArr2 = t2.somma(arr);
		int sommaArr3 = t3.somma(arr);
		
		MyThread tMain = new MyThread(sommaArr1, sommaArr2, sommaArr3);
		
		tMain.start();
 		
	}
	
	public static void generaArr(int[] arr) {
		Random rand = new Random();
		for(int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(3000);
		}
	}
	

}
