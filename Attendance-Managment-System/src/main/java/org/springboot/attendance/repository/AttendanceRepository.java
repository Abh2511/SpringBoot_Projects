package org.springboot.attendance.repository;

import java.time.LocalDate;
import java.util.List;

import org.springboot.attendance.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.persistence.Id;
import jakarta.persistence.criteria.From;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance,Integer> 
{
	
//	@Query("SELECT * From Attendance a WHERE a,date=:date")
//	
//	public List<Attendance> viewAttendanceByDate(LocalDate date);

}
