package com.lu2code.sprinboot.cruddemo.dao;

import com.lu2code.sprinboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepo extends JpaRepository<Employee,Integer> {
}
