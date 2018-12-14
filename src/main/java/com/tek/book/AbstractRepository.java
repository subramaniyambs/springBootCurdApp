/**
 * 
 */
package com.tek.book;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Vinoth
 *
 */
public interface AbstractRepository<T, ID> extends  CrudRepository<T,ID>{
	
	List<T> findByCreatedBy(String createdBy);

	List<T> findByUpdatedBy(String updatedBy);

	List<T> findByCreatedOn(LocalDate createdOn);

	List<T> findByUpdatedOn(LocalDate updatedOn);

	List<T> findByStatus(String status);
	

}

