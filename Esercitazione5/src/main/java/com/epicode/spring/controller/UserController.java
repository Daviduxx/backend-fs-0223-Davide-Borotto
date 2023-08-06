package com.epicode.spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.spring.security.entity.User;
import com.epicode.spring.service.UserService;

@CrossOrigin(origins =  "*", maxAge = 3600)
@RestController
@RequestMapping("/empolyee")
public class UserController {
	
	 @Autowired UserService uSvc;
	
    @PatchMapping("/aggiungidevice/{id}")
	public ResponseEntity<User> addDevice(@PathVariable Long id, @RequestBody User user){
    	System.out.println(user);
		return new ResponseEntity<User>(
				uSvc.updateUser(id, user),
				HttpStatus.OK);
	}

}
