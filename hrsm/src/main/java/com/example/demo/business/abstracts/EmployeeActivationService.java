package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.entity.concretes.EmployeeActivation;

public interface EmployeeActivationService {
	DataResult<List<EmployeeActivation>> getall();

	Result add(EmployeeActivation employeeActivation);
}
