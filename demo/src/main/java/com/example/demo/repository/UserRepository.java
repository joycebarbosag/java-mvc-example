package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{
    public UserModel findByEmailAndPassword(String email, String password);
}
