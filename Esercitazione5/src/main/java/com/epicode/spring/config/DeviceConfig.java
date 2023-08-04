package com.epicode.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.spring.model.Device;

@Configuration
public class DeviceConfig {

	@Bean("device")
	@Scope("prototype")
	public Device creaDevice() {
		return new Device();
	}
}
