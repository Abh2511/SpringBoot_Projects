package org.springboot.notesmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springboot.notesmanagementsystem.entity.Notes;
import org.springboot.notesmanagementsystem.entity.ResponseStructure;
import org.springboot.notesmanagementsystem.exception.NotesNotFoundException;
import org.springboot.notesmanagementsystem.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class NotesService 
{
	@Autowired
    private	NotesRepository notesRepository;
	
	public ResponseEntity<ResponseStructure<Notes>> createNotes(Notes notes)
	{
		ResponseStructure<Notes> structure = new ResponseStructure<>();
		
		structure.setData(notesRepository.save(notes));
		structure.setMessage("Created Successfully");
		structure.setStatusCode(HttpStatus.CREATED.value());
		
		return new ResponseEntity<ResponseStructure<Notes>> (structure, HttpStatus.CREATED);
		
	}
	
	public ResponseEntity<ResponseStructure<Notes>> updateNotes(Notes notes,Integer id)
	{
		
		ResponseStructure<Notes> structure = new ResponseStructure<>();
	    
		Optional<Notes> recNotes =notesRepository.findById(id);
	    
		if(recNotes.isPresent())
				{
			Notes exisNotes = recNotes.get();
			
			exisNotes.setTitle(notes.getTitle());
			exisNotes.setContent(notes.getContent());
			
			Notes updateNotes = notesRepository.save(exisNotes);
			
			structure.setData(updateNotes);
			structure.setMessage("Notes Updated Sucessfully");
			structure.setStatusCode(HttpStatus.OK.value());
			
			return new ResponseEntity<ResponseStructure<Notes>> (structure,HttpStatus.OK);		
			
				}
		    throw new NotesNotFoundException("Notes Not Found");
		
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteNotes(Integer id){
		ResponseStructure<String> structure = new ResponseStructure<>();
		
		Optional<Notes> recNotes =  notesRepository.findById(id);
		
		if(recNotes.isPresent()) {
			notesRepository.deleteById(id);
			structure.setData("Notes delete sucessfully");
			structure.setMessage("Success");
			structure.setStatusCode(HttpStatus.OK.value());
			
			return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.OK);
		}
		throw new NotesNotFoundException("Notes Not Found Exception");
	}
	
	public ResponseEntity<ResponseStructure<List<Notes>>> viewAllNotes()
	{
	    ResponseStructure<List<Notes>> structure = new ResponseStructure<>();

	    List<Notes> recNotes = notesRepository.findAll();

	    if(recNotes.size() > 0)
	    {
	        structure.setMessage("Notes Found");
	        structure.setData(recNotes);
	        structure.setStatusCode(HttpStatus.OK.value());

	        return new ResponseEntity<ResponseStructure<List<Notes>>>(structure, HttpStatus.OK);
	    }

	    throw new NotesNotFoundException("Notes Not Found");
	}
	

}
