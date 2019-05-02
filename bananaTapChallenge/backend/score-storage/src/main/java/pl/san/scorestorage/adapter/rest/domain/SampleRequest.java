package pl.san.scorestorage.adapter.rest.domain;

import lombok.Value;

import java.time.OffsetDateTime;
import java.util.UUID;

@Value
public class SampleRequest {
     private UUID token;
     private OffsetDateTime occuredOn;
     private OffsetDateTime finishedOn;
     private Long count;
}
