package com.example.demo.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.JobAdvertisementService;
import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.entity.concretes.JobAdvertisement;

@RestController
@RequestMapping("api/jobadvertisements")
public class JobAdvertisementController {
	@Autowired
	private JobAdvertisementService jobAdvertisementService;

	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getall() {

		return this.jobAdvertisementService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}

//@PostMapping("/update")
//public Result update(JobAdvertisement jobAdvertisement) {
//	return this.update(jobAdvertisement);
//}
	@PostMapping("/changeActiveToDeactive")
	public Result changeActiveToDeactive(@RequestBody int id) {
		return this.jobAdvertisementService.changeActiveToDeactive(id);

	}

	@GetMapping("/getAllActiveTrue")
	public DataResult<List<JobAdvertisement>> getAllActiveTrue() {
		return this.jobAdvertisementService.getByActive();
	}
@GetMapping("/getByActiveAndCreateDateDesc")
public DataResult<List<JobAdvertisement>> getAllSorted(){
	return this.jobAdvertisementService.getAllSorted();
}
@GetMapping("/getByJobDescriptionContains")
public DataResult<List<JobAdvertisement>> getByJobDescriptionContains(@RequestParam String jobDescription){
	return this.jobAdvertisementService.getByJobDescriptionContains(jobDescription);
}
@GetMapping("/getByActiveAndEmployer_Id")
public DataResult<List<JobAdvertisement>>getByActiveAndEmployer_Id(@RequestParam int id){
	return this.jobAdvertisementService.getByActiveAndEmployer_Id(id);
}

}
