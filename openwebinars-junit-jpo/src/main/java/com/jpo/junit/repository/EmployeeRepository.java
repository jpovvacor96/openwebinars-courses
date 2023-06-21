package com.jpo.junit.repository;

import java.util.List;

import com.jpo.junit.domain.Employee;

public interface EmployeeRepository {

    Integer count();

    List<Employee> findAll();

    Employee findOne(Long id);
    
    Employee save(Employee smartphone);

    boolean delete(Long id);

    void deleteAll();

}
