package org.mockcrumb.support.time.json.gson;

import com.google.gson.JsonPrimitive;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class LocalDateTimeDeserializerTest {
    private LocalDateTimeDeserializer deserializer = new LocalDateTimeDeserializer();

    @Test
    public void shouldSerialize() {
        // Given && When
        LocalDateTime deserialized1 = deserializer.deserialize(new JsonPrimitive("2015-01-01T11:07:03"), null, null);
        LocalDateTime deserialized2 = deserializer.deserialize(new JsonPrimitive("2015-01-11T11:12:00"), null, null);
        LocalDateTime deserialized3 = deserializer.deserialize(new JsonPrimitive("2015-11-01T06:11:00"), null, null);
        LocalDateTime deserialized4 = deserializer.deserialize(new JsonPrimitive("2015-11-11T08:08:08"), null, null);

        // Then
        assertThat(deserialized1).isEqualTo(LocalDateTime.of(2015, 1, 1, 11, 7, 3));
        assertThat(deserialized2).isEqualTo(LocalDateTime.of(2015, 1, 11, 11, 12));
        assertThat(deserialized3).isEqualTo(LocalDateTime.of(2015, 11, 1, 6, 11));
        assertThat(deserialized4).isEqualTo(LocalDateTime.of(2015, 11, 11, 8, 8, 8));
    }
}
