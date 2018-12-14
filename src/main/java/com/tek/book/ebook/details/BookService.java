/**
 * 
 */
package com.tek.book.ebook.details;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class is contains the business events which are related to Type.
 * 
 * @author Vinoth
 *
 */

@Service
public class BookService {

	private final BookRepository bookRepository;
	private final JdbcTemplate jdbcTemplate;
	
	@Value("${sql.type.findAllActive}")
	private String findAllActive;
	@Value("${sql.type.findByTypeName}")
	private String findByTypeName;

	/**
	 * Parameterized constructor with entity, queries and datasource
	 * 
	 * @param bookRepository
	 * @param dataSource
	 */
	public BookService(BookRepository bookRepository, DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.bookRepository = bookRepository;
	}

	/**
	 * This method is used to save or update the type entity
	 * 
	 * @param bookEntity
	 * @return
	 */
	@Transactional
	public BookEntity save(BookEntity bookEntity) {
			return bookRepository.save(bookEntity);
	}

	/**
	 * This method is used to do soft-delete the type.
	 * 
	 * @param id
	 * @return
	 */
	@Transactional
	public BookEntity deleteType(Long id) {
		BookEntity bookEntity = bookRepository.findById(id).get();
		bookEntity.setStatus("1");
		return bookRepository.save(bookEntity);
	}

	/**
	 * This method is used to find the specific type by id, irrespective of the
	 * status.
	 * 
	 * @param id
	 * @return bookEntity
	 */
	@Transactional(readOnly = true)
	public BookEntity findById(Long id) {
		return bookRepository.findById(id).get();
	}

	/**
	 * This method is used to get the list of types, irrespective of the status
	 * of each type.
	 * 
	 * @return Iterable<BookEntity>
	 */
	@Transactional(readOnly = true)
	public Iterable<BookEntity> findAll() {
		return bookRepository.findAll();
	}
	
	/**
	 * This method is used to get the HashMap of active types.
	 * 
	 * @return Iterable<BookEntity>
	 */
	@Transactional(readOnly = true)
	public Map<String, Object> findAllActive() {
		List<Map<String,Object>> dataList = jdbcTemplate.queryForList(findAllActive);
		Map<String, Object> resultData = new HashMap<>();
		resultData.put("totalRecords", dataList.size());
		resultData.put("curPage", 1);
		resultData.put("data", dataList);
		return resultData;
	}
}
