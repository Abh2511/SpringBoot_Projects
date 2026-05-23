package org.springboot.attendance.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.hibernate.cache.spi.entry.StructuredCacheEntry;
import org.springboot.attendance.entity.Attendance;
import org.springboot.attendance.entity.ResponseStructure;
import org.springboot.attendance.exception.AttendanceNotFoundException;
import org.springboot.attendance.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {
	
	@Autowired
	private AttendanceRepository attendanceRepository;
  
	// MarkAttendance API
	public ResponseEntity<ResponseStructure<Attendance>> markAttendance(Attendance attendance)
	{
		ResponseStructure<Attendance> structure = new ResponseStructure<>();
		structure.setMessage("Attendance Marked Successfully");
		structure.setData(attendanceRepository.save(attendance));
		structure.setStatusCode(HttpStatus.CREATED.value());
		
		return new ResponseEntity<ResponseStructure<Attendance>> (structure,HttpStatus.CREATED);
   }
	
	// updateAttendance API
	public ResponseEntity<ResponseStructure<Attendance>> updateAttendance(Attendance attendance , Integer id){
		
		ResponseStructure<Attendance> structure = new ResponseStructure<>();
		
		Optional<Attendance> recAttendance = attendanceRepository.findById(id);
		
		if(recAttendance.isPresent()) 
		{
			Attendance existAttendance = recAttendance.get();
			
			existAttendance.setName(attendance.getName());
		    existAttendance.setStatus(attendance.getStatus());
		    existAttendance.setRemarks(attendance.getRemarks());
		    
		    Attendance updAttendance = attendanceRepository.save(existAttendance);
		     
		    structure.setMessage("Attendance Update Successfully");
		    structure.setData(updAttendance);
		    structure.setStatusCode(HttpStatus.OK.value());
		    
		    return new ResponseEntity<ResponseStructure<Attendance>> (structure,HttpStatus.OK);
		    
		}
		throw new AttendanceNotFoundException(id + "Entered Id Is Wrong !");
	}
	
	// findAttendanceRecordsByID API
	public ResponseEntity<ResponseStructure<Attendance>> findAttendanceRecordsById(Integer id)
	{
		ResponseStructure<Attendance> structure = new ResponseStructure<>();
		
		Optional<Attendance> recAttendance = attendanceRepository.findById(id);
		
		if(recAttendance.isPresent()) {
			structure.setMessage("Attendance Records Found");
			structure.setData(recAttendance.get());
			structure.setStatusCode(HttpStatus.OK.value());;
			
			return new ResponseEntity<ResponseStructure<Attendance>>(structure,HttpStatus.OK);
		}
		throw new AttendanceNotFoundException(id + " Attendance records is not found");
	}
	
	// View Attendance by Date API
	public ResponseEntity<ResponseStructure<List<Attendance>>> viewAttendanceByDate(LocalDate date)
	{
		ResponseStructure<List<Attendance>> structure = new ResponseStructure<>();
		
		List<Attendance> recAttendances = attendanceRepository.findAll();
		
		if(recAttendances.size()>0) {
			
			structure.setData(recAttendances);
			structure.setMessage("Attendance Found in the data of : " +date);
			structure.setStatusCode(HttpStatus.OK.value());
		
			return new ResponseEntity<ResponseStructure<List<Attendance>>> (structure,HttpStatus.OK);
			
		}
		throw new AttendanceNotFoundException("Attendance not found in the date of : "+date);
		
	}
	
	// viewAllRecords API
	public ResponseEntity<ResponseStructure<List<Attendance>>> viewAllRecords()
	{
		ResponseStructure<List<Attendance>> structure = new ResponseStructure<>();
        
		List<Attendance> recAttendance = attendanceRepository.findAll();
		
		if(recAttendance.size()>0)
		{
			structure.setMessage("Attendance Records Found");
			structure.setData(recAttendance);
			structure.setStatusCode(HttpStatus.OK.value());
			
			return new ResponseEntity<ResponseStructure<List<Attendance>>>(structure,HttpStatus.OK);
				}
          throw new AttendanceNotFoundException("Attendance is not found !");
     }
	
	 public ResponseEntity<ResponseStructure<String>>deleteRecords(Integer id){
		 ResponseStructure<String> structure = new ResponseStructure<>();
		 
		 Optional<Attendance> recAttendance = attendanceRepository.findById(id);
		 
		 if(recAttendance.isPresent()) {
			 attendanceRepository.deleteById(id);
			 structure.setData("Attendance Deleted Successfully");
			 structure.setMessage("Success");
			 structure.setStatusCode(HttpStatus.OK.value());
			 
			 return new ResponseEntity<ResponseStructure<String>> (structure,HttpStatus.OK);
		 }
		throw new AttendanceNotFoundException("The Given Id" +id + "is Not Present");
	 }
}