package com.kaushik.training.webservicedemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaushik.training.webservicedemo.domain.Posts;

public interface PostRepository extends JpaRepository<Posts, Integer> {

}
