package com.cmc.recruitment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cmc.recruitment.entity.Position;
import com.cmc.recruitment.repository.PositionRepository;

@Controller
public class MainController {

  @Autowired
  private PositionRepository positionRepository;
  
  @GetMapping("/")
  public String index(Model model) {
    List<Position> listPosition = (List<Position>) positionRepository.findAll();
    System.out.println(listPosition);
    for (Position p : listPosition) System.out.println(p);
    return "index";
  }
  
}
