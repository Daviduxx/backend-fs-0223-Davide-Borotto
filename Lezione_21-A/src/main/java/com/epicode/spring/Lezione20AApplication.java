package com.epicode.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lezione20AApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lezione20AApplication.class, args);
		System.out.println("Producer server running on port 8081");
	}

}
