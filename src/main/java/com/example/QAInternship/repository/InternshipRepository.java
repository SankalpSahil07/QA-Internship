package com.example.QAInternship.repository;

import com.example.QAInternship.model.Internship;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface InternshipRepository extends CrudRepository<Internship,Integer> {
    Internship findInternshipById(Integer id);

    // Internship findById(Integer id);
}
