package com.aso.cruddemopro.dao;

import com.aso.cruddemopro.entity.Employee;
import jakarta.persistence.Access;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOImpl implements  EmployeeDAO {

    // define field for entitymanager
  private EntityManager entityManager;

    // set up constructor injection.

    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager){

        entityManager = theEntityManager;

    }

    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("From Employee", Employee.class);

        // execute query and get result list

        List<Employee> employees = theQuery.getResultList();


        // return the results

        return employees;
    }

    @Override
    public Employee findById(int theId) {


        Employee  theEmployee =  entityManager.find( Employee.class, theId);

        return  theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        Employee  addEmployee = entityManager.merge(theEmployee);

        return  addEmployee;
    }

    @Override
    public void deleteById(int theId) {

        Employee  employee = entityManager.find(Employee.class, theId);

         entityManager.remove(employee);

    }
}
