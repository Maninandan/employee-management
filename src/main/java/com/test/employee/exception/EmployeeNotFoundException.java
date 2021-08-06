package com.test.employee.exception;

public class EmployeeNotFoundException extends Exception{
    private int id;
    public EmployeeNotFoundException(int id) {
        super();
        this.id = id;
    }
    public EmployeeNotFoundException() {
    }

    public int getId() {
        return id;
    }
}
