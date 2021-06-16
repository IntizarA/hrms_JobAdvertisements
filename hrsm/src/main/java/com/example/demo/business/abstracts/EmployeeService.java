package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.entity.concretes.Employee;

public interface EmployeeService {
DataResult<List<Employee>>getall();
Result add(Employee employee);
Result delete(Employee employee);
//Result checkemail(String email);
}
