package com.epicode.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.spring.model.Device;
import com.epicode.spring.repository.UserDAORepository;
import com.epicode.spring.repository.deviceDAORepository;
import com.epicode.spring.security.entity.User;

@Service
public class UserService {
	
	@Autowired UserDAORepository uRepo;
	@Autowired deviceDAORepository dRepo;
	

}
