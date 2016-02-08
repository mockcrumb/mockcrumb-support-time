package org.mockcrumb.support.time.json.gson;

import com.google.gson.JsonElement;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class LocalDateSerializerTest {
    private LocalDateSerializer serializer = new LocalDateSerializer();

    @Test
    public void shouldSerialize() {
        // Given && When
        JsonElement serialized1 = serializer.serialize(LocalDate.of(2015, 1, 1), null, null);
        JsonElement serialized2 = serializer.serialize(LocalDate.of(2015, 1, 11), null, null);
        JsonElement serialized3 = serializer.serialize(LocalDate.of(2015, 11, 1), null, null);
        JsonElement serialized4 = serializer.serialize(LocalDate.of(2015, 11, 11), null, null);

        // Then
        assertThat(serialized1.getAsString()).isEqualTo("2015-01-01");
        assertThat(serialized2.getAsString()).isEqualTo("2015-01-11");
        assertThat(serialized3.getAsString()).isEqualTo("2015-11-01");
        assertThat(serialized4.getAsString()).isEqualTo("2015-11-11");
    }
}
