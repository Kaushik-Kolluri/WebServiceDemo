package com.kaushik.training.webservicedemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaushik.training.webservicedemo.domain.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

}
