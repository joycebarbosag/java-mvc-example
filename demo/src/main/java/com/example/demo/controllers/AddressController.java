package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.AddressModel;
import com.example.demo.services.AddressService;

@RestController
@RequestMapping("/api/addresses")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AddressController {
    
    @Autowired
    AddressService addressService;

    @GetMapping
    public List<AddressModel> getAllAddresses(){
        return addressService.getAllAddresses();
    }

    @GetMapping("/{id}")
    public AddressModel getAddressById(@PathVariable Long id){
        return addressService.getById(id);
    }

    @GetMapping("/zipCode/{zipCode}")
    public Optional<AddressModel> getByZipCode(@PathVariable String zipCode){
        return addressService.getByZipCode(zipCode);
    }

}
