package com.cmc.recruitment.repository;

import org.springframework.data.repository.CrudRepository;

import com.cmc.recruitment.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

  User findByusername(String username);
}
