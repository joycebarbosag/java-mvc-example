package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
}
