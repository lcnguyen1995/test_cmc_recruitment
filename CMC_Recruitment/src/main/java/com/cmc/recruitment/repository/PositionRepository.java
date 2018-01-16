package com.cmc.recruitment.repository;

import org.springframework.data.repository.CrudRepository;

import com.cmc.recruitment.entity.Position;

public interface PositionRepository extends CrudRepository<Position, Long> {
  
}
