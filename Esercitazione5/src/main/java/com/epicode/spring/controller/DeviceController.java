package com.epicode.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.spring.model.Device;
import com.epicode.spring.security.entity.User;
import com.epicode.spring.service.DeviceService;
import com.epicode.spring.service.UserService;

@CrossOrigin(origins =  "*", maxAge = 3600)
@RestController
@RequestMapping("/altro")
public class DeviceController {
	
	@Autowired DeviceService dSvc;
	@Autowired UserService uSvc;
	
	@PostMapping(value = "/newdevice")
	public ResponseEntity<Device> creaDevice(@RequestBody Device device){
		Device d = dSvc.creaDevice(device);
		System.out.println(d);
		return new ResponseEntity<Device>(d, HttpStatus.CREATED);
	}
	
	

}
