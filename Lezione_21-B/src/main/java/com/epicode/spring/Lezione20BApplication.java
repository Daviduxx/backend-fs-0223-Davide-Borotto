package com.epicode.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lezione20BApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lezione20BApplication.class, args);
		System.out.println("Consumer server running on port 8082");
	}

}
