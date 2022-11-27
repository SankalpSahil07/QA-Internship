package com.example.QAInternship.dto;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Setter
@Getter
public class InternshipDTO {

    Integer id ;
    String name ;
    String description ;
    String domain ;
    String tech_stack ;

}
