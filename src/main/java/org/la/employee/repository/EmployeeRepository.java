package org.la.employee.repository;

import java.util.Optional;

import org.la.employee.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long >{

	Optional<EmployeeModel> findEmpByName(String name);

}
