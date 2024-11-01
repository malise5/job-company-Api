package com.github.malise5.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "job_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "minSalary")
    private String minSalary;

    @Column(name = "maxSalary")
    private String maxSalary;

    @Column(name = "location")
    private String location;

    @JsonIgnore
    @ManyToOne
    private Company company;

    
    // public Job() {
    // }

    // public Job(Long id, String title, String description, String minSalary, String maxSalary, String location) {
    //     this.id = id;
    //     this.title = title;
    //     this.description = description;
    //     this.minSalary = minSalary;
    //     this.maxSalary = maxSalary;
    //     this.location = location;
    // }

}
