package com.epicode.spring.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.epicode.spring.security.entity.User;

public interface UserDAORepository extends CrudRepository<User, Long> {

	User save(Optional<User> us);

	boolean existsById(User user);

}
