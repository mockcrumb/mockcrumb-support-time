package org.mockcrumb.support.time.json.gson;

import com.google.gson.JsonPrimitive;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class ZonedDateTimeDeserializerTest {
    private ZonedDateTimeDeserializer deserializer = new ZonedDateTimeDeserializer();

    @Test
    public void shouldSerialize() {
        // Given && When
        ZonedDateTime deserialized1 = deserializer.deserialize(new JsonPrimitive("2015-01-01T11:07:03Z[Europe/London]"), null, null);
        ZonedDateTime deserialized2 = deserializer.deserialize(new JsonPrimitive("2015-01-11T11:12:00+02:00[Europe/Warsaw]"), null, null);
        ZonedDateTime deserialized3 = deserializer.deserialize(new JsonPrimitive("2015-11-01T06:11:00-03:00[Brazil/West]"), null, null);
        ZonedDateTime deserialized4 = deserializer.deserialize(new JsonPrimitive("2015-11-11T08:08:08Z[Europe/Dublin]"), null, null);

        // Then
        assertThat(deserialized1).isEqualTo(ZonedDateTime.of(LocalDateTime.of(2015, 1, 1, 11, 7, 3), ZoneId.of("Europe/London")));
        assertThat(deserialized2).isEqualTo(ZonedDateTime.of(LocalDateTime.of(2015, 1, 11, 11, 12), ZoneId.of("Europe/Warsaw")));
        assertThat(deserialized3).isEqualTo(ZonedDateTime.of(LocalDateTime.of(2015, 11, 1, 6, 11), ZoneId.of("Brazil/West")));
        assertThat(deserialized4).isEqualTo(ZonedDateTime.of(LocalDateTime.of(2015, 11, 11, 8, 8, 8), ZoneId.of("Europe/Dublin")));
    }
}
