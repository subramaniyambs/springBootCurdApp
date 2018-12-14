package com.tek.book.ebook.exception;

public class ChainageOverlapException extends RuntimeException {

	
	  /**
		 * Chainage Overlap exception
		 */
		private static final long serialVersionUID = 1L;

		public ChainageOverlapException(String message) {
	        super(message);
	    }

	    public ChainageOverlapException(String message, Throwable cause) {
	        super(message, cause);
	    }
}
