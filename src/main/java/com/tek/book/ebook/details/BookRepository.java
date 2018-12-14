/**
 * 
 */
package com.tek.book.ebook.details;

import java.util.List;

import com.tek.book.AbstractRepository;

/**
 * @author Vinoth
 *
 */
public interface BookRepository extends AbstractRepository<BookEntity, Long> {

	List<BookEntity> findByBookName(String bookName);

}
