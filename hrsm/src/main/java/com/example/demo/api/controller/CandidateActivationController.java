package com.example.demo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.CandidateActivationService;
import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.entity.concretes.CandidateActivation;

@RestController
@RequestMapping("/api/candidateactivation")
public class CandidateActivationController {
	@Autowired
	private CandidateActivationService candidateActivationService;

	@GetMapping("/getall")
	public DataResult<List<CandidateActivation>> getall() {
		return this.candidateActivationService.getall();
	}
	
	@PostMapping("/checkactivationcode")
	public Result checkActivationcode(@RequestParam("activationCode") String activationCode,@RequestParam("activationId") int activationId) {
		return this.candidateActivationService.checkActivationCode(activationCode, activationId);
	}
}
