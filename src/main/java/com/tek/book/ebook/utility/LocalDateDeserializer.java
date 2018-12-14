/**
 * 
 */
package com.tek.book.ebook.utility;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

/**
 * @author Vinoth
 *
 */
public class LocalDateDeserializer extends StdDeserializer<LocalDate> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected LocalDateDeserializer() {
        super(LocalDate.class);
    }

    @Override
    public LocalDate deserialize(JsonParser parser, DeserializationContext context) throws IOException {
    	String value = parser.readValueAs(String.class);
		if (value != null &&  !value.trim().isEmpty()) {
			return LocalDate.parse(value, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		}
		return LocalDate.now();
    }
}