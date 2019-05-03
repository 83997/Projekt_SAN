package pl.san.scorestorage.domain.port;

import java.util.List;
import java.util.UUID;

public interface ScoreService {
    long getTotalScoreByToken(UUID tokenDevice);
    List<Long> getTopTotalScores(int count);
}
