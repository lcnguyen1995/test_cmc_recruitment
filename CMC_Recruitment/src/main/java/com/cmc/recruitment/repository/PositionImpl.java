package com.cmc.recruitment.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cmc.recruitment.entity.Position;


public class PositionImpl{
  @Autowired
  PositionRepository positionRespository;
  
  public static void main(String[] args) {
    PositionImpl pi = new PositionImpl();
    Iterable<Position> list = pi.positionRespository.findAll();
    System.out.println(list.iterator().hasNext());
  }
}
