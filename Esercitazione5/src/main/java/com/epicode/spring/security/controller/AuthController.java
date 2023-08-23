package com.epicode.spring.security.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.spring.model.Device;
import com.epicode.spring.repository.UserDAORepository;
import com.epicode.spring.repository.deviceDAORepository;
import com.epicode.spring.security.entity.ERole;
import com.epicode.spring.security.entity.User;
import com.epicode.spring.security.payload.JWTAuthResponse;
import com.epicode.spring.security.payload.LoginDto;
import com.epicode.spring.security.payload.RegisterDto;
import com.epicode.spring.security.service.AuthService;
import com.epicode.spring.service.UserService;


//il cors è da abilitare su ogni controller
@CrossOrigin(origins =  "*", maxAge = 3600)
@RestController
@RequestMapping("/device/auth")
public class AuthController {

    private AuthService authService;
    @Autowired UserService uSvc;
    @Autowired UserDAORepository uRepo;
    @Autowired deviceDAORepository dRepo;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Build Login REST API
    @PostMapping(value = {"/login", "/signin"})
    public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDto loginDto){
           	
    	String token = authService.login(loginDto);

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setUsername(loginDto.getUsername());
        jwtAuthResponse.setAccessToken(token);

        return ResponseEntity.ok(jwtAuthResponse);
    }

    // Build Register REST API
    @PostMapping(value = {"/register", "/signup"})
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
//    @PatchMapping("/aggiungidevice/{id}")
//	public ResponseEntity<User> addDevice(@PathVariable Long id, @RequestBody User user){
//		return new ResponseEntity<User>(
//				uSvc.updateUser(id, user),
//				HttpStatus.OK);
//	}
    
    @GetMapping("/{id}")
    public ResponseEntity<String> getPassword(@PathVariable Long id){
    	String p = authService.getPassword(id);
    	return new ResponseEntity<String>(p, HttpStatus.OK);
    }
	}
    

    
    
    // JSON inviato dal Client
    /*{
        "name": "Giuseppe",
        "lastname": "Verdi",
        "username": "giuseppevardi",
        "email": "g.verdi@example.com",
        "password": "qwerty",
        "roles": ["MODERATOR", "ADMIN"]
    }*/

