package com.test.employee.controller;

import com.test.employee.dao.Employee;
import com.test.employee.exception.EmployeeNotFoundException;
import com.test.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/{id}")
    public ResponseEntity getEmployee(@PathVariable("id") Integer employeeId) throws EmployeeNotFoundException {

        Optional<Employee> employee = employeeRepository.findById(employeeId);

        if(employee.isPresent()) return new ResponseEntity(employee, HttpStatus.OK);
        else throw new EmployeeNotFoundException(employeeId);
    }


    @PutMapping("/")
    public ResponseEntity updateEmployee(@Valid @RequestBody Employee employeeDetails) throws EmployeeNotFoundException {
        Employee employee = employeeRepository.save(employeeDetails);
        return new ResponseEntity(employee,HttpStatus.CREATED);
    }
}
