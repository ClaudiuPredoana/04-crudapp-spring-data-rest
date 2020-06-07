package com.predoana.springboot.crudapp.service;

import com.predoana.springboot.crudapp.dao.EmployeeRepository;
import com.predoana.springboot.crudapp.entity.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl( EmployeeRepository theEmployeeDAO) {
		employeeRepository = theEmployeeDAO;
	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		
		return employeeRepository.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		
		return employeeRepository.findById(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		
		employeeRepository.save(theEmployee);
		
	}

	@Override
	@Transactional
	public void deleteById(int theId) {

		employeeRepository.deleteById(theId);
	}

}
