/**
 * 
 */
package org.springboot.notesmanagementsystem.repository;

import org.springboot.notesmanagementsystem.entity.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 */
@Repository
public interface NotesRepository extends JpaRepository<Notes,Integer>
{
	

}
