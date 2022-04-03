package com.prototype.entities.repositories;

import com.prototype.entities.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    public Employee findByEmpNr1(String empNr1);
    public Employee findByEmpNr2(String empNr2);
    public Optional<Employee> findByCard(int card);

}
