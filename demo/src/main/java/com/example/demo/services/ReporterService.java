package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<ReporterModel> updateReporter(Long id, ReporterModel updatedReporter) {
        try {
            Optional<ReporterModel> existingReporter = reporterRepository.findById(id);
            
            if (existingReporter.isPresent()) {
                ReporterModel reporter = existingReporter.get();
                
                reporter.setName(updatedReporter.getName());
                reporter.setEmail(updatedReporter.getEmail());
                reporter.setPassword(updatedReporter.getPassword());

                if (updatedReporter.getAddress() != null) {
                    reporter.setAddress(updatedReporter.getAddress());
                }
                
                reporter.setCpf(updatedReporter.getCpf());
                
                ReporterModel savedReporter = reporterRepository.save(reporter);
                return ResponseEntity.ok(savedReporter);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
