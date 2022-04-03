package com.prototype.rest.api;

import com.prototype.entities.Employee;
import com.prototype.entities.repositories.EmployeeRepository;
import com.prototype.logic.EmployeeAccess;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
public class Employees {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private EmployeeAccess access;

    @GetMapping("/employees")
    public List<Employee> getAll() {
        return this.access.getAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getById(@PathVariable Long id) {
        return this.access.getById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/employees/card/{card}")
    public Employee getByCard(@PathVariable Integer card) {
        return this.access.getByCard(card).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/employees")
    public Employee create(@RequestBody Employee employee) {
        return this.access.create(employee);
    }

    @PutMapping("/employees/{id}")
    public Employee update(@RequestBody Employee employee, @PathVariable Long id) {
        final Employee dbEmployee = this.access.getById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        dbEmployee.setName(employee.getName());
        dbEmployee.setFirstname(employee.getFirstname());
        dbEmployee.setCard(employee.getCard());
        return this.access.update(dbEmployee);
    }

    @DeleteMapping("/employees/{id}")
    public void delete(@PathVariable Long id) {
        this.access.delete(id);
    }

    @GetMapping("/employees/{id}/history")
    public void tst(@PathVariable Long id) {
        AuditReader reader = AuditReaderFactory.get(this.entityManager);
        List<Number> revs = reader.getRevisions(Employee.class, id);
        System.out.println("REVS: " + revs);
    }

}
