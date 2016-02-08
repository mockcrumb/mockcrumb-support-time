package org.mockcrumb.support.time.json.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

import java.lang.reflect.Type;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimeDeserializer implements JsonDeserializer<ZonedDateTime> {
    @Override
    public ZonedDateTime deserialize(final JsonElement json, final Type typeOfT,
            final JsonDeserializationContext context) {
        return ZonedDateTime.parse(json.getAsJsonPrimitive().getAsString(), DateTimeFormatter.ISO_ZONED_DATE_TIME);
    }
}
