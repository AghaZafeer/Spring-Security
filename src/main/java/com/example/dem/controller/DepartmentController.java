package com.example.dem.controller;

import com.example.dem.domain.Department;
import com.example.dem.domain.Employee;
import com.example.dem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/dept")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @PostMapping("/add")
    public void add(@RequestBody Department department)
    {

        departmentService.add(department);

    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id)
    {
        departmentService.delete(id);

    }

    @GetMapping("/get/{id}")
    public Optional<Department> get(@PathVariable Integer id)
    {
        return departmentService.get(id);
    }

    @PutMapping("/update")
    public void update(@RequestParam Integer id,@RequestBody Department department)
    {
        departmentService.update(department,id);
    }

}
