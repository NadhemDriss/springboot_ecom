package com.example.users.repository;

import com.example.users.entities.Conge;
import com.example.users.entities.Etat;
import com.example.users.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CongeRepository extends MongoRepository<Conge, String> {
    List<Conge> findByEtat(String etat);
}
