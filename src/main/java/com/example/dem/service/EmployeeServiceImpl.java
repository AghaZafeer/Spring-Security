package com.example.dem.service;


import com.example.dem.domain.Employee;
import com.example.dem.domain.UserInfo;
import com.example.dem.repository.EmployeeRepository;
import com.example.dem.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{


    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void add(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(int id) {
    employeeRepository.deleteById(id);
    }

    @Override
    public void update(Employee employee, int id) {
        employeeRepository.deleteById(id);
        employee.setId(id);
    employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> get(int id) {
      return employeeRepository.findById(id);
    }

    @Override
    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "user added to system ";
    }
    @Override
    public List getAll()
    {
         return employeeRepository.findAll();
    }

}
