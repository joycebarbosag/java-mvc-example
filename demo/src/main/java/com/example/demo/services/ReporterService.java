package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.ReporterModel;
import com.example.demo.repository.ReporterRepository;

@Service
public class ReporterService {
    
    @Autowired
    private ReporterRepository reporterRepository;

    ReporterModel reporterModel;

    public List<ReporterModel> getAllReporters(){
        return reporterRepository.findAll();
    }

    public Optional<ReporterModel> getReporterById(Long id){
        return reporterRepository.findById(id);
    }
}
