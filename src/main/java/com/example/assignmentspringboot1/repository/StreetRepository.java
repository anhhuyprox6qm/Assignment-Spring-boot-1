package com.example.assignmentspringboot1.repository;

import com.example.assignmentspringboot1.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreetRepository extends JpaRepository<District, Integer> {
}
