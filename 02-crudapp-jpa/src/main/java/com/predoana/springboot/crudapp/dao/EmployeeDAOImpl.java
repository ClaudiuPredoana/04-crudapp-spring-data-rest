package com.predoana.springboot.crudapp.dao;

import com.predoana.springboot.crudapp.entity.Employee;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {



    // define field entity manager
    private EntityManager entityManager;

    //set up constrictor injection
    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager) {
        entityManager=theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        //get the current hibernate session
        Session currentSession =entityManager.unwrap(Session.class);

        //create a query
        Query<Employee> theQuery =
                currentSession.createQuery("from Employee" , Employee.class);

        //execute query and get result list
        List<Employee> employees =theQuery.getResultList();

        //return the result
        return employees;
    }

    @Override
    public Employee findById(int theId) {

        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //get the employee
        Employee theEmployee =
                currentSession.get(Employee.class, theId);

        //return the employee
        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {

        //get the current hibernate session
        Session currrentSession = entityManager.unwrap(Session.class);

        //save employee
        currrentSession.saveOrUpdate(theEmployee);

    }

    @Override
    public void deleteById(int theId) {

        //get the current hibernate session
        Session currrentSession = entityManager.unwrap(Session.class);

        //delete object with primary key
        Query theQuery=
                currrentSession.createQuery(
                        "delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId", theId);

        theQuery.executeUpdate();

    }

}
