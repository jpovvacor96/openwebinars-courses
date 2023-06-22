package com.jpo.junit.service;

import java.util.List;
import java.util.Optional;

import com.jpo.junit.domain.Employee;

public interface EmployeeService {

    Integer count();

    List<Employee> findAll();

    Employee findOne(Long id);

    Optional<Employee> findOneOptional(Long id);

    Employee save(Employee employee);

    boolean delete(Long id);

    void deleteAll();
}
