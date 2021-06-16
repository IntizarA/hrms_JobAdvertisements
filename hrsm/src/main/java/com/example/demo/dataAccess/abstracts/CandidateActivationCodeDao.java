package com.example.demo.dataAccess.abstracts;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.concretes.CandidateActivation;

public interface CandidateActivationCodeDao extends JpaRepository<CandidateActivation, Integer> {
@Modifying(clearAutomatically = true)
@Transactional
@Query("Update ActivationCode Set isConfirmed = true, dateConfirm=:date where activationCodeId=:id")
void updateDateConfirm(@Param("id") int activationCodeId, @Param("date") LocalDate dateConfirm);
}
