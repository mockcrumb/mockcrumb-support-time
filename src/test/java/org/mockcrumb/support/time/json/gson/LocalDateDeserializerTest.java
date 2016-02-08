package org.mockcrumb.support.time.json.gson;

import com.google.gson.JsonPrimitive;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class LocalDateDeserializerTest {
    private LocalDateDeserializer deserializer = new LocalDateDeserializer();

    @Test
    public void shouldSerialize() {
        // Given && When
        LocalDate deserialized1 = deserializer.deserialize(new JsonPrimitive("2015-01-01"), null, null);
        LocalDate deserialized2 = deserializer.deserialize(new JsonPrimitive("2015-01-11"), null, null);
        LocalDate deserialized3 = deserializer.deserialize(new JsonPrimitive("2015-11-01"), null, null);
        LocalDate deserialized4 = deserializer.deserialize(new JsonPrimitive("2015-11-11"), null, null);

        // Then
        assertThat(deserialized1).isEqualTo(LocalDate.of(2015, 1, 1));
        assertThat(deserialized2).isEqualTo(LocalDate.of(2015, 1, 11));
        assertThat(deserialized3).isEqualTo(LocalDate.of(2015, 11, 1));
        assertThat(deserialized4).isEqualTo(LocalDate.of(2015, 11, 11));
    }
}
