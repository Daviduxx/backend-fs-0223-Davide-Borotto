package com.epicode.spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/os")
public class Consumer {
	
	@GetMapping("/get-string")
	public String welcome() {
		
		RestTemplate rt = new RestTemplate();
		String url = "http://localhost:8081/app/data1";
		ResponseEntity<String> res = rt.getForEntity(url, String.class);
		return "Hello! " + res;
	}
	
	@GetMapping("/movies")
	public Object getMovies() {
		RestTemplate rt = new RestTemplate();
		String url = "http://localhost:8081/app/data2";
		Object res = rt.getForObject(url, Object.class);
		return res;
		
	}

}
