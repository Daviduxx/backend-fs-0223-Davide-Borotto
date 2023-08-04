package com.epicode.spring.model;

import java.util.List;

import com.epicode.spring.enums.Status;
import com.epicode.spring.enums.Type;
import com.epicode.spring.security.entity.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "devices")
public class Device {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String brandName;
	private String model;
	private Type type;
	private Status status;
	@ManyToMany
	private List<User> user; 
	

}
