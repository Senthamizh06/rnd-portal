package com.project.proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.proj.model.Department1;

public interface UserRepository extends JpaRepository<Department1, Integer> {

}

