package com.example.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
	Employer getByUser_Email(String email);

	Employer getByUser_EmailContains(String email);
}
