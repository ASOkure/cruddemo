package com.aso.cruddemopro.service;

import com.aso.cruddemopro.dao.EmployeeDAO;
import com.aso.cruddemopro.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements  EmployeeService{

   private  EmployeeDAO employeeDAO;



           public EmployeeServiceImpl( EmployeeDAO theEmployeeDAO){

                 employeeDAO = theEmployeeDAO;
           }

    @Override
    public List<Employee> findAll() {
        return  employeeDAO.findAll();

    }
}