package com.example.users.repository;

import com.example.users.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<User, String> {



}
