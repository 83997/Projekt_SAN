package pl.san.scorestorage.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.san.scorestorage.domain.Sample;
import pl.san.scorestorage.domain.port.SampleRepository;
import pl.san.scorestorage.domain.port.ScoreService;

import java.util.List;
import java.util.UUID;

@Service
public class DefaultScoreService implements ScoreService {

    @Autowired
    private SampleRepository sampleRepository;

    @Override
    public long getTotalScoreByToken(UUID tokenDevice) {
        List<Sample> samples = sampleRepository.getSamplesByToken(tokenDevice);
        long totalScore = samples.stream().mapToLong(sample -> sample.getScore()).sum();
        return totalScore;
    }

    @Override
    public List<Long> getTopTotalScores(int count) {
        List<Long> topScores = sampleRepository.getTopTotalScores(count);
        return topScores;
    }
}
