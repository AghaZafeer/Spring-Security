package com.example.dem.service;

import com.example.dem.domain.Employee;
import com.example.dem.domain.UserInfo;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public void add(Employee employee);
    public void delete(int id);
    public void update(Employee employee, int id);
    public Optional<Employee> get(int id);

    public String addUser(UserInfo userInfo);

    public List getAll();
}
