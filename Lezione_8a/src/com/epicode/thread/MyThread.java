package com.epicode.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyThread extends Thread {
	
	private static Logger log = LoggerFactory.getLogger(Main.class);
	
	private String message;

	public MyThread(String message) {
		super();
		this.message = message;
	}

	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			try {
				log.info("Ciclo n. " + i + " " + message);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				log.error(e.getMessage());
				e.printStackTrace();
			}
		}
	}
	
	

}
