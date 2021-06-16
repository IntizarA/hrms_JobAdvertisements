package com.example.demo.entity.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "activation_codes")
@AllArgsConstructor
@NoArgsConstructor
public class ActivationCode {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "activation_code_id")
	private int activationCodeId;

	@Column(name = "activatio_code")
	private String activatioCode;
	@Column(name = "is_confirmed")
	private boolean isConfirmed;
	@Column(name = "date_confirm")
	private LocalDate dateConfirm;
	
}
