package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.UserAddressModel;
import com.example.demo.services.UserAddressService;

@RestController
@RequestMapping("/api/addresses")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserAddressController {
    
    @Autowired
    UserAddressService userAddressService;

    @GetMapping
    public List<UserAddressModel> getAllAddresses(){
        return userAddressService.getAllAddresses();
    }

    @GetMapping("/{id}")
    public UserAddressModel getAddressById(@PathVariable Long id){
        return userAddressService.getById(id);
    }

    @GetMapping("/zipCode/{zipCode}")
    public Optional<UserAddressModel> getByZipCode(@PathVariable String zipCode){
        return userAddressService.getByZipCode(zipCode);
    }

}
