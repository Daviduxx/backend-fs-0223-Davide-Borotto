package com.epicode.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.epicode.spring.model.Device;

public interface deviceDAORepository extends CrudRepository<Device, Long>{

}
