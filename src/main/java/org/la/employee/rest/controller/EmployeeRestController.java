package org.la.employee.rest.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.la.employee.model.EmployeeModel;
import org.la.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;
	
	//-------------------------------------------------------------------------------------------findAll
	@GetMapping("/findAll")
	public List <EmployeeModel> findAll(){
		return employeeService.findAll();
	}
	
	//-------------------------------------------------------------------------------------------find by id 
	@GetMapping("/findById/{id}")
	public String findById(@PathVariable Long id) {
		return employeeService.findById(id);
	}
	
	//---------------------------------------------------------------------------------------------Add/Save
	@PostMapping("/add")
	public EmployeeModel add(@RequestBody EmployeeModel employees) {
		return employeeService.add(employees);
	}
	
	//---------------------------------------------------------------------------------------------Delete
	@DeleteMapping("/delete/{id}")
	public void  delete(@PathVariable("id") Long id, HttpServletResponse response) {
		employeeService.delete(id);
	}

	//---------------------------------------------------------------------------------------------update
	@PutMapping("/update/{id}")
	public String update(@PathVariable("id") Long id, @RequestBody EmployeeModel employees) {
		return employeeService.update(id, employees);
	}
	
	//----------------------------------------------------------------------------------------------find by name
	@GetMapping("/name/{name}")
	public String findEmpByName(@PathVariable String name) {
		return employeeService.findEmpByName(name);
		
	}
}
