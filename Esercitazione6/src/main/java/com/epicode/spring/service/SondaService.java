package com.epicode.spring.service;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.spring.model.Sonda;
import com.epicode.spring.repository.SondaDAO;

@Service
public class SondaService {
	
	@Autowired SondaDAO sRepo;
	@Autowired @Qualifier("sonda") private ObjectProvider<Sonda> sondaProvider;
	
	public Sonda creaSonda(Sonda sonda) {
		return sRepo.save(sonda);
	}
	

}
