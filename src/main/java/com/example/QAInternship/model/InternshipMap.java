package com.example.QAInternship.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Data
@Entity(name="Qa_intern_projects_map")
public class InternshipMap {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "internshipmap_generator")
    @SequenceGenerator(name="internshipmap_generator", sequenceName = "internshipmaps_seq")
    @Column(name = "id")
    Integer id ;

    @Column(name = "project_name")
    String project_name ;

    @Column(name = "domain")
    String domain ;

    @Column(name = "type")
    String type ;

    @Column(name = "testers")
    String testers ;

}
