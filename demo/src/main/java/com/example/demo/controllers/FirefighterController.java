package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.FirefighterModel;
import com.example.demo.services.FirefighterService;
import com.example.demo.services.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/firefighters/")
public class FirefighterController {

    @Autowired
    private UserService userService;

    @Autowired
    private FirefighterService firefighterService;

    @GetMapping
    public List<FirefighterModel> getAllFirefighters(){
        return firefighterService.getAllFirefighters();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FirefighterModel> getFirefighterById(@PathVariable Long id){
        try{
            Optional<FirefighterModel> newFirefighterModel = firefighterService.getFirefighterById(id);
            if(newFirefighterModel.isPresent()){
                return ResponseEntity.ok(newFirefighterModel.get());
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/create")
    public FirefighterModel createFirefighter(@RequestBody FirefighterModel firefighter) {
        try {
            return (FirefighterModel) userService.creteNewUser(firefighter);
        } catch (Exception e) {
            return null;
        }
    }

}
