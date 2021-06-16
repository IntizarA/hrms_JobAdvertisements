package com.example.demo.core.concretes;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.example.demo.core.abstracts.MailCheckService;
@Component
public class MailCheckManager implements MailCheckService{
private static final String email_pattern="^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
	@Override
	public boolean isChecked(String email) {
		Pattern pattern=Pattern.compile(email_pattern, Pattern.CASE_INSENSITIVE);
		return true;
	}

}
