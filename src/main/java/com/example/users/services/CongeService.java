package com.example.users.services;

import com.example.users.entities.Conge;
import com.example.users.entities.Etat;
import com.example.users.repository.CongeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CongeService {
    @Autowired
    CongeRepository congeRepository;

    public List<Conge> findAll() {
        return congeRepository.findAll();
    }

    public Conge save(@RequestBody Conge conge) {
        return congeRepository.save(conge);
    }

    public Conge update(Conge conge) {
        return congeRepository.save(conge);
    }

    public List<Conge> findByEtat(String etat) {
        return congeRepository.findByEtat(etat);
    }

    public Conge findById(String id){
        Conge conge = congeRepository.findById(id).get();
        return conge;}

}
