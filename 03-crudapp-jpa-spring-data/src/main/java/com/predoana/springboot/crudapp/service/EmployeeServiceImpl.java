package com.predoana.springboot.crudapp.service;

import com.predoana.springboot.crudapp.dao.EmployeeRepository;
import com.predoana.springboot.crudapp.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl( EmployeeRepository theEmployeeDAO) {
		employeeRepository = theEmployeeDAO;
	}
	
	@Override
	public List<Employee> findAll() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {

		Optional<Employee> result = employeeRepository.findById(theId);

		Employee theEmployee = null;

		if (result.isPresent()) {
			theEmployee=result.get();
		}
		else {
			// didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		
		employeeRepository.save(theEmployee);
		
	}

	@Override
	public void deleteById(int theId) {

		employeeRepository.deleteById(theId);
	}

}
