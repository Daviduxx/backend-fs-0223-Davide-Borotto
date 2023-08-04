package com.epicode.spring.service;


import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.spring.model.Device;
import com.epicode.spring.repository.deviceDAORepository;

@Service
public class DeviceService {
	
	@Autowired deviceDAORepository dRepo;
	
	@Autowired @Qualifier("device") private ObjectProvider<Device> deviceProvider;
	
	public Device creaDevice(Device device) {
		return dRepo.save(device);
	}

}
