package com.example.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
	Employee getById(int id);
}
