package org.mockcrumb.support.time.json.gson;

import com.google.gson.JsonElement;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static org.assertj.core.api.Assertions.assertThat;

public class OffsetDateTimeSerializerTest {
    private OffsetDateTimeSerializer serializer = new OffsetDateTimeSerializer();

    @Test
    public void shouldSerialize() {
        // Given && When
        JsonElement serialized1 = serializer.serialize(
                OffsetDateTime.of(LocalDateTime.of(2015, 1, 1, 17, 15), ZoneOffset.UTC), null, null);
        JsonElement serialized2 = serializer.serialize(
                OffsetDateTime.of(LocalDateTime.of(2015, 1, 11, 9, 8), ZoneOffset.ofHours(2)), null, null);
        JsonElement serialized3 = serializer.serialize(
                OffsetDateTime.of(LocalDateTime.of(2015, 11, 1, 12, 11, 3), ZoneOffset.ofHours(-1)), null, null);
        JsonElement serialized4 = serializer.serialize(
                OffsetDateTime.of(LocalDateTime.of(2015, 11, 11, 1, 2, 14), ZoneOffset.UTC), null, null);

        // Then
        assertThat(serialized1.getAsString()).isEqualTo("2015-01-01T17:15:00Z");
        assertThat(serialized2.getAsString()).isEqualTo("2015-01-11T09:08:00+02:00");
        assertThat(serialized3.getAsString()).isEqualTo("2015-11-01T12:11:03-01:00");
        assertThat(serialized4.getAsString()).isEqualTo("2015-11-11T01:02:14Z");
    }
}
