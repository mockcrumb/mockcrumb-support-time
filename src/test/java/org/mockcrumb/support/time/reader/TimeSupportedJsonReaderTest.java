package org.mockcrumb.support.time.reader;

import org.junit.Test;
import org.mockcrumb.support.time.test.Sample;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class TimeSupportedJsonReaderTest {
    // TODO(maciej.abacus.gowin@gmail.com) Add failure tests

    @Test
    public void shouldRead() {
        try {
            // Given && When
            Path sample1Path = Paths.get(TimeSupportedJsonReaderTest.class.getClassLoader()
                    .getResource("data/sample1.json").toURI());
            Sample sample1 = TimeSupportedJsonCrumbReader.INSTANCE.read(Sample.class, sample1Path);

            // Then
            assertThat(sample1.getName())
                    .isEqualTo("sample1");

            assertThat(sample1.getCustomLocalDate())
                    .isEqualTo(LocalDate.of(2011, 2, 3));

            assertThat(sample1.getCustomLocalDateTime())
                    .isEqualTo(LocalDateTime.of(2011, 2, 3, 4, 5, 6));

            assertThat(sample1.getCustomOffsetDateTimeZulu())
                    .isEqualTo(OffsetDateTime.of(LocalDateTime.of(2011, 2, 3, 4, 5, 6), ZoneOffset.UTC));
            assertThat(sample1.getCustomOffsetDateTimeZero())
                    .isEqualTo(OffsetDateTime.of(LocalDateTime.of(2011, 2, 3, 4, 5, 6), ZoneOffset.UTC));
            assertThat(sample1.getCustomOffsetDateTimeMinus())
                    .isEqualTo(OffsetDateTime.of(LocalDateTime.of(2011, 2, 3, 4, 5, 6), ZoneOffset.ofHours(-7)));
            assertThat(sample1.getCustomOffsetDateTimePlus())
                    .isEqualTo(OffsetDateTime.of(LocalDateTime.of(2011, 2, 3, 4, 5, 6), ZoneOffset.ofHours(7)));

            assertThat(sample1.getCustomZonedDateTimeZulu())
                    .isEqualTo(ZonedDateTime.of(LocalDateTime.of(2011, 2, 3, 4, 5, 6), ZoneId.of("Europe/London")));
            assertThat(sample1.getCustomZonedDateTimeZero())
                    .isEqualTo(ZonedDateTime.of(LocalDateTime.of(2011, 2, 3, 4, 5, 6), ZoneId.of("Europe/London")));
            assertThat(sample1.getCustomZonedDateTimeMinus())
                    .isEqualTo(ZonedDateTime.of(LocalDateTime.of(2011, 2, 3, 4, 5, 6), ZoneId.of("Brazil/East")));
            assertThat(sample1.getCustomZonedDateTimePlus())
                    .isEqualTo(ZonedDateTime.of(LocalDateTime.of(2011, 2, 3, 4, 5, 6), ZoneId.of("Europe/Warsaw")));
        } catch (URISyntaxException | IOException e) {
            fail(e.getMessage());
        }
    }
}
