package com.example.demo.core.abstracts;

import org.springframework.stereotype.Service;

@Service
public class MailSendService {
public void sendMail(String email) {
	System.out.println(email+" succesfull message sent to your email!");
}
}
