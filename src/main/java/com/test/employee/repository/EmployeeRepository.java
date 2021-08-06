package com.test.employee.repository;

import com.test.employee.dao.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Query("update Employee e set e.firstName = ?1, e.lastName = ?2 where e.id = ?3")
    Employee setUserById(Employee employee);
}
