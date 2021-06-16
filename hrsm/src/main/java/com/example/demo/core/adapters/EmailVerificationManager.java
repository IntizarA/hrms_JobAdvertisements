package com.example.demo.core.adapters;

import org.springframework.stereotype.Service;

@Service
public class EmailVerificationManager implements EmailVerificationService {

	@Override
	public boolean isVerificationEmail(String email) {
		
		return true;
	}

	@Override
	public boolean isSuccessVerificationEmail(boolean success) {
		if(success) {
			return true;
		}
		else	return false;
	}

}
