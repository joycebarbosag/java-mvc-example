package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.ReporterModel;

public interface ReporterRepository extends JpaRepository<ReporterModel, Long> {
    
}
