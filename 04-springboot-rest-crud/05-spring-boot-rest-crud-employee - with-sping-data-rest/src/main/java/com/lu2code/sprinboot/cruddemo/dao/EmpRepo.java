package com.lu2code.sprinboot.cruddemo.dao;

import com.lu2code.sprinboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path="members")
public interface EmpRepo extends JpaRepository<Employee,Integer> {
}
