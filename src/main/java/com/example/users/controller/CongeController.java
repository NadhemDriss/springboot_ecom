package com.example.users.controller;

import com.example.users.entities.Conge;
import com.example.users.entities.Etat;
import com.example.users.entities.User;
import com.example.users.services.CongeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("conge")
@CrossOrigin("*")
public class CongeController {

    @Autowired
    CongeService congeService;

    @GetMapping("all")
    public ResponseEntity<List<Conge>> getAll(){
        List<Conge> conges= congeService.findAll();
        return new ResponseEntity<>(conges, HttpStatus.OK);
    }

    @PostMapping("{id}")
    public  ResponseEntity<Conge> insert (@RequestBody  Conge conge,@PathVariable String id)
    {

        Conge createdConge=congeService.save(conge,id);
        return new ResponseEntity<>(createdConge,HttpStatus.CREATED);
    }
    @PutMapping
    public  ResponseEntity<Conge> update (@RequestBody  Conge conge) {
        Conge UpdateConge= congeService.save(conge);
        return new ResponseEntity<>(UpdateConge,HttpStatus.CREATED);
    }
    @GetMapping ("{etat}")
    public ResponseEntity<List<Conge>> getEtat (@PathVariable String etat)
    {
        List<Conge> conge=  congeService.findByEtat(etat);
        return new ResponseEntity<>(conge,HttpStatus.OK);
    }
}
