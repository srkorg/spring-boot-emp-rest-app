package com.srk.springbootrestapp.service;

import com.srk.springbootrestapp.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee getById(Long id);

    Employee save(Employee employee);

    List<Employee> getAll();

    void delete(Long id);
}
