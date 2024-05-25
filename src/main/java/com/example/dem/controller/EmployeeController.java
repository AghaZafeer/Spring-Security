package com.example.dem.controller;

import com.example.dem.domain.Employee;
import com.example.dem.domain.UserInfo;
import com.example.dem.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@CrossOrigin(origins="*")
public class EmployeeController {


    Logger logger= LoggerFactory.getLogger(EmployeeController.class);
    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService)
    {
     this.employeeService=employeeService;
    }

    @RequestMapping("/")
    public String hello()
    {
        return "Hello";
    }

    @PostMapping("/new")
    public String addNewUser(@RequestBody UserInfo userInfo){
        return employeeService.addUser(userInfo);
    }

    @PostMapping("/add")
    public void add(@RequestBody Employee employee)
    {
        logger.info("INFO");
        employeeService.add(employee);

    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id)
    {
    employeeService.delete(id);

    }

    @GetMapping("/getAll")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List getAll()
    {
        return employeeService.getAll();
    }


    @GetMapping("/get/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Optional<Employee> get(@PathVariable Integer id)
    {
        return employeeService.get(id);
    }

    @PutMapping("/update")
    public void update(@RequestParam Integer id,@RequestBody Employee employee)
    {
        employeeService.update(employee,id);
    }


}
