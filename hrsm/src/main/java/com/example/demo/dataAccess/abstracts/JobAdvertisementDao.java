package com.example.demo.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
//	@Query("From JobAdvertisement where positionNumber=:positionNumber")
//	JobAdvertisement getByPositionNumber(int positionNumber);

	@Query("From JobAdvertisement where Active=true and employer.id=:id")
	List<JobAdvertisement> getByActiveAndEmployer_Id(int id);

	@Query("From JobAdvertisement where Active=true")
	List<JobAdvertisement> getByActiveTrue();

	@Query("From JobAdvertisement where jobDescription=:jobDescription")
	List<JobAdvertisement> getByJobDescription(String jobDescription);

}
