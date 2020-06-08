package com.predoana.springboot.crudapp.dao;

import com.predoana.springboot.crudapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
