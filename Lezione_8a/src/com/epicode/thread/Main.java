package com.epicode.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	
	private static Logger log = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		
		MyThread t1 = new MyThread("*");
		MyThread t2 = new MyThread("#");
		
		t1.start();
		t2.start();
		log.warn("FINE");

	}

}

