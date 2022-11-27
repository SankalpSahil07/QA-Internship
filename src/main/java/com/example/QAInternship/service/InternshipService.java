package com.example.QAInternship.service;
import com.example.QAInternship.model.Internship;
import com.example.QAInternship.repository.InternshipRepository;
import com.example.QAInternship.service.InternshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternshipService {
    @Autowired
    InternshipRepository internshipRepository;

    public List<Internship> fetchAllInternships(){
        List<Internship> internships = (List<Internship>)internshipRepository.findAll();
        return internships;
    }
    public Internship createInternship(Internship internship)
    {
        return  internshipRepository.save(internship);

    }
    public Internship fetchInternshipById(Integer id){
        return internshipRepository.findInternshipById(id);

    }
    public void  persistInternship(Internship internship) {
        internshipRepository.save(internship);

    }
    public void  modifyInternship(Internship internship) {

        internshipRepository.save(internship);

    }
}
