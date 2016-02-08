package org.mockcrumb.support.time.json.gson;

import com.google.gson.JsonElement;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class ZonedDateTimeSerializerTest {
    private ZonedDateTimeSerializer serializer = new ZonedDateTimeSerializer();

    @Test
    public void shouldSerialize() {
        // Given && When
        JsonElement serialized1 = serializer.serialize(
                ZonedDateTime.of(LocalDateTime.of(2015, 1, 1, 17, 15), ZoneId.of("Europe/London")), null, null);
        JsonElement serialized2 = serializer.serialize(
                ZonedDateTime.of(LocalDateTime.of(2015, 1, 11, 9, 8), ZoneId.of("Europe/Warsaw")), null, null);
        JsonElement serialized3 = serializer.serialize(
                ZonedDateTime.of(LocalDateTime.of(2015, 11, 1, 12, 11, 3), ZoneId.of("Brazil/East")), null, null);
        JsonElement serialized4 = serializer.serialize(
                ZonedDateTime.of(LocalDateTime.of(2015, 11, 11, 1, 2, 14), ZoneId.of("Europe/Dublin")), null, null);

        // Then
        assertThat(serialized1.getAsString()).isEqualTo("2015-01-01T17:15:00Z[Europe/London]");
        assertThat(serialized2.getAsString()).isEqualTo("2015-01-11T09:08:00+01:00[Europe/Warsaw]");
        assertThat(serialized3.getAsString()).isEqualTo("2015-11-01T12:11:03-02:00[Brazil/East]");
        assertThat(serialized4.getAsString()).isEqualTo("2015-11-11T01:02:14Z[Europe/Dublin]");
    }
}
