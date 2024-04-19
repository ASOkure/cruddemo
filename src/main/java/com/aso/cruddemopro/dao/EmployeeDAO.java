package com.aso.cruddemopro.dao;

import com.aso.cruddemopro.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
