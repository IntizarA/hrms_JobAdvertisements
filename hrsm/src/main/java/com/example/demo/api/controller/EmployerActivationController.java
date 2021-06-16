package com.example.demo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.EmployerActivationService;
import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.entity.concretes.EmployerActivation;
@RestController
@RequestMapping("/api/employeractivation")
public class EmployerActivationController {
@Autowired
	private EmployerActivationService employerActivation;
@GetMapping("/getall")
public DataResult<List<EmployerActivation>>getall(){
	return this.employerActivation.getall();
}
@PostMapping("/checkactivationcode")
public Result checkactivationcode(@RequestParam("activationCode") String activationCode,@RequestParam("activationCodeId") int activationCodeId) {
	 return this.employerActivation.checkActivationcode(activationCode, activationCodeId);
}

}
