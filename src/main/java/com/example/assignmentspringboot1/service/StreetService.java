package com.example.assignmentspringboot1.service;

import com.example.assignmentspringboot1.entity.District;
import com.example.assignmentspringboot1.entity.Street;
import com.example.assignmentspringboot1.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class StreetService {
    @Autowired
    private StreetRepository streetRepository;
    public List<District> findAll(){return streetRepository.findAll();}
    public Optional<District> findById(int id){return streetRepository.findById(id);}
    public Street save(Street street){return streetRepository.save(street);}
    public void deleteById(int id){streetRepository.deleteById(id);}
}
