/**
 * 
 */
package com.tek.book.ebook.details;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class is controller class for the Type Master. Where it has the CRUD
 * operations.
 * 
 * @author Vinoth
 *
 */

@RestController
@RequestMapping("/books/details")
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private BookValidator bookValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(bookValidator);
	}

	/**
	 * This method is used to save or update the bookEntity into database.
	 * 
	 * @param bookEntity
	 * @return bookEntity
	 */
	@PostMapping(value = "/save", consumes = "application/json")
	public BookEntity save(@RequestBody @Valid BookEntity bookEntity) {
		return bookService.save(bookEntity);
	}

	/**
	 * This method is used to soft-delete the Type.
	 * 
	 * @param id
	 * @return bookEntity
	 */
	@GetMapping(value = "/delete/{id}")
	public BookEntity deleteType(@PathVariable(value = "id") Long id) {
		return bookService.deleteType(id);
	}

	/**
	 * This method is used to get the Type by given type id.
	 * 
	 * @param id
	 * @return bookEntity
	 */
	@GetMapping(value = "/find/{id}")
	public BookEntity findTypeById(@PathVariable(value = "id") Long id) {
		return bookService.findById(id);
	}

	/**
	 * This method is used to get the list of type.
	 * 
	 * @return Iterable<bookEntity>
	 */
	@GetMapping(value = "/findAll")
	public Iterable<BookEntity> findAll() {
		return bookService.findAll();
	}

	/**
	 * This method is used to get the Map of active type.
	 * 
	 * @return Map<String,Object>
	 */
	@GetMapping(value = "/findAllActive")
	public Map<String, Object> findAllActive() {
		return bookService.findAllActive();
	}

}
