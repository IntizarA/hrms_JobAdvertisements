package com.example.demo.entity.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
public class Employer {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "company_name")
	private String company_name;
	@Column(name = "web_address")

	private String web_address;
	@Column(name = "phone_number")

	private String phone_number;
	
	
	@OneToOne()
	@MapsId
	@JoinColumn(name="id")
	private User user;
	
}
