package com.cmc.recruitment.repository;

import org.springframework.data.repository.CrudRepository;

import com.cmc.recruitment.entity.Candidate;

public interface CandidateRepository extends CrudRepository<Candidate, Long> {

}
