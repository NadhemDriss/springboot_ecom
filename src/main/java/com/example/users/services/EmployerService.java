package com.example.users.services;


import com.example.users.entities.Employer;
import com.example.users.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class EmployerService {
    @Autowired
    EmployerRepository employerRepository;

    public List<Employer> findAll() {
        return employerRepository.findAll();
    }

    public Employer save(Employer employer) {
        return employerRepository.save(employer);
    }

    public Employer update(Employer employer) {
        return employerRepository.save(employer);
    }

    public Employer findById(String id) {
        return employerRepository.findById(id).get();

    }
    public Integer somme(String id) {
        Date d = new Date();
        Long milliseconds = d.getTime() - findById(id).getDateEmb().getTime();
        long days = TimeUnit.MILLISECONDS.toDays(milliseconds);
        System.out.println(days);
    return 0;
    }
}
