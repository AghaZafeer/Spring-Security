package com.example.dem.service;


import com.example.dem.domain.Department;
import com.example.dem.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public void add(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void delete(int id) {
        departmentRepository.deleteById(id);

    }

    @Override
    public void update(Department department, int id) {

        departmentRepository.deleteById(id);
        departmentRepository.save(department);
    }

    @Override
    public Optional<Department> get(int id) {
        return departmentRepository.findById(id);
    }
}
