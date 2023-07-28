package com.epicode.spring.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner{
	
	static Logger log = LoggerFactory.getLogger(Runner.class);

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Runner works!");
		log.info("runner works with logger");
		
	}

}
