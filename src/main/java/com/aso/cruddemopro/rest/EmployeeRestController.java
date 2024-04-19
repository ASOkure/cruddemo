package com.aso.cruddemopro.rest;


import com.aso.cruddemopro.dao.EmployeeDAO;
import com.aso.cruddemopro.entity.Employee;
import com.aso.cruddemopro.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {


    private EmployeeService employeeService;
    // quick and dirty: inject employee dao ( use constructor injection)

    public  EmployeeRestController( EmployeeService theEmployeeSerive){

       employeeService = theEmployeeSerive;
    }

    // expose " /employees" and return a list of employees

    @GetMapping("/employees")

    public List<Employee> findAll(){

        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")

    public Employee getEmployee(@PathVariable  int employeeId){

        Employee theEmployee =  employeeService.findById(employeeId);

        if(theEmployee == null) {

            throw new RuntimeException(" Employee id not found - " + employeeId);
        }

                return theEmployee;

        }

        // add mapping for POST /employees - add new employee

     @PostMapping("/employees")

    public  Employee addEmployee(@RequestBody Employee theEmployee){

        theEmployee.setId(0);

      Employee addEmployee =  employeeService.save(theEmployee);

       return  addEmployee;
     }

     // add mapping for PUT /employees- update existing employee

    @PutMapping("/employees")

    public Employee updateEmployee(@RequestBody Employee theEmployee){

        Employee dbemployee = employeeService.save(theEmployee);

        return dbemployee;
    }

    // add mapping for DELETE /employees/{employeeid} - delete employee

    @DeleteMapping("/employees/{employeeId}")

    public String deleteEmployee(@PathVariable int employeeId){

        Employee temEmployee = employeeService.findById(employeeId);

        if (temEmployee == null) {

            throw new RuntimeException(" Employeee does not exist " + employeeId);
        }
             employeeService.deleteById(employeeId);

        return " Deleted employee id - " + employeeId;
        }


    }


