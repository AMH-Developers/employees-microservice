package org.la.employee.service;

import java.util.List;
import java.util.Optional;

import org.la.employee.model.EmployeeModel;
import org.la.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	//---------------------------------------------------------------------------------------------findAll
	public List<EmployeeModel> findAll() {
		return employeeRepository.findAll();
	}

	//--------------------------------------------------------------------------------------------findById 
	public String findById(Long id) {
		Optional<EmployeeModel> employeeModel= employeeRepository.findById(id);
		if(employeeModel.isPresent()) {
			return "exist";
		} else {
			return "not exist";
		}
	
}
	
	//----------------------------------------------------------------------------------------------find by name
		public String findEmpByName(String name) {
			Optional<EmployeeModel> employeeModel =  employeeRepository.findEmpByName(name);
			if(employeeModel.isPresent()) {
				return "exist";
			} else {
				return "not exist";
			}
		}
	
	//----------------------------------------------------------------------------------------------Add/Save
	public EmployeeModel add(EmployeeModel employees) {
		return employeeRepository.save(employees); 
	}

	//----------------------------------------------------------------------------------------------Delete
	public void delete(Long id) {
		employeeRepository.deleteById(id);	
	}


	//----------------------------------------------------------------------------------------------update
	public String update(Long id, EmployeeModel employees) {
		Optional <EmployeeModel> emp =  employeeRepository.findById(id);
		employees.setName(employees.getName());
		employees.setEmail(employees.getEmail());
		employees.setPassword(employees.getPassword());
		employees.setTitle(employees.getTitle());
		employees.setNumberOfTasks(employees.getNumberOfTasks());
		if(emp.isPresent()) {
			employeeRepository.save(employees);
			return "success";
			
		} else {
			return "null";
		}	}
		
		//----------------------------------------------------------------------------------------------update	another way without setters
	/*	public String update(Long id, EmployeeModel employees) {
			Optional<EmployeeModel> emp = employeeRepository.findById(id);
			if(emp.isPresent()) {
				employeeRepository.save(employees);
				return "success";
				
			} else {
				return "null";
			}
		}
		
}*/
		
	


	

}
