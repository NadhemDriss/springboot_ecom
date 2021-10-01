package com.example.users.controller;

import com.example.users.entities.Conge;
import com.example.users.entities.Employer;
import com.example.users.services.CongeService;
import com.example.users.services.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employe")
@CrossOrigin("*")
public class EmployerController {
    @Autowired
    EmployerService employerService;

    @GetMapping("all")
    public ResponseEntity<List<Employer>> getAll(){
        List<Employer> employers= employerService.findAll();
        employerService.somme("615727fda47b9300d4070a05");
        return new ResponseEntity<>(employers, HttpStatus.OK);
    }

    @PostMapping
    public  ResponseEntity<Employer> insert (@RequestBody  Employer employer)
    {
        Employer emp=employerService.save(employer);
        return new ResponseEntity<>(emp,HttpStatus.CREATED);
    }
}
