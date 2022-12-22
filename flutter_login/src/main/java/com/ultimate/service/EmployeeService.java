package com.ultimate.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ultimate.entity.EmployeeEntity;
import com.ultimate.model.Employee;
import com.ultimate.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	//get
	public List<Employee> getAllEmployee() {
		List<EmployeeEntity> employees = employeeRepository.findAll();
		List<Employee> employeeList = new ArrayList<>();
		employees.stream().forEach(e -> {
			Employee employee = new Employee();
			BeanUtils.copyProperties(e, employee);
			employeeList.add(employee);
		});
		return employeeList;
	}

	//save
	public String addEmployee(EmployeeEntity employeeEntity) {
		if (!employeeRepository.existsByFirstnameAndLastname(employeeEntity.getFirstname(),
				employeeEntity.getLastname())) {
			employeeRepository.save(employeeEntity);
		} else {
			return "Employee Already exists!";
		}
		return "Employee Saved!";
	}

	//delete
	public String removeEmployee(EmployeeEntity employeeEntity) {
		if (employeeRepository.existsByFirstnameAndLastname(employeeEntity.getFirstname(),
				employeeEntity.getLastname())) {
			employeeRepository.delete(employeeEntity);
		} else {
			return "Employee Not exists!";
		}
		return "Employee Deleted!";
	}

	//update
	public String updateEmployee(EmployeeEntity employeeEntity) {
		if (employeeRepository.existsById(employeeEntity.getId())) {
			employeeRepository.save(employeeEntity);
		} else {
			return "Employee Not exists!";
		}
		return "Employee Updated!";
	}
}
