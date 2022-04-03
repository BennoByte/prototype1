package com.prototype.logic;

import com.prototype.entities.Employee;
import com.prototype.entities.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeAccess {

    @Autowired
    private EmployeeRepository repo;

    public List<Employee> getAll() {
        return (List<Employee>) this.repo.findAll();
    }

    public Optional<Employee> getById(long id) {
        return this.repo.findById(id);
    }

    public Optional<Employee> getByCard(Integer card) {
        return this.repo.findByCard(card);
    }

    public Employee create(Employee employee) {
        return this.repo.save(employee);
    }

    public Employee update(Employee employee) {
        return this.repo.save(employee);
    }

    public void delete(long id) {
        this.repo.deleteById(id);
    }

}
