package com.example.demo.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.CandidateActivationService;
import com.example.demo.core.adapters.EmailVerificationService;
import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.ErrorResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.core.utilities.results.SuccessDataResult;
import com.example.demo.core.utilities.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.CandidateActivationCodeDao;
import com.example.demo.entity.concretes.ActivationCode;
import com.example.demo.entity.concretes.Candidate;
import com.example.demo.entity.concretes.CandidateActivation;

@Service
public class CandidateActivationManager implements CandidateActivationService {
	@Autowired
private CandidateActivationCodeDao candidateActiovationCodeDao;
	@Autowired
private EmailVerificationService emailVerificationService;

	@Override
	public DataResult<List<CandidateActivation>> getall() {
		
		return new SuccessDataResult<List<CandidateActivation>>(this.candidateActiovationCodeDao.findAll(),"Data listed successfully");
	}
	private String codeGenerator() {
	    int upperBound = 9999, lowerBound = 1000;
		int randomCode = lowerBound + (int) (Math.random()*(upperBound - lowerBound)+1);
		String code = String.valueOf(randomCode);
		return code;
	}//kod generasiya edildi
	@Override
	public boolean creatActivationCode(int id, Candidate candidate) {
		CandidateActivation candidateActivation=new CandidateActivation();
		ActivationCode activationCode=new ActivationCode();
		activationCode.setActivatioCode(codeGenerator());
	
		activationCode.setConfirmed(false);
		activationCode.setDateConfirm(null);
		candidateActivation.setActivationCode(activationCode);
		candidateActivation.setActivationCodeId(id);
		this.candidateActiovationCodeDao.save(candidateActivation);
		if(emailVerificationService.isVerificationEmail(candidate.getUser().getEmail())) {
			return true;
		}
		else  return false;
	}

	@Override
	public Result checkActivationCode(String acticationCode, int activationId) {
		if(isSuccessCode(acticationCode, activationId)) {
			return new SuccessResult("Activation code is confirmed.");
		}else {
			return new ErrorResult("Activation code is not confirmed.");
		}
		
	}
	public boolean isSuccessCode(String activationCode, int activationId) {
		boolean isActivationCode = false;
		for(CandidateActivation checkActivationCode:this.candidateActiovationCodeDao.findAll()) {
			if( checkActivationCode.getActivationCode().getActivatioCode().equals(activationCode) && checkActivationCode.getActivationCode().getActivationCodeId() == activationId) {
				this.candidateActiovationCodeDao.updateDateConfirm(activationId, LocalDate.now());
				isActivationCode = true;
			}
		}
		return isActivationCode;
	}	
}
