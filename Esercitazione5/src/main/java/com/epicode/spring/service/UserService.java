package com.epicode.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.spring.model.Device;
import com.epicode.spring.repository.UserDAORepository;
import com.epicode.spring.repository.deviceDAORepository;
import com.epicode.spring.security.entity.User;
import com.epicode.spring.security.exception.ResourceNotFoundException;



@Service
public class UserService {
	
	@Autowired UserDAORepository uRepo;
	@Autowired deviceDAORepository dRepo;
	
	public User updateUser(Long id, User user) {
		if(!uRepo.existsById(id) && !uRepo.existsById(user.getId())) {
			System.out.println("*******ERRORE**********");
			throw new ResourceNotFoundException("Utente non trovato", "id", id);
		}
		User us = uRepo.findById(id).orElse(null);
		
		return uRepo.save(us);
	}
}
