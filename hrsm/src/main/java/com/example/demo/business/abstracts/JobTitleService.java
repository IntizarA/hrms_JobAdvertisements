package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.entity.concretes.JobTitle;

public interface JobTitleService {
	
DataResult<List<JobTitle>>getAll();
Result add(JobTitle jobTitle);
Result delete(JobTitle jobTitle);
}
