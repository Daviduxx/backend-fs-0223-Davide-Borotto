package com.epicode.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UtenteController {
	
	@GetMapping("/")
	public @ResponseBody String getHomePage() {
		return "<h1>Questa è una pagina di test</h1>";
	}
	
	@GetMapping("/about")
	public String getAbout() {
		return "about.html";
	}

}
