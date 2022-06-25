package com.example.assignmentspringboot1.service;

import com.example.assignmentspringboot1.entity.District;
import com.example.assignmentspringboot1.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DistrictService {
    @Autowired
    private DistrictRepository districtRepository;
    public List<District> findAll() {
        return districtRepository.findAll();
    }

    public Optional<District> findById(int id) {
        return districtRepository.findById(id);
    }

    public District save(District District) {
        return districtRepository.save(District);
    }

    public void deleteById(int id) {
        districtRepository.deleteById(id);
    }
}
