package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public User addUser(User user){
        return userRepo.save(user);
    }

    public List<User> getAllUser(){
        return userRepo.findAll();
    }

    public User findByUsernameAndPasswordCheck(String username,String password){
        User user=userRepo.findByUsernameAndPassword(username,password);
        if(user==null){
            System.out.println("This user is not here");
        }
        return user;
    }
}
