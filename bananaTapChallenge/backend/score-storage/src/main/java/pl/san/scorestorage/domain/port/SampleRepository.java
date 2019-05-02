package pl.san.scorestorage.domain.port;

import pl.san.scorestorage.domain.Sample;

import java.util.List;
import java.util.UUID;

public interface SampleRepository {
    void create(Sample sample);
    List<Sample> getSamplesByToken(UUID token);
}
