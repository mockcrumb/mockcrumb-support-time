package org.mockcrumb.support.time.reader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.mockcrumb.reader.CrumbReader;
import org.mockcrumb.support.time.json.gson.LocalDateDeserializer;
import org.mockcrumb.support.time.json.gson.LocalDateSerializer;
import org.mockcrumb.support.time.json.gson.LocalDateTimeDeserializer;
import org.mockcrumb.support.time.json.gson.LocalDateTimeSerializer;
import org.mockcrumb.support.time.json.gson.OffsetDateTimeDeserializer;
import org.mockcrumb.support.time.json.gson.OffsetDateTimeSerializer;
import org.mockcrumb.support.time.json.gson.ZonedDateTimeDeserializer;
import org.mockcrumb.support.time.json.gson.ZonedDateTimeSerializer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

public class TimeSupportedJsonCrumbReader implements CrumbReader {
    public static final TimeSupportedJsonCrumbReader INSTANCE = new TimeSupportedJsonCrumbReader();

    private static final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
            .registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer())
            .registerTypeAdapter(OffsetDateTime.class, new OffsetDateTimeSerializer())
            .registerTypeAdapter(OffsetDateTime.class, new OffsetDateTimeDeserializer())
            .registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeSerializer())
            .registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeDeserializer())
            .create();

    public <T> T read(final Class<T> clazz, final Path path) throws IOException {
        StringBuilder builder = new StringBuilder();
        for (String line : Files.readAllLines(path)) {
            builder.append(line);
        }
        return GSON.fromJson(builder.toString(), clazz);
    }
}
