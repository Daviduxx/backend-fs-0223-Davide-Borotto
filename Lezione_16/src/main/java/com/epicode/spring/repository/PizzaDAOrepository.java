package com.epicode.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.epicode.spring.model.Elemento;
import com.epicode.spring.model.Pizza;

public interface PizzaDAORepository extends CrudRepository<Elemento, Long>{
	
	

}
