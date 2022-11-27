    package com.example.QAInternship.controller;

    import com.example.QAInternship.dto.InternshipDTO;
    import com.example.QAInternship.model.Internship;
    import com.example.QAInternship.service.InternshipService;
    import org.modelmapper.ModelMapper;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.MediaType;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.Arrays;
    import java.util.List;

@RestController
@RequestMapping
public class InternshipController {

    @Autowired
    InternshipService internshipService;
    InternshipDTO internshipDTO;
    ModelMapper modelMapper = new ModelMapper() ;
    public InternshipController()
    {}
    @GetMapping(value = "/internship/all" ,produces= MediaType.APPLICATION_JSON_VALUE)
    public List<InternshipDTO> fetchAllInternships() {
        System.out.println("In controller...");
        List<Internship> internshipList =  internshipService.fetchAllInternships();
        List<InternshipDTO> internships = Arrays.asList(modelMapper.map(internshipList,InternshipDTO[].class));
        return internships;
    }

    @GetMapping(value = "/internship/{id}" ,produces= MediaType.APPLICATION_JSON_VALUE)
    public InternshipDTO fetchInternshipById(@PathVariable("id") Integer id) {
        System.out.println("Fetching Internships by id ...");
        Internship internship =  internshipService.fetchInternshipById(id);
        InternshipDTO  internshipDTO = modelMapper.map(internship,InternshipDTO.class);
        return internshipDTO ;
    }
    @PostMapping(value = "/internship/create",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String>  createInternship(@RequestBody InternshipDTO internshipDTO) {
        System.out.println("name of the Internships=="+internshipDTO.getName());
        Internship internship = modelMapper.map(internshipDTO,Internship.class);
        internshipService.createInternship(internship);
        internshipService.persistInternship(internship);
        return ResponseEntity.ok().body("Internship Details Registered Successfully.");
    }

   @PutMapping(value = "/internship/update",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String>  updateInternship(@RequestBody InternshipDTO internshipDTO) {
        Internship internship  = internshipService.fetchInternshipById(internshipDTO.getId());
        internshipService.modifyInternship(generateInternship(internshipDTO,internship));
        return ResponseEntity.ok().body("Internship Details Modified Successfully.");
    }
    private Internship  generateInternship(InternshipDTO internshipDTO,Internship internship) {

        internship.setId(internshipDTO.getId());
        internship.setName(internshipDTO.getName());
        internship.setDescription(internshipDTO.getDescription());
        internship.setDomain(internshipDTO.getDomain());
        internship.setTech_stack(internshipDTO.getTech_stack());
        return internship ;

         }
}
