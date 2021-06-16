package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.entity.concretes.Employee;
import com.example.demo.entity.concretes.EmployerActivation;

public interface EmployerActivationService {

	DataResult<List<EmployerActivation>> getall();

	Result checkActivationcode(String activationCode, int activationCodeId);

	Result checkActivationcodeFromEmployee(int activationCodeId, int employeeUserId);

	boolean creatActivationCode(int activationCodeId, Employee employee);
	
	Employee getByEmployeeUserId(int activationCodeId);

}
