package com.example.demo.entity.concretes;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@Table(name = "jobadvertisements")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobAdvertisement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "job_description")
	private String jobDescription;
	@Column(name = "max_salary")
	private int maxSalary;
	@Column(name = "min_salary")
	private int minSalary;
	@Column(name = "dead_line")
	private Date deadLine;
	@Column(name = "active")
	private boolean active;
	@Column(name = "positionnumber")
	private int positionNumber;
	@Column(name = "creat_date")
	private Date creatDate;
	@ManyToOne()
	@MapsId
	@JoinColumn(name = "id")
	private JobTitle jobtitle;
	@ManyToOne()
	@MapsId
	@JoinColumn(name = "id")
	private Employer employer;
	

}
