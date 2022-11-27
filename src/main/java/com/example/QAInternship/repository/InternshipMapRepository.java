package com.example.QAInternship.repository;

import com.example.QAInternship.model.InternshipMap;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternshipMapRepository extends CrudRepository<InternshipMap,Integer> {
    InternshipMap save(InternshipMap internshipmap);

    InternshipMap findById(Integer id);


    InternshipMap findInternshipmapById(Integer id);
}
