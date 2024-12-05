package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.ReporterModel;
import com.example.demo.services.ReporterService;
import com.example.demo.services.UserService;

@RestController
@RequestMapping("/api/reporters")
public class ReporterController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private ReporterService reporterService;

    @GetMapping
    public List<ReporterModel> getAllReporters(){
        return reporterService.getAllReporters();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReporterModel> getReporterById(@PathVariable Long id){
        try{
            Optional<ReporterModel> newReporterModel = reporterService.getReporterById(id);
            if(newReporterModel.isPresent()){
                return ResponseEntity.ok(newReporterModel.get());
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/create")
    public ReporterModel createReporter(@RequestBody ReporterModel reporterModel){
        try{
            return (ReporterModel) userService.creteNewUser(reporterModel);
        }catch (Exception e){
            return null;
        }
    }

    @PutMapping("/updateReporter/{id}")
    public ResponseEntity<ReporterModel> updateReporter(
            @PathVariable Long id,
            @RequestBody ReporterModel updatedReporter) {
        return reporterService.updateReporter(id, updatedReporter);
    }

}
