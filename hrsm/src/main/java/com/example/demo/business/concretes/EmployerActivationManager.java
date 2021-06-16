package com.example.demo.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.EmployerActivationService;
import com.example.demo.core.adapters.EmailVerificationService;
import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.ErrorResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.core.utilities.results.SuccessDataResult;
import com.example.demo.core.utilities.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.EmployeeActivationDao;
import com.example.demo.dataAccess.abstracts.EmployeeDao;
import com.example.demo.dataAccess.abstracts.EmployerActivationDao;
import com.example.demo.entity.concretes.ActivationCode;
import com.example.demo.entity.concretes.CandidateActivation;
import com.example.demo.entity.concretes.Employee;
import com.example.demo.entity.concretes.EmployeeActivation;
import com.example.demo.entity.concretes.EmployerActivation;

@Service
public class EmployerActivationManager implements EmployerActivationService {
	@Autowired
	private EmployerActivationDao employerActivationDao;
	@Autowired
	private EmailVerificationService emailVerificationService;
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public DataResult<List<EmployerActivation>> getall() {

		return new SuccessDataResult<List<EmployerActivation>>(this.employerActivationDao.findAll(),
				"Data listed successfully");
	}

	@Override
	public Result checkActivationcode(String activationCode, int activationCodeId) {
		if (isSuccessCode(activationCode, activationCodeId)) {
			return new SuccessResult("Activation code is confirmed");
		} else
			return new ErrorResult("Activation code is not confirmed");
	}

	@Override
	public Result checkActivationcodeFromEmployee(int activationCodeId, int employeeUserId) {
		if (employeeDao.getById(activationCodeId) == null) {
			return new ErrorResult("Müdaxilə edilə bilməz!");
		} else {
			this.employerActivationDao.updateDateConfirm(activationCodeId, LocalDate.now());
			return new SuccessResult("Istifadəçi aktiv edildi!");
		}
	}

	@Override
	public boolean creatActivationCode(int activationCodeId, Employee employee) {
		ActivationCode activationCode = new ActivationCode();
		EmployerActivation employerActivation = new EmployerActivation();
		activationCode.setActivatioCode(codeGenerator());
		employerActivation.setActivationCodeId(activationCodeId);
		activationCode.setConfirmed(false);
		activationCode.setDateConfirm(null);
		employerActivation.setActivationCode(activationCode);
		this.employerActivationDao.save(employerActivation);
		if (emailVerificationService.isVerificationEmail(employee.getUser().getEmail())) {
			return true;
		} else
			return false;
	}

	@Override
	public Employee getByEmployeeUserId(int activationCodeId) {

		return this.employeeDao.getById(activationCodeId);
	}

	private String codeGenerator() {
		int upperBound = 9999, lowerBound = 1000;
		int randomCode = lowerBound + (int) (Math.random() * (upperBound - lowerBound) + 1);
		String code = String.valueOf(randomCode);
		return code;
	}// kod generasiya edildi

	public boolean isSuccessCode(String activationCode, int activationId) {
		boolean isActivationCode = false;
		for (EmployerActivation checkActivationCode : this.employerActivationDao.findAll()) {
			if (checkActivationCode.getActivationCode().getActivatioCode().equals(activationCode)
					&& checkActivationCode.getActivationCode().getActivationCodeId() == activationId) {
				this.employerActivationDao.updateDateConfirm(activationId, LocalDate.now());
				isActivationCode = true;
			}
		}
		return isActivationCode;
	}
}
