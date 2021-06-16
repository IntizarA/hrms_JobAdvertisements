package com.example.demo.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.CandidateService;
import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.ErrorResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.core.utilities.results.SuccessDataResult;
import com.example.demo.core.utilities.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.CandidateDao;
import com.example.demo.entity.concretes.Candidate;
import com.example.demo.entity.concretes.CandidateActivation;
import com.example.demo.entity.concretes.User;
@Service
public class CandidateManager implements CandidateService {
	private CandidateDao candidateDao;

	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}

	@Override
	public DataResult<List<Candidate>> getall() {

		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Candidate's data listed");
	}

	@Override
	public Result add(Candidate candidate) {

		this.candidateDao.save(candidate);
		return new SuccessResult("Candidate's data added");
	}

	@Override
	public Result checkEmail(String email) {
		Candidate candidate =new Candidate();
	if(isSuccessCode(email)){
		return new SuccessResult("Never used before");
		
		
	}
	else  return new ErrorResult("Used Before");
	}
	
		

	
	public boolean isSuccessCode(String email) {
		User user=new User();
		boolean isFirtTimeOfEmail = true;
		for(Candidate checkEmail:this.candidateDao.findAll()) {
			if( checkEmail.getUser().getEmail().equals(email)) {
				this.candidateDao.update(email,user.getId());
				isFirtTimeOfEmail = false;
			}
		}
		return isFirtTimeOfEmail;
//	@Override
//	public DataResult<Candidate> candidateNationalityId(String nationalityNumber) {
//		
//		return new SuccessDataResult<Candidate>(this.candidateDao.findByNationalityId(nationalityNumber));
//	}

	
}

	//@Override
//	public Result addAndCheckEmail(Candidate candidate, String email) {
//		this.candidateDao.save(candidate);
//		//return new SuccessResult("Candidate's data added");
//		//Candidate candidate =new Candidate();
//		if(isSuccessCode(email)){
//			this.candidateDao.save(candidate);
//			return new SuccessResult("Candidate's data added");
//			
//			
//		}
//		else  return new ErrorResult("This Email Used Before!");
//	
//	}
	}
