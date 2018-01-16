package com.cmc.recruitment.repository;

import org.springframework.data.repository.CrudRepository;

import com.cmc.recruitment.entity.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {

}
