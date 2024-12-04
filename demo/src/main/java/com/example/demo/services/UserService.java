package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.UserModel;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public UserModel creteNewUser(UserModel newUser) throws Exception{
        try {
            return userRepository.save(newUser);
        } catch (Exception e){
            return null;
        }
    }

    public UserModel findUserByEmailAndPassword(String email, String password) throws Exception {
        try{
            return userRepository.findByEmailAndPassword(email, password);
        }catch (Exception e){
            throw new Exception("Erro para encontrar o usuário");
        }
    }

    public List<UserModel> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<UserModel> getUserById(Long id){
        return userRepository.findById(id);
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

}
