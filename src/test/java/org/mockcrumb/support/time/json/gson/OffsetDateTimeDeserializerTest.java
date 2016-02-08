package org.mockcrumb.support.time.json.gson;

import com.google.gson.JsonPrimitive;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static org.assertj.core.api.Assertions.assertThat;

public class OffsetDateTimeDeserializerTest {
    private OffsetDateTimeDeserializer deserializer = new OffsetDateTimeDeserializer();

    @Test
    public void shouldSerialize() {
        // Given && When
        OffsetDateTime deserialized1 = deserializer.deserialize(new JsonPrimitive("2015-01-01T11:07:03Z"), null, null);
        OffsetDateTime deserialized2 = deserializer.deserialize(new JsonPrimitive("2015-01-11T11:12:00+02:00"), null, null);
        OffsetDateTime deserialized3 = deserializer.deserialize(new JsonPrimitive("2015-11-01T06:11:00-01:00"), null, null);
        OffsetDateTime deserialized4 = deserializer.deserialize(new JsonPrimitive("2015-11-11T08:08:08Z"), null, null);

        // Then
        assertThat(deserialized1).isEqualTo(OffsetDateTime.of(LocalDateTime.of(2015, 1, 1, 11, 7, 3), ZoneOffset.UTC));
        assertThat(deserialized2).isEqualTo(OffsetDateTime.of(LocalDateTime.of(2015, 1, 11, 11, 12), ZoneOffset.ofHours(2)));
        assertThat(deserialized3).isEqualTo(OffsetDateTime.of(LocalDateTime.of(2015, 11, 1, 6, 11), ZoneOffset.ofHours(-1)));
        assertThat(deserialized4).isEqualTo(OffsetDateTime.of(LocalDateTime.of(2015, 11, 11, 8, 8, 8), ZoneOffset.UTC));
    }
}
