package com.example.QAInternship.controller;

import com.example.QAInternship.dto.InternshipmapDTO;
import com.example.QAInternship.model.InternshipMap;
import com.example.QAInternship.service.InternshipMapService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class InternshipmapController {
    @Autowired
    InternshipMapService internshipmapService;
    InternshipmapDTO internshipmapDTO;
    ModelMapper modelMapper = new ModelMapper() ;
    public InternshipmapController()
    {}
    @GetMapping(value = "/internshipmap/all" ,produces= MediaType.APPLICATION_JSON_VALUE)
    public List<InternshipmapDTO> fetchAllInternshipmaps() {
        System.out.println("In controller...");
        List<InternshipMap> internshipmapList =  internshipmapService.fetchAllInternshipmaps();
        List<InternshipmapDTO> internshipmaps = Arrays.asList(modelMapper.map(internshipmapList,InternshipmapDTO[].class));
        return internshipmaps;
    }
    @GetMapping(value = "/internshipmap/{id}" ,produces= MediaType.APPLICATION_JSON_VALUE)
    public InternshipmapDTO fetchInternshipmapById(@PathVariable("id") Integer id) {
        System.out.println("Fetching Internshipmaps by id ...");
        InternshipMap internshipmap =  internshipmapService.fetchInternshipmapById(id);
        InternshipmapDTO  internshipmapDTO = modelMapper.map(internshipmap,InternshipmapDTO.class);
        return internshipmapDTO ;
    }
    @PostMapping(value = "/internshipmap/create",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String>  createInternshipmap(@RequestBody InternshipmapDTO internshipmapDTO) {
        System.out.println("name of the Internshipmaps=="+internshipmapDTO.getProject_name());
        InternshipMap internshipmap = modelMapper.map(internshipmapDTO, InternshipMap.class);
        internshipmapService.createInternshipmap(internshipmap);
        internshipmapService.persistInternshipmap(internshipmap);
        return ResponseEntity.ok().body("Internshipmapping Details Registered Successfully.");
    }

    @PutMapping(value = "/internshipmap/update",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String>  updateInternshipmap(@RequestBody InternshipmapDTO internshipmapDTO) {
        InternshipMap internshipmap  = internshipmapService.fetchInternshipmapById(internshipmapDTO.getId());
        internshipmapService.modifyInternshipmap(generateInternshipmap(internshipmapDTO,internshipmap));
        return ResponseEntity.ok().body("Internship Mapping Details Modified Successfully.");
    }
    private InternshipMap generateInternshipmap(InternshipmapDTO internshipmapDTO, InternshipMap internshipmap) {

        internshipmap.setId(internshipmapDTO.getId());
        internshipmap.setProject_name(internshipmapDTO.getProject_name());
        internshipmap.setDomain(internshipmapDTO.getDomain());
        internshipmap.setType(internshipmapDTO.getType());
        internshipmap.setTesters(internshipmapDTO.getTesters());
        return internshipmap ;

    }

}
