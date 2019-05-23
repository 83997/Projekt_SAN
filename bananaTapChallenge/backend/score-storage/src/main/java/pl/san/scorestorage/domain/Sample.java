package pl.san.scorestorage.domain;

import lombok.Value;

import java.time.OffsetDateTime;
import java.util.UUID;

@Value
public class Sample {

    private UUID tokenDevice;
    private OffsetDateTime occuredOn;
    private OffsetDateTime finishedOn;
    private Long count;
    private Long score;
}
