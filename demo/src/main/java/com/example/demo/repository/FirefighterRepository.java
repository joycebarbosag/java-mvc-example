package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.FirefighterModel;

public interface FirefighterRepository extends JpaRepository<FirefighterModel, Long> {
    
}
