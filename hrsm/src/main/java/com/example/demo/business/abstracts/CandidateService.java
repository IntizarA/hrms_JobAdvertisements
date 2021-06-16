package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.entity.concretes.Candidate;

public interface CandidateService {
	DataResult<List<Candidate>> getall();

	Result add(Candidate candidate);
	Result checkEmail(String email);
	//Result addAndCheckEmail(Candidate candidate, String email);
//
//	DataResult<Candidate> getByNationalityId(String nationalityId);
//
//	DataResult<List<Candidate>> getByUser_EmailContains(String email);
}
