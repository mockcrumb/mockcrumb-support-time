package org.mockcrumb.support.time.json.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimeSerializer implements JsonSerializer<ZonedDateTime> {
    @Override
    public JsonElement serialize(final ZonedDateTime src, final Type typeOfSrc,
            final JsonSerializationContext context) {
        return new JsonPrimitive(src.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
    }
}
