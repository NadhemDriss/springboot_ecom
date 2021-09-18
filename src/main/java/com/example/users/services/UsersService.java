package com.example.users.services;

import com.example.users.entities.User;
import com.example.users.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class UsersService {


    @Autowired
    private UsersRepository repository;


    public List<User> findAll(){
        return repository.findAll();
    }


    public  User save (@RequestBody User user) {
        return repository.save(user);
    }


    public  User update (@RequestBody  User user) {
        return repository.save(user);
    }


    public void deleteById (@PathVariable String id) {
        repository.deleteById(id);
    }

    public User findById (@PathVariable String id) {
        return  repository.findById(id).get();
    }
}
