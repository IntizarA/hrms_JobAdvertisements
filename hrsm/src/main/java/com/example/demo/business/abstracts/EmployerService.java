package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.entity.concretes.Employer;

public interface EmployerService {
DataResult<List<Employer>>getall();
Result add(Employer employer);
Result delete(Employer employer);
Result update(Employer employer);

}
