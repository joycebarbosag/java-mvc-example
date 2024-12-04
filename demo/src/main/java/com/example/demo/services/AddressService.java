package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.AddressModel;
import com.example.demo.repository.AddressRepository;

@Service
public class AddressService {
    
    @Autowired
    private AddressRepository addressRepository;

    public List<AddressModel> getAllAddresses(){
        return addressRepository.findAll();
    }

    public Optional<AddressModel> getByZipCode(String zipCode){
        return addressRepository.findByZipCode(zipCode);
    }

    public AddressModel getById(Long id){
        return addressRepository.findById(id).orElse(null );
    }
}
