package com.test.employee;

import com.test.employee.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = EmployeeNotFoundException.class)
    public ResponseEntity tradeNotFoundException(EmployeeNotFoundException employeeNotFoundException) {
        return new ResponseEntity(" Record not found for Employee id "+ employeeNotFoundException.getId(), HttpStatus.NOT_FOUND);
    }
}
