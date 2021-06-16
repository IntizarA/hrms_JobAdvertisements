package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.entity.concretes.Candidate;
import com.example.demo.entity.concretes.CandidateActivation;

public interface CandidateActivationService {
	DataResult<List<CandidateActivation>> getall();
    boolean creatActivationCode(int id,Candidate candidate);
    Result checkActivationCode(String activationCode, int activationId);
}
