package pl.san.scorestorage.domain.port;

import java.util.UUID;

public interface ScoreService {
    long getTotalScoreByToken(UUID tokenDevice);
}
