package com.example.demo.dataAccess.abstracts;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {
	Candidate getByNationalityId(String nationalityId);

	Candidate getByUser_EmailContains(String email);
//	@Modifying(clearAutomatically = true)
//	@Transactional
	@Query("From User where email=:email and id=:id")
	void update(@Param("email") String email,@Param("id") int id);
	//email-den sadece qisa hisse ile tapmaq meselen intizar.aliyeva69@gmail.com 
	//men ise sadece intizar yazaraq netice almaq isteyirem. Chunki intizar intizar.aliyeva@9@gmail.com ichinde var(contains)
}
