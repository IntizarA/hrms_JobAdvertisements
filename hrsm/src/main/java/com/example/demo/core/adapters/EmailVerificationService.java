package com.example.demo.core.adapters;

public interface EmailVerificationService {
boolean isVerificationEmail(String email);
boolean isSuccessVerificationEmail(boolean success);
}
