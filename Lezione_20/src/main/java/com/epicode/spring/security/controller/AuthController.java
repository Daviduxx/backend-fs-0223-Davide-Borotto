package com.epicode.spring.security.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.spring.security.entity.User;
import com.epicode.spring.security.payload.JWTAuthResponse;
import com.epicode.spring.security.payload.LoginDto;
import com.epicode.spring.security.payload.RegisterDto;
import com.epicode.spring.security.service.AuthService;



@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

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
    
    @GetMapping(value = {"/password"})
    public ResponseEntity<List<String>> getAllPassword(){
    	List<String> response = authService.getAllPassword();
    	return new ResponseEntity<List<String>>(response, HttpStatus.OK); 
    }
    
    @GetMapping(value = "/password/{id}")
    public ResponseEntity<String> getPassword(@PathVariable Long id){
    	String response = authService.getPassword(id);
    	return new ResponseEntity<String>(response, HttpStatus.OK);
    }
    
    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getUsers(){
    	return new ResponseEntity<List<User>>(authService.getUsers(), HttpStatus.OK);
    }
}
