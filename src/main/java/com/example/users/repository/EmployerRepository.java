package com.example.users.repository;

import com.example.users.entities.Conge;
import com.example.users.entities.Employer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployerRepository extends MongoRepository<Employer, String> {
}
