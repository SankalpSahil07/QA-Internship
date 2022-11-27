package com.example.QAInternship.dto;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
@Setter
@Getter
public class InternshipmapDTO {
    Integer id ;
    String project_name ;
    String domain ;
    String type ;
    String testers ;
}
