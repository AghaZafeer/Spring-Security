package com.example.dem.service;

import com.example.dem.domain.Department;
import com.example.dem.domain.Employee;
import com.example.dem.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


public interface DepartmentService {
    public void add(Department department);
    public void delete(int id);
    public void update(Department department, int id);
    public Optional<Department> get(int id);

}
