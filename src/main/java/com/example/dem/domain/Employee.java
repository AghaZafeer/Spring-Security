package com.example.dem.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;

@Entity
@NoArgsConstructor
@Data
@Table(name="Employee")
public class Employee {

    @Id
    @Column(name="Id")
    int id;
    @Column(name="Dept")
    String dept;
    @Column(name="Name")
    String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    Department department;



}
