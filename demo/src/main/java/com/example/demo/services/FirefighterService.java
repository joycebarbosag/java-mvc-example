package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.models.FirefighterModel;
import com.example.demo.repository.FirefighterRepository;

@Service
public class FirefighterService {
    
    @Autowired
    private FirefighterRepository firefighterRepository;

    FirefighterModel firefighterModel;

    public List<FirefighterModel> getAllFirefighters(){
        return firefighterRepository.findAll();
    }

    public Optional<FirefighterModel> getFirefighterById(Long id){
        return firefighterRepository.findById(id);
    }

     public ResponseEntity<FirefighterModel> updateFirefighter(Long id, FirefighterModel updatedFirefighter) {
        try {
            Optional<FirefighterModel> existingFirefighter = firefighterRepository.findById(id);
            
            if (existingFirefighter.isPresent()) {
                FirefighterModel firefighter = existingFirefighter.get();
                
                firefighter.setName(updatedFirefighter.getName());
                firefighter.setEmail(updatedFirefighter.getEmail());
                firefighter.setPassword(updatedFirefighter.getPassword());
                
                if (updatedFirefighter.getAddress() != null) {
                    firefighter.setAddress(updatedFirefighter.getAddress());
                }
                
                firefighter.setPatent(updatedFirefighter.getPatent());
                firefighter.setFireHouse(updatedFirefighter.getFireHouse());
                firefighter.setFirefighterRegister(updatedFirefighter.getFirefighterRegister());
                
                FirefighterModel savedFirefighter = firefighterRepository.save(firefighter);
                return ResponseEntity.ok(savedFirefighter);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
