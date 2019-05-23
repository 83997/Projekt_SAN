package pl.san.scorestorage.domain.port;

import java.time.OffsetDateTime;
import java.util.UUID;

public interface SampleService {
    long createSample(UUID tokenDevice, OffsetDateTime occuredOn, OffsetDateTime finishedOn, Long count);
}
