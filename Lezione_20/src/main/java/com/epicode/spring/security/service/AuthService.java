package com.epicode.spring.security.service;

import java.util.List;

import com.epicode.spring.security.payload.LoginDto;
import com.epicode.spring.security.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    List<String> getAllPassword();
    String getPassword(Long id);
}
