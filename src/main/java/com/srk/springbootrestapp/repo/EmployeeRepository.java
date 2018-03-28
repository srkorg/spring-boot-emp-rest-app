package com.srk.springbootrestapp.repo;

import com.srk.springbootrestapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
