package com.lab.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
