package com.cmc.recruitment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cmc.recruitment.repository.PositionRepository;

@Controller
public class MainController {

  @Autowired
  private PositionRepository positionRepository;
  
  
}
