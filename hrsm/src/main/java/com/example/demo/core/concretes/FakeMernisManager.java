package com.example.demo.core.concretes;

import com.example.demo.core.abstracts.MernisService;
import com.example.demo.entity.concretes.Candidate;

public class FakeMernisManager implements MernisService {

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
	
		return true;
	}

}
