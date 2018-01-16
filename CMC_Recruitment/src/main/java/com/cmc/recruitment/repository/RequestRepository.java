package com.cmc.recruitment.repository;

import org.springframework.data.repository.CrudRepository;

import com.cmc.recruitment.entity.Request;

public interface RequestRepository extends CrudRepository<Request, Long> {

}
