/**
 * 
 */
package com.tek.book.ebook.utility;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

/**
 * @author Vinoth
 *
 */
public class LocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected LocalDateTimeDeserializer() {
		super(LocalDateTime.class);
	}

	@Override
	public LocalDateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException {
		String value = parser.readValueAs(String.class);
		if (value != null &&  !value.trim().isEmpty()) {
			return LocalDateTime.parse(value, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		}
		return LocalDateTime.now();
	}
}