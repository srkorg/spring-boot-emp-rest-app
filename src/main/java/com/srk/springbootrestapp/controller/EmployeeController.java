package com.srk.springbootrestapp.controller;


import com.srk.springbootrestapp.entity.Employee;
import com.srk.springbootrestapp.service.EmployeeService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final static Logger log = Logger.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
        log.debug("Added :: " + employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> updateEmployee(@RequestBody Employee employee) {
        Employee employeeDb = employeeService.getById(employee.getId());
        if (employeeDb == null) {
            log.debug("Employee with id " + employee.getId() + " does't exists.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employeeService.save(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) {
        Employee employee = employeeService.getById(id);
        if (employee == null) {
            log.debug("Employee with id " + id + " doesn't exists.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        log.debug("Found Employee :: " + employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAll();
        if (employees.isEmpty()) {
            log.debug("Employees does't exists.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        log.debug("Found " + employees.size() + " Employees.");
        log.debug(employees);
        log.debug(Arrays.toString(employees.toArray()));
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id) {
        Employee employee = employeeService.getById(id);
        if (employee == null) {
            log.debug("Employee with id " + id + " doesn't exists.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employeeService.delete(id);
        log.debug("Employee with id " + id + " deleted.");
        return new ResponseEntity<>(HttpStatus.GONE);
    }

}