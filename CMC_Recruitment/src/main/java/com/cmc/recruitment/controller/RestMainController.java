package com.cmc.recruitment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmc.recruitment.entity.Role;
import com.cmc.recruitment.entity.User;
import com.cmc.recruitment.repository.RoleRepository;
import com.cmc.recruitment.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class RestMainController {
  
  @Autowired
  UserRepository userRes;
  @Autowired
  RoleRepository roleRes;
  
  @GetMapping("/list-user")
  public Object getAllUser() {
    return userRes.findAll();
  }
  
  @GetMapping("/list-role")
  public List<Role> getAllRole() {
    return (List<Role>) roleRes.findAll();
  }
}
