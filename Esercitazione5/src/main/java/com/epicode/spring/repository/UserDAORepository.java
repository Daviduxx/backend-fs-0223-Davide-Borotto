package com.epicode.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.epicode.spring.security.entity.User;

public interface UserDAORepository extends CrudRepository<User, Long> {

}
