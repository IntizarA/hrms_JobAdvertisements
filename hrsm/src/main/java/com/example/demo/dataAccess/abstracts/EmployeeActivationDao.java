package com.example.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.concretes.EmployeeActivation;

public interface EmployeeActivationDao extends JpaRepository<EmployeeActivation, Integer> {

}
