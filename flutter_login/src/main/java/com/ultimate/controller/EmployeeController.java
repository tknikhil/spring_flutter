package com.ultimate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ultimate.entity.EmployeeEntity;
import com.ultimate.model.Employee;
import com.ultimate.service.EmployeeService;

@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "getallemployees",method = RequestMethod.GET)
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployee();
	}
	
	@RequestMapping(value = "addemployee",method = RequestMethod.POST)
	public String addEmployee(@RequestBody EmployeeEntity employeeEntity) {
		return employeeService.addEmployee(employeeEntity);
	}
	
	@RequestMapping(value = "updateemployee",method = RequestMethod.PUT)
	public String updateEmployee(@RequestBody EmployeeEntity employeeEntity) {
		return employeeService.updateEmployee(employeeEntity);
	}
	
	@RequestMapping(value = "removeemployee",method = RequestMethod.DELETE)
	public String deleteEmployee(@RequestBody EmployeeEntity employeeEntity) {
		return employeeService.removeEmployee(employeeEntity);
	}
}
