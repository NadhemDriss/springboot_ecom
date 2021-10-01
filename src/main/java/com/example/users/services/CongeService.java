package com.example.users.services;

import com.example.users.entities.Conge;
import com.example.users.entities.Employer;
import com.example.users.entities.Etat;
import com.example.users.repository.CongeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class CongeService {
    @Autowired
    CongeRepository congeRepository;
    @Autowired
    EmployerService employerService;

    public List<Conge> findAll() {
        return congeRepository.findAll();
    }

    public Conge save(Conge conge,String id) {
        Long milliseconds =  conge.getDateRetour().getTime()-conge.getDateSortie().getTime();
        Integer days = Math.toIntExact(TimeUnit.MILLISECONDS.toDays(milliseconds));
        conge.setNbrJour(days);
        conge.setEmployer(employerService.findById(id));
        return congeRepository.save(conge);

    }

    public Conge update(Conge conge) {
        return congeRepository.save(conge);
    }

    public List<Conge> findByEtat(String etat) {
        return congeRepository.findByEtat(etat);
    }

    public Conge findById(String id){
        return congeRepository.findById(id).get();}

    public Conge save(Conge conge) {
        return congeRepository.save(conge);
    }
}
