/**
 * 
 */
package com.tek.book.ebook.details;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.tek.book.AbstractEntity;

/**
 * @author Vinoth
 *
 */
@Entity
@Table(name = "BOOK_DETAILS")
public class BookEntity extends AbstractEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	@Size(min = 2, max = 50, message = "bookName should have atleast 2 characters and upto 50 characters")
	@Column(nullable = false, length = 50, name = "BOOK_NAME")
	private String bookName;

	@NotNull
	@Size(max = 50, message = "author should have atleast 2 characters and upto 50 characters")
	@Column(nullable = false, length = 50, name = "BOOK_AUTHOR")
	private String author;

	@NotNull
	@Column(nullable = false, name = "BOOK_PRICE")
	private Double price;

	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}

	/**
	 * @param bookName
	 *            the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

}
