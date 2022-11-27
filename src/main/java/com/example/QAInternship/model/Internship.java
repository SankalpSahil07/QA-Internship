package com.example.QAInternship.model;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import javax.persistence.*;

@Setter
@Getter
@Data
@Entity(name="Qa_intern_projects")
public class Internship {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "internship_generator")
    @SequenceGenerator(name="internship_generator", sequenceName = "internship_seq")
    @Column(name = "id")
    Integer id ;

    @Column(name = "name")
    String name ;

    @Column(name = "description")
    String description ;

    @Column(name = "domain")
    String domain ;

    @Column(name = "tech_stack")
    String tech_stack ;
}
