/**
 * 
 */
package com.tek.book.ebook.utility;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
 * @author Vinoth
 *
 */
public class LocalDateSerializer extends StdSerializer<LocalDate> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LocalDateSerializer() {
        super(LocalDate.class);
    }

	@Override
	public void serialize(LocalDate value, JsonGenerator generator, SerializerProvider provider) throws IOException {
		if (value != null && !value.toString().trim().isEmpty()) {
			generator.writeString(value.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		}

	}
}