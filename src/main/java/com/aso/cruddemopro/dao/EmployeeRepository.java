package com.aso.cruddemopro.dao;

import com.aso.cruddemopro.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
