package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.UserAddressModel;
import com.example.demo.repository.UserAddressRepository;

@Service
public class UserAddressService {
    
    @Autowired
    private UserAddressRepository userAddressRepository;

    public List<UserAddressModel> getAllAddresses(){
        return userAddressRepository.findAll();
    }

    public Optional<UserAddressModel> getByZipCode(String zipCode){
        return userAddressRepository.findByZipCode(zipCode);
    }

    public UserAddressModel getById(Long id){
        return userAddressRepository.findById(id).orElse(null );
    }
}
