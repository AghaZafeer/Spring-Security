package com.example.dem.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String Name;

    @JsonIgnore
    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
    List<Employee> employeeList;
}
