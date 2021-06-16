package com.example.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.JobAdvertisementService;
import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.ErrorResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.core.utilities.results.SuccessDataResult;
import com.example.demo.core.utilities.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.JobAdvertisementDao;
import com.example.demo.entity.concretes.JobAdvertisement;



@Service
public class JobAdvertisementManager implements JobAdvertisementService {
	@Autowired
	private JobAdvertisementDao jobAdvertisementDao;

	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		if (isConfirmed(jobAdvertisement)) {
			this.jobAdvertisementDao.save(jobAdvertisement);
			return new SuccessResult("Job Advertisement added successfully!");
		} else
			return new ErrorResult("Please, fill all the required boxes!");
	}

	public boolean isConfirmed(JobAdvertisement jobAdvertisement) {
		if (jobAdvertisement.getId() != 0 && jobAdvertisement.getJobDescription() != null
				&& jobAdvertisement.getPositionNumber() != 0) {
			return true;
		} else
			return false;
	}

	@Override
	public Result update(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Data updated successfully!");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),"Data listed");
	}

	@Override
	public DataResult<JobAdvertisement> getById(int id) {
		
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.getOne(id));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllSorted() {
		Sort sort=Sort.by(Sort.Direction.DESC,"positionNumber");
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort),"Successfully!");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByActiveAndId(int id) {
	
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.getByActiveAndEmployer_Id(id),"Job Advertisements are listed accordig to Employer id successfully!");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByActive() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByActiveTrue(),"Active job advertisements listed successfully!");
	}

	@Override
	public Result changeActiveToDeactive(int id) {
		
	if(getById(id)==null) {
		return new ErrorResult("Fill required box!");
	}
	if(getById(id).getData().isActive()==false) {
		return new ErrorResult("Job Advertisement is not active!");
	}
	JobAdvertisement jobAdvertisement=getById(id).getData();
	jobAdvertisement.setActive(false);
	update(jobAdvertisement);
	return new SuccessResult("Job Advertisement is deactivated!");
	
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByJobDescriptionContains(String jobDescription) {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByJobDescription(jobDescription));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByActiveAndEmployer_Id(int id) {
		
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.getByActiveAndEmployer_Id(id),"Job Advertisement listed by Employer id ");
	}


	

}
