package com.example.QAInternship.service;

import com.example.QAInternship.model.InternshipMap;
import com.example.QAInternship.repository.InternshipMapRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
import  org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InternshipMapService {
    @Autowired
    InternshipMapRepository internshipmapRepository;

    public List<InternshipMap> fetchAllInternshipmaps(){
        List<InternshipMap> internshipmapList = (List<InternshipMap>)internshipmapRepository.findAll();
        return internshipmapList;
    }
    public InternshipMap createInternshipmap(InternshipMap internshipmap)
    {
        return  internshipmapRepository.save(internshipmap);

    }
    public InternshipMap fetchInternshipmapById(Integer id){
        return internshipmapRepository.findInternshipmapById(id);

    }
    public void  persistInternshipmap(InternshipMap internshipmap) {
        internshipmapRepository.save(internshipmap);

    }
    public void  modifyInternshipmap(InternshipMap internshipmap) {

        internshipmapRepository.save(internshipmap);

    }}