package pl.san.scorestorage.domain.port;

import pl.san.scorestorage.domain.Sample;

public interface SampleRepository {
    void create(Sample sample);
}
