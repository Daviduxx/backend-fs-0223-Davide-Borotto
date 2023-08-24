package com.epicode.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.spring.model.Movie;

@RestController
@RequestMapping("/app")
public class Producer {
	
	@GetMapping("/data1")
	public String title() {
		return "Welcome to Netflix!";
	}
	
	@GetMapping("/data2")
	public ResponseEntity<List<Movie>> getMovies(){
		List<Movie> movieList = new ArrayList<Movie>();
		movieList.add(new Movie("Oppenheimer", "Nolan", 2023));
		movieList.add(new Movie("Lord of the Rings", "Jackson", 2003));
		movieList.add(new Movie("Transformers", "Bay", 2010));
		return new ResponseEntity<List<Movie>>(movieList, HttpStatus.OK);
	}

}
