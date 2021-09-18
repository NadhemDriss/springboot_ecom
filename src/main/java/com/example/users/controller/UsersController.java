package com.example.users.controller;

import com.example.users.entities.User;
import com.example.users.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@CrossOrigin("*")
public class UsersController {

    @Autowired
    private UsersService usersevice;

    @GetMapping("all")
    public ResponseEntity<List<User>> getAll(){
        List<User> users= usersevice.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping
    public  ResponseEntity<User> insert (@RequestBody  User user)
    {
        User createdUser=usersevice.save(user);
        return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
    }

    @PutMapping
    public  ResponseEntity<User> update (@RequestBody  User user) {
       User UpdateUser= usersevice.save(user);
        return new ResponseEntity<>(UpdateUser,HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete (@PathVariable String id) {

        usersevice.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping ("{id}")
    public ResponseEntity<User> getId (@PathVariable String id)
    {
      User user=  usersevice.findById(id);
      return new ResponseEntity<>(user,HttpStatus.OK);
    }
    


    }

