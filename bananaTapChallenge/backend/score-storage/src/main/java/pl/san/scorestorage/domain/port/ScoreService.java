package pl.san.scorestorage.domain.port;

import pl.san.scorestorage.domain.Score;

import java.util.List;
import java.util.UUID;

public interface ScoreService {
    Score getTotalScoreByToken(UUID tokenDevice);
    List<Score> getTopTotalScores(int count);
}
