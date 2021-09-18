package com.example.users.security;

import com.example.users.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<AppUser, Long> {
    AppUser findByEmail(String email);
}
