package org.springboot.attendance.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="Attendance_Register")
public class Attendance 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String name;
	
	
	@Column(nullable = false)
	private String status;
	
	@Column(nullable = false)
	private String remarks;
	
	@Column(nullable = false , updatable = false)
	private LocalDate date;
	
	@PrePersist
	public void setDate() {
		this.date=LocalDate.now();
	}
	
	public Attendance() {
		super();
	}
	
	

	public Attendance(Integer id, String name, String status, String remarks, LocalDate date) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.remarks = remarks;
		this.date = date;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
		
}
