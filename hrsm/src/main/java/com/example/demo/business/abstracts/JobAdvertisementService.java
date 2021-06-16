package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.entity.concretes.JobAdvertisement;

public interface JobAdvertisementService {
Result add(JobAdvertisement jobAdvertisement);
Result update(JobAdvertisement jobAdvertisement);
Result changeActiveToDeactive(int id);
DataResult<List<JobAdvertisement>> getAll();
DataResult<JobAdvertisement> getById(int id);
DataResult<List<JobAdvertisement>> getAllSorted();
DataResult<List<JobAdvertisement>> getByActiveAndId(int id);
DataResult<List<JobAdvertisement>> getByActive();
DataResult<List<JobAdvertisement>> getByJobDescriptionContains(String jobDescription);
DataResult<List<JobAdvertisement>> getByActiveAndEmployer_Id(int id);
}
