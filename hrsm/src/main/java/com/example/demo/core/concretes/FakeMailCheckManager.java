package com.example.demo.core.concretes;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.example.demo.core.abstracts.MailCheckService;
@Primary
@Component
public class FakeMailCheckManager implements MailCheckService{

	@Override
	public boolean isChecked(String email) {
	
		return true;
	}

}
