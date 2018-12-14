/**
 * 
 */
package com.tek.book.ebook.details;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.tek.book.AppConstants;

/**
 * @author tekcyber
 *
 */
@Component
public class BookValidator implements Validator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return BookEntity.class.equals(clazz);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#validate(java.lang.Object,
	 * org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object target, Errors errors) {
		BookEntity bookEntity = (BookEntity) target;

		if (bookEntity.getBookName().matches(AppConstants.NUMBER)) {
			errors.rejectValue("bookName", "numeric not allowed");
		}

	}

}
