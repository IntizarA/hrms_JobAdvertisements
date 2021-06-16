package com.example.demo.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.EmployeeActivationService;
import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.entity.concretes.EmployeeActivation;
@Service
public class EmployeeActivationManager implements EmployeeActivationService{

	@Override
	public DataResult<List<EmployeeActivation>> getall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(EmployeeActivation employeeActivation) {
		// TODO Auto-generated method stub
		return null;
	}

}
