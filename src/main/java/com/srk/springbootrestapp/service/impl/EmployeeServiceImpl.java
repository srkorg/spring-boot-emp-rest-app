package com.srk.springbootrestapp.service.impl;

import com.srk.springbootrestapp.entity.Employee;
import com.srk.springbootrestapp.repo.EmployeeRepository;
import com.srk.springbootrestapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee getById(Long id) {
        return employeeRepository.getOne(id);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
}
