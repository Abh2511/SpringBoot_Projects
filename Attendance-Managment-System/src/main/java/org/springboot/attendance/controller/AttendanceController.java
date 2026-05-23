package org.springboot.attendance.controller;

import java.time.LocalDate;
import java.util.List;

import org.springboot.attendance.entity.Attendance;
import org.springboot.attendance.entity.ResponseStructure;
import org.springboot.attendance.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attendance")
public class AttendanceController 
{

  @Autowired
  private AttendanceService attendanceService;
  
  @PostMapping(path = "/mark-attendance")
  public ResponseEntity<ResponseStructure<Attendance>> markAttendance(@RequestBody Attendance attendance)
  {
	  return attendanceService.markAttendance(attendance);
  }
  
  @PutMapping(path = "/update-attendance/{id}")
  public ResponseEntity<ResponseStructure<Attendance>> updateAttendance(@RequestBody Attendance attendance , @PathVariable Integer id)
  {
	  return attendanceService.updateAttendance(attendance, id);
	  
  }
  
  @GetMapping(path = "/find-attendance-records-by/{id}")
  public ResponseEntity<ResponseStructure<Attendance>> findAttendanceRecordsById(Integer id)
  {
	  return attendanceService.findAttendanceRecordsById(id);
	  
  }
  
  @GetMapping(path = "/view-attendance-by-date")
  public ResponseEntity<ResponseStructure<List<Attendance>>> viewAttendanceByDate
  (@RequestParam  @DateTimeFormat(pattern = "yyyy-mm-dd") LocalDate date)
  {
	  return attendanceService.viewAttendanceByDate(date);
  }
  
  @GetMapping
  public ResponseEntity<ResponseStructure<List<Attendance>>> viewAllRecords()
  {
	  return attendanceService.viewAllRecords();
  }
  
  @DeleteMapping(path = "delete-records/{id}")
  public ResponseEntity<ResponseStructure<String>>deleteRecords(Integer id)
  {
	  return attendanceService.deleteRecords(id);
	  
	  
  }
}
