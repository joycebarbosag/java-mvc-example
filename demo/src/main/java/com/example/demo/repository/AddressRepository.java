package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.AddressModel;

public interface AddressRepository extends JpaRepository<AddressModel, Long>{
    
    Optional<AddressModel> findByZipCode(String zipCode);
}
